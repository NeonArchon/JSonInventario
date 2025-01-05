package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Json {

    public static void leerJson() throws org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("C:\\Users\\morto\\IdeaProjects\\JSonInventario\\InventarioJson\\src\\main\\java\\org\\example\\inventario.json")) {
            Object obj = parser.parse(reader);
            JSONObject arrayiventario = (JSONObject) obj;

            System.out.println(arrayiventario);

                mostrarJson(arrayiventario);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
             } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }

        private static void mostrarJson (JSONObject jsonobject){
            System.out.println("**************");
            JSONObject jsinventario = (JSONObject) jsonobject.get("inventario");
            JSONObject jsproductos = (JSONObject) jsinventario.get("productos");
            JSONArray japroducto = (JSONArray) jsproductos.get("producto");
            for (Object pr : japroducto){

                JSONObject p = (JSONObject) pr;

                System.out.println("Codigo: " + p.get("-codigo"));

                System.out.println("Categoria " + p.get("-categoria"));

                System.out.println("Nombre " + p.get("nombre"));

                System.out.println("Precio" + p.get("precio"));

                System.out.println("Fecha de Ingreso " + p.get("fecha_ingreso"));

                System.out.println("stock " + p.get("stock"));

            }

        }

    }

