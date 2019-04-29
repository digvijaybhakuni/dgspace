package com.digvijayb.oauth.client.config;

import com.digvijayb.oauth.client.filter.OpenIdConnectFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired @Qualifier("oidcRestTemplate")
    private OAuth2RestTemplate restTemplate;

    @Value("${oidc.token.jwkurl}")
    private String jwkUrl;

    @Value("${oidc.token.issuer}")
    private String issuer;

    @Value("${oidc.client.id}")
    private String clientId;

    @Value("${oidc.userInfoUri}")
    private String userInfoUri;

    @Bean
    public OpenIdConnectFilter openIdConnectFilter() {
        OpenIdConnectFilter filter = new OpenIdConnectFilter("/oidc_auth", restTemplate, jwkUrl, clientId, issuer, userInfoUri);
        return filter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .addFilterAfter(new OAuth2ClientContextFilter(),
//                        AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterBefore(openIdConnectFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .httpBasic()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/oidc_auth"))
                .and()
                .authorizeRequests()
                // .antMatchers("/oidc_auth**").permitAll()
                .anyRequest().authenticated();
    }

}
