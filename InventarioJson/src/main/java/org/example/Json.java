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
        try (FileReader reader = new FileReader("C:\\Users\\alumno\\Desktop\\JSonInventario\\InventarioJson\\src\\main\\java\\org\\example\\inventario.json")) {
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

            /*
            String inv = (String) jsproducto.get("productos");
            System.out.println("*******Productos: " + inv);
*/
/*
            JSONObject jsproductos = (JSONObject) jsonobject.get("productos");
            String prod = (String) jsproductos.get("productos");
            System.out.println("Productos " + prod);*/


            JSONArray japroducto = (JSONArray) jsproductos.get("producto");
            for (Object pr : japroducto){

                JSONObject p = (JSONObject) pr;

                /*JSONObject jscodigo = (JSONObject)
                String cod = (String) jscodigo.get("-codigo");*/
                System.out.println("Codigo: " + p.get("-codigo"));

            //    JSONObject jscategoria = (JSONObject) jsonobject.get("-categoria");
             //   String car = (String) jscategoria.get("-categoria");

                System.out.println("Categoria " + p.get("-categoria"));

             //   JSONObject jsnombre = (JSONObject) jsonobject.get("nombre");
              //  String nom = (String) jsnombre.get("nombre");

                System.out.println("Nombre " + p.get("nombre"));

              //  JSONObject jsprecio = (JSONObject) jsonobject.get("precio");
               // String pre = (String) jsprecio.get("precio");

                System.out.println("Precio" + p.get("precio"));

         //       JSONObject jsfecha = (JSONObject) jsonobject.get("fecha_ingreso");
              //  String fecha = (String) jsfecha.get("fecha_ingreso");

                System.out.println("Fecha de Ingreso " + p.get("fecha_ingreso"));

              //  JSONObject jsstock = (JSONObject) jsonobject.get("stock");
               // String stock = (String) jsstock.get("stock");

                System.out.println("stock " + p.get("stock"));

            }

        }

    }

