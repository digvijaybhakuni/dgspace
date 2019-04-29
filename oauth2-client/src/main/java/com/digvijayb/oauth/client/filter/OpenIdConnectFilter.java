package com.digvijayb.oauth.client.filter;


import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.digvijayb.oauth.client.details.OpenIdConnectUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Slf4j
public class OpenIdConnectFilter extends AbstractAuthenticationProcessingFilter {

    private OAuth2RestTemplate restTemplate;
    private String jwkUrl;
    private String clientId;
    private String issuer;

    private UserInfoTokenServices tokenServices;


    public OpenIdConnectFilter(String defaultFilterProcessesUrl, OAuth2RestTemplate restTemplate,
                               String jwkUrl, String clientId, String issuer, String userInfoUri) {
        super(defaultFilterProcessesUrl);
        this.restTemplate = restTemplate;
        this.jwkUrl = jwkUrl;
        this.clientId = clientId;
        this.issuer = issuer;
        this.tokenServices = new UserInfoTokenServices(userInfoUri, clientId);
        tokenServices.setRestTemplate(restTemplate);
        this.setAuthenticationManager(auth -> null);
    }


    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        log.debug("attemptAuthentication : req : {} ", request.getRequestURL().toString());
        OAuth2AccessToken accessToken;
        try {
            accessToken = this.restTemplate.getAccessToken();
        } catch (OAuth2Exception e) {
            log.debug("accessToken exception : {}", e.getSummary());
            log.error("OAuth2Exception", e);
            throw new BadCredentialsException("Could not obtain access token", e);
        }
        try {
            /*String idToken = accessToken.getAdditionalInformation().get("id_token").toString();
            String kid = JwtHelper.headers(idToken).get("kid");
            // Jwt tokenDecoded = JwtHelper.decodeAndVerify(idToken, verifier(kid));
            Jwt tokenDecoded = JwtHelper.decode(idToken);
            Map<String, String> authInfo = new ObjectMapper()
                    .readValue(tokenDecoded.getClaims(), Map.class);
            verifyClaims(authInfo);
            */
            OAuth2Authentication result = tokenServices.loadAuthentication(accessToken.getValue());
            writeUserInfo(result);
            OpenIdConnectUserDetails user = new OpenIdConnectUserDetails(result, accessToken);
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        } catch (InvalidTokenException e) {
            throw new BadCredentialsException("Could not obtain user details from token", e);
        } catch (Exception e){
            throw new AuthenticationServiceException("Authentication Fail : " + e.getMessage(), e.getCause());
        }
    }

    public void verifyClaims(Map claims) {
        log.debug("verifyClaims : {}", claims);
        int exp = (int) claims.get("exp");
        Date expireDate = new Date(exp * 1000L);
        Date now = new Date();
        if (expireDate.before(now) || !claims.get("iss").equals(issuer) ||
                !claims.get("aud").equals(clientId)) {
            throw new RuntimeException("Invalid claims");
        }
    }

    private RsaVerifier verifier(String kid) throws Exception {
        log.debug("verifier : {}", kid);
        JwkProvider provider = new UrlJwkProvider(new URL(jwkUrl));
        Jwk jwk = provider.get(kid);
        return new RsaVerifier((RSAPublicKey) jwk.getPublicKey());
    }

    private void writeUserInfo(OAuth2Authentication result){
        try {
            StringWriter stringWriter = new StringWriter();
            new ObjectMapper().writeValue(stringWriter, result);
            log.debug("UserInfo : {} ", stringWriter.getBuffer().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
