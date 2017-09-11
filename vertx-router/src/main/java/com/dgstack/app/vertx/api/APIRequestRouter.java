package com.dgstack.app.vertx.api;

import com.dgstack.app.vertx.handler.AuthenticationHandler;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import java.util.Date;

/**
 * Created by digvijayb on 03/09/17.
 */
public class APIRequestRouter extends AbstractVerticle {


    private long tokenValidityInSeconds = 30 * 24 * 60 *60;
    private byte[] secretKey = new String("thisIsSecrt").getBytes();

    public void start() {
        System.out.println("START");

        Router router = Router.router(vertx);
        Router apiRouter = Router.router(vertx);

        apiRouter.route().handler(AuthenticationHandler.create(tokenValidityInSeconds, secretKey));
        apiRouter.route().handler(BodyHandler.create());
        apiRouter.route("/users/*").handler(this::nodeReqHandler);
        apiRouter.route("/world/*").handler(this::worldReqHandler);
        apiRouter.route("/management/*").handler(this::managementReqHandler);

        router.route(HttpMethod.POST,"/api/auth").handler(BodyHandler.create());
        router.route(HttpMethod.POST,"/api/auth").handler(this::loginReqHandler);


        router.mountSubRouter("/api/", apiRouter);

        router.route().handler(StaticHandler.create());

        router.route().failureHandler(routerContext -> {
            System.out.println(routerContext.failure());
            System.out.println("failure Handler :: " + routerContext.statusCode());
            if(routerContext.statusCode() != 404) {
                System.out.println("Rerouting to root");
                //routerContext.reroute("/");
                routerContext.request().response().end();
            }else{
                routerContext.response().end("No Reponse");
            }
        });

        HttpServerOptions httpServerOptions = new HttpServerOptions();
        httpServerOptions.setCompressionSupported(true);
        vertx.createHttpServer(httpServerOptions).requestHandler(router::accept).listen(8081);



    }

    private void loginReqHandler(RoutingContext routingCtx) {
        final JsonObject jsonPayload = routingCtx.getBodyAsJson();
        final String username = jsonPayload.getString("username");
        final String password = jsonPayload.getString("password");
        if ("admin".equalsIgnoreCase(username) && "admin".equals(password)) {
            System.out.println("login");
            long now = (new Date()).getTime();
            Date validity = new Date(now + this.tokenValidityInSeconds);
            final String compact = Jwts.builder()
                    .setSubject("admin")
                    .claim("auth", "ADMIN")
                    .signWith(SignatureAlgorithm.HS512, this.secretKey)
                    .setExpiration(validity)
                    .compact();
            JsonObject jsonObj = new JsonObject().put("token", compact);
            routingCtx.response().end(jsonObj.toBuffer());
        }else {
            routingCtx.response().end(new JsonObject().put("error","Invalid").toBuffer());
        }
    }


    private void nodeReqHandler(RoutingContext routingContext) {
        final HttpServerRequest request = routingContext.request();
        System.out.println(routingContext.currentRoute().getPath());
        System.out.println(request.uri());
        final WebClient client = WebClient.create(vertx);

        final HttpRequest<Buffer> bufferHttpRequest = client.request(request.method(), 3000, "localhost", request.uri());
        bufferHttpRequest.headers().addAll(request.headers());
        bufferHttpRequest.sendBuffer(routingContext.getBody(), asyncResult -> {
            final HttpServerResponse response = request.response();
            final HttpResponse<Buffer> result = asyncResult.result();
            if (asyncResult.succeeded()) {
                response.headers().addAll(result.headers());
                response.setStatusCode(result.statusCode()).end(result.body());
            }else{
                asyncResult.cause().printStackTrace(System.out);
                System.out.println(result);
                response.setStatusCode(500).end();
            }
        });

    }



    private void worldReqHandler(RoutingContext routingContext) {
        final HttpServerRequest request = routingContext.request();
        System.out.println(routingContext.currentRoute().getPath());
        System.out.println(request.uri());

        final WebClient client = WebClient.create(vertx);
        final HttpRequest<Buffer> bufferHttpRequest = client.request(request.method(), 9090, "localhost", request.uri());
        bufferHttpRequest.headers().addAll(request.headers());
        bufferHttpRequest.sendBuffer(routingContext.getBody(), asyncResult -> {
            final HttpServerResponse response = request.response();
            final HttpResponse<Buffer> result = asyncResult.result();
            if (asyncResult.succeeded()) {
                response.headers().addAll(result.headers());
                response.setStatusCode(result.statusCode()).end(result.body());
            }else{
                asyncResult.cause().printStackTrace(System.out);
                response.setStatusCode(500).end();
            }
        });

    }


    private void managementReqHandler(RoutingContext routingContext) {
        final HttpServerRequest request = routingContext.request();
        System.out.println(routingContext.currentRoute().getPath());
        System.out.println(request.uri());

        final WebClient client = WebClient.create(vertx);
        final HttpRequest<Buffer> bufferHttpRequest = client.request(request.method(), 4001, "localhost", request.uri());
        bufferHttpRequest.headers().addAll(request.headers());
        bufferHttpRequest.sendBuffer(routingContext.getBody(), asyncResult -> {
            final HttpServerResponse response = request.response();
            final HttpResponse<Buffer> result = asyncResult.result();
            if (asyncResult.succeeded()) {
                response.headers().addAll(result.headers());
                response.setStatusCode(result.statusCode()).end(result.body());
            }else{
                asyncResult.cause().printStackTrace(System.out);
                response.setStatusCode(500).end();
            }
        });

    }





    private void getUserById(final HttpServerRequest request) {

        final WebClient client = WebClient.create(vertx);
        final HttpRequest<Buffer> bufferHttpRequest = client.get(3000, "localhost", request.uri());
        request.headers().forEach(e -> bufferHttpRequest.putHeader(e.getKey(), e.getValue()));


        //.putHeader("Authorization", request.getHeader("Authorization"))
        //.putHeader("Content-Type", "application/json")


        bufferHttpRequest.send(asyncResult -> {

            final HttpServerResponse response = request.response();
            final HttpResponse<Buffer> result = asyncResult.result();
            if (asyncResult.succeeded()) {
                System.out.println("DONE");
                //final JsonObject jsonObject = asyncResult.result().bodyAsJsonObject();
                result.headers().forEach(e -> response.putHeader(e.getKey(), e.getValue()));
                response.setStatusCode(result.statusCode()).end(result.body());
            } else {
                System.out.println("ERROR");
                asyncResult.cause().printStackTrace(System.out);
                System.out.println(result);
                response.setStatusCode(404).end();
            }

        });

    }


}
