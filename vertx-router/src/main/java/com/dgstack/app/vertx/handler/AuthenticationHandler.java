package com.dgstack.app.vertx.handler;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by dbhakuni on 9/7/2017.
 */
public interface AuthenticationHandler extends Handler<RoutingContext> {

    static AuthenticationHandler create(final long tokenValidityInSeconds, final byte[] secretKey){
        return new AuthenticationHandlerImpl(tokenValidityInSeconds, secretKey);
    }

}
