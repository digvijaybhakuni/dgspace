package com.dgstack.app.vertx.handler;

import com.dgstack.app.vertx.utils.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.Date;
import java.util.logging.Logger;


public class AuthenticationHandlerImpl implements AuthenticationHandler {

    Logger log = Logger.getLogger(this.getClass().getName());

    private final long tokenValidityInSeconds;
    private final byte[] secretKey;

    public AuthenticationHandlerImpl(final long tokenValidityInSeconds, final byte[] secretKey) {
        this.tokenValidityInSeconds = tokenValidityInSeconds;
        this.secretKey = secretKey;
    }

    @Override
    public void handle(RoutingContext routingCtx) {
        final String bearerToken = routingCtx.request().getHeader(Constants.AUTHORIZATION_HEADER);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            String jwt = bearerToken.substring(7, bearerToken.length());
            final boolean valid = validateToken(jwt);
            if (valid) {
                Claims claims = Jwts.parser()
                        .setSigningKey(secretKey)
                        .parseClaimsJws(jwt)
                        .getBody();
                routingCtx.next();
                return;
            }
        }
        final HttpServerResponse response = routingCtx.response();
        response.headers().set("Content-Type", "application/json");
        response.setStatusCode(401).end(new JsonObject().put("error", "Token Is Not Vaild").toBuffer());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.severe("Invalid JWT signature: " + e.getMessage());
            return false;
        }
    }

}
