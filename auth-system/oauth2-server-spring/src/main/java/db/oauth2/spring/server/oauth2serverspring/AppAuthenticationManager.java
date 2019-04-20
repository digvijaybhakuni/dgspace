package db.oauth2.spring.server.oauth2serverspring;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final Object principal = authentication.getPrincipal();
        final Object credentials = authentication.getCredentials();
        if ("bob".equals(principal) && "jone".equals(credentials)) {
            Map<String, String> authInfo = new HashMap<String, String>() {
                {
                    put("sub", "bob");
                    put("email", "bob@mail.com");
                }
            };
            System.out.println("authentication = " + authentication);
            return authentication;
        }
        throw new BadCredentialsException("ESP Authentication Provider : Bad Credentials");
    }

}