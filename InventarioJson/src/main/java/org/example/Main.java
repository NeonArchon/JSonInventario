package org.example;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        try {
            // Llama a la función leerJson
            Json.leerJson();
        } catch (RuntimeException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }

    }
}