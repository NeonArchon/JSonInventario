import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Json {

    public static void leerJson() throws org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("inventario.json")) {
            Object obj = parser.parse(reader);
            JSONArray arrayiventario = (JSONArray) obj;

            System.out.println(arrayiventario);

            for (Object inventario : arrayiventario) {
                mostrarJson((JSONObject) inventario);
            }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
             } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }

        private static void mostrarJson (JSONObject jsonobject){
            JSONObject jsinventario = (JSONObject) jsonobject.get("inventario");
            String inv = (String) jsinventario.get("productos");
            System.out.println("Productos: " + inv);

            JSONObject jsproductos = (JSONObject) jsonobject.get("productos");
            String prod = (String) jsproductos.get("producto");
            System.out.println("Prpductos " + prod);

            JSONArray japroducto = (JSONArray) jsinventario.get("producto");
            for (Object pr : japroducto){
                JSONObject p = (JSONObject) pr;
                System.out.println("producto: " + p.get("producto"));

                JSONObject jscodigo = (JSONObject) jsonobject.get("-codigo");
                String cod = (String) jscodigo.get("-codigo");
                System.out.println("Codigo: " + cod);

                JSONObject jscategoria = (JSONObject) jsonobject.get("-categoria");
                String car = (String) jscategoria.get("-categoria");
                System.out.println("Categoria " + car);

                JSONObject jsnombre = (JSONObject) jsonobject.get("nombre");
                String nom = (String) jsnombre.get("nombre");
                System.out.println("Nombre " + nom);

                JSONObject jsprecio = (JSONObject) jsonobject.get("precio");
                String pre = (String) jsprecio.get("precio");
                System.out.println("Precio" + pre);

                JSONObject jsfecha = (JSONObject) jsonobject.get("fecha_ingreso");
                String fecha = (String) jsfecha.get("fecha_ingreso");
                System.out.println("Fecha de Ingreso " + fecha);

                JSONObject jsstock = (JSONObject) jsonobject.get("stock");
                String stock = (String) jsstock.get("stock");
                System.out.println("stock " + stock);

            }

        }

    }

