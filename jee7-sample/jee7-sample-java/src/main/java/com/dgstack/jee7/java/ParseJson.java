/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7.java;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.stream.JsonParser;

/**
 *
 * @author digvijayb
 */
public class ParseJson {

    //private static final Logger LOG = Logger.getGlobal();
    public List<String> list = new ArrayList<>(50);

    public void streamJson(final String jsonStr) {
        //LOG.info("streamJson");
        try (final JsonParser parser = Json.createParser(new StringReader(jsonStr))) {
            int ctr = 0;
            while (parser.hasNext()) {
                final JsonParser.Event event = parser.next();
                switch (event) {
                    case KEY_NAME:
                        list.add("KEY : " + event + (++ctr) + " > "+parser.getString());
                        break;
                    case VALUE_STRING:
                    case VALUE_NUMBER:
                        break;
                }
            }

        } finally {
            System.out.println("done");
        }

    }

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get("src/main/resources/test.json");
        byte[] readAllBytes = Files.readAllBytes(path);
        ParseJson parseJson = new ParseJson();
        parseJson.streamJson(new String(readAllBytes));

    }

}
