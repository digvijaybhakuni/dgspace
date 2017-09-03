package com.dgstack.app.vertx.api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import sun.print.IPPPrintService;

/**
 * Created by digvijayb on 03/09/17.
 */
public class APIRequestRouter extends AbstractVerticle {


    public void start() {


        HttpServer server = vertx.createHttpServer();

        server.requestHandler(request -> {

            // This handler gets called for each request that arrives on the server
//            HttpServerResponse response = request.response();
//            response.putHeader("content-type", "text/plain");
//
//            // Write to the response and end it
//            response.end("Hello World!");

            System.out.println(request.uri());
            System.out.println(request.absoluteURI());
            this.getUserById(request);
            final String uri = request.uri();
            final HttpMethod method = request.method();

        });

        server.listen(8081);

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
