package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


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


        System.out.println("Empezando traslado del JSON a la base de datos");

        try {
            // Leer y procesar el archivo JSON
            System.out.println("\nLeyendo el archivo JSON...");
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("InventarioJson/src/main/java/org/example/inventario.json");
            Object obj = parser.parse(reader);
            JSONObject arrayInventario = (JSONObject) obj;

            // Insertar los datos en la base de datos
            System.out.println("\nInsertando datos en la base de datos...");
            Json.InsertarJsonDB(arrayInventario);

            // Mostrar los datos guardados en la base de datos
            System.out.println("\nMostrando datos guardados en la base de datos...");
            Json.MostrarDatosDB();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo JSON no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (org.json.simple.parser.ParseException e) {
            System.out.println("Error al analizar el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }

        System.out.println("\nFin del programa.");
    }

}
