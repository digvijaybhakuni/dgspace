package com.dgstack.app.vertx.api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
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

/**
 * Created by digvijayb on 03/09/17.
 */
public class APIRequestRouter extends AbstractVerticle {


    public void start() {
        System.out.println("START");


        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.route("/api/users/*").handler(this::nodeReqHandler);
        router.route("/api/world/*").handler(this::worldReqHandler);

        router.route().handler(StaticHandler.create());
        HttpServerOptions httpServerOptions = new HttpServerOptions();
        httpServerOptions.setCompressionSupported(true);
        vertx.createHttpServer(httpServerOptions).requestHandler(router::accept).listen(8081);

    }


    private void nodeReqHandler(RoutingContext routingContext) {
        // event.request();
        final HttpServerRequest request = routingContext.request();
        System.out.println(routingContext.currentRoute().getPath());
        System.out.println(request.uri());

        final WebClient client = WebClient.create(vertx);
        System.out.println("CLIENT CREATED");
        final HttpRequest<Buffer> bufferHttpRequest = client.request(request.method(), 3000, "localhost", request.uri());
        System.out.println("REQ  CREATED " + request.method());
        bufferHttpRequest.headers().addAll(request.headers());
        System.out.println("HEADER SET");
        //final JsonObject body = routingContext.getBodyAsJson();
        final Buffer body = routingContext.getBody();
        System.out.println("bodyAsJson = " + body.toString());
        bufferHttpRequest.sendBuffer(body, asyncResult -> {
            System.out.println("REQ SEND");

            final HttpServerResponse response = request.response();
            final HttpResponse<Buffer> result = asyncResult.result();
            if (asyncResult.succeeded()) {
                System.out.println("DONE");
                response.headers().addAll(result.headers());
                response.setStatusCode(result.statusCode()).end(result.body());
            }else{
                System.out.println("ERROR");
                asyncResult.cause().printStackTrace(System.out);
                System.out.println(result);
                response.setStatusCode(404).end();
            }
        });

    }



    private void worldReqHandler(RoutingContext routingContext) {
        // event.request();
        System.out.println("World");
        final HttpServerRequest request = routingContext.request();
        System.out.println(routingContext.currentRoute().getPath());
        System.out.println(request.uri());

        final WebClient client = WebClient.create(vertx);
        System.out.println("CLIENT CREATED");
        final HttpRequest<Buffer> bufferHttpRequest = client.request(request.method(), 9090, "localhost", request.uri());
        System.out.println("REQ  CREATED " + request.method());
        bufferHttpRequest.headers().addAll(request.headers());
        System.out.println("HEADER SET");
        //final JsonObject body = routingContext.getBodyAsJson();
        final Buffer body = routingContext.getBody();
        System.out.println("bodyAsJson = " + body.toString());
        bufferHttpRequest.sendBuffer(body, asyncResult -> {
            System.out.println("REQ SEND");

            final HttpServerResponse response = request.response();
            final HttpResponse<Buffer> result = asyncResult.result();
            if (asyncResult.succeeded()) {
                System.out.println("DONE");
                response.headers().addAll(result.headers());
                result.headers().forEach(System.out::println);
                System.out.println(result.bodyAsString());
                System.out.println(result.statusCode());
                response.setStatusCode(result.statusCode()).end(result.body());
            }else{
                System.out.println("ERROR");
                asyncResult.cause().printStackTrace(System.out);
                System.out.println(result);
                response.setStatusCode(404).end();
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
