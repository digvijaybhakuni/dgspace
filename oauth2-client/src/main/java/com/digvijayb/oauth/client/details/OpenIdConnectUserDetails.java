package com.digvijayb.oauth.client.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class OpenIdConnectUserDetails implements UserDetails {

    private String userId;
    private String username;
    private OAuth2AccessToken token;

    private Collection<? extends GrantedAuthority>  authorities;
    private boolean auth = false;

    public OpenIdConnectUserDetails(Map<String, String> userInfo, OAuth2AccessToken token) {
        this.userId = userInfo.get("sub");
        this.username = userInfo.get("email");
        this.token = token;
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
        this.auth = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return auth;
    }

    @Override
    public boolean isAccountNonLocked() {
        return auth;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.auth;
    }

    @Override
    public boolean isEnabled() {
        return this.auth;
    }
}
