package com.digvijayb.oauth.client.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;

@Configuration
@EnableOAuth2Client
public class OIDCConfig {

    @Value("${oidc.client.id}")
    private String clientId;

    @Value("${oidc.client.secret}")
    private String clientSecret;

    @Value("${oidc.accessTokenUri}")
    private String accessTokenUri;

    @Value("${oidc.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${oidc.redirectUri}")
    private String redirectUri;

    @Value("${oidc.token.name}")
    private String tokenName;

    @Value("${oidc.clientAuthenticationScheme}")
    private String clientAuthenticationScheme;


    @Value("${oidc.authenticationScheme}")
    private String authenticationScheme;


    @Bean
    public OAuth2ProtectedResourceDetails oidcResourceDetails() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setScope(Arrays.asList("openid", "email"));
        details.setPreEstablishedRedirectUri(redirectUri);
        details.setUseCurrentUri(false);
        if (authenticationScheme != null) {
            details.setAuthenticationScheme(AuthenticationScheme.valueOf(authenticationScheme));
        }
        if (clientAuthenticationScheme != null) {
            details.setClientAuthenticationScheme(AuthenticationScheme.valueOf(clientAuthenticationScheme));
        }
        return details;
    }


    @Bean("oidcRestTemplate")
    public OAuth2RestTemplate oidcRestTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(oidcResourceDetails(), clientContext);
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

}
