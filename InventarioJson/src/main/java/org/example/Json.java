package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import java.sql.*;


public class Json {

    //funion para leer el JSon
    public static void leerJson() throws org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/java/org/example/inventario.json")) {
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

    //Funcion para mostrar el JSon
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

        //Funcion para insertar el JSON a la Base de datos
        public static void InsertarJsonDB(JSONObject jsonObject){
        //obtenemos los datos del JSon
            JSONObject jsinventario = (JSONObject) jsonObject.get("inventario");
            JSONObject jsproductos = (JSONObject) jsinventario.get("productos");
            JSONArray japroducto = (JSONArray) jsproductos.get("producto");

            // Conectar a la base de datos
            try (Connection conn = Conexion.getConnection()) {
                if (conn != null) {
                    String query = "INSERT INTO productos (codigo, categoria, nombre, precio, fecha_ingreso, fstock) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);

                    // Iterar sobre los productos y agregarlos a la base de datos
                    for (Object pr : japroducto) {
                        JSONObject p = (JSONObject) pr;

                        stmt.setString(1, (String) p.get("-codigo"));
                        stmt.setString(2, (String) p.get("-categoria"));
                        stmt.setString(3, (String) p.get("nombre"));
                        stmt.setString(4, (String) p.get("precio"));
                     //stmt.setInt(4, Integer.parseInt((String) p.get("precio"))); // Convertir precio a entero
                        stmt.setDate(5, java.sql.Date.valueOf((String) p.get("fecha_ingreso"))); // Convertir fecha a java.sql.Date
                        stmt.setInt(6, Integer.parseInt((String) p.get("stock"))); // Convertir stock a entero

                        // Ejecutar la inserción
                        stmt.executeUpdate();
                    }
                    System.out.println("Datos insertados correctamente en la base de datos.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Funcion para mostrar los datos guardados en la base de datos
        public static void MostrarDatosDB(){

            Connection conexion = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                // Obtén la conexión desde la clase Conexion
                conexion = Conexion.getConnection();

                // Crea un Statement para ejecutar la consulta
                statement = conexion.createStatement();

                // Ejecuta la consulta para obtener los datos de la tabla
                String consulta = "SELECT * FROM productos";
                resultSet = statement.executeQuery(consulta);

                // Muestra los datos obtenidos
                System.out.println("Datos en la base de datos:");
                while (resultSet.next()) {
                    String codigo = resultSet.getString("codigo");
                    String categoria = resultSet.getString("categoria");
                    String nombre = resultSet.getString("nombre");
                    int precio = resultSet.getInt("precio");
                    Date fechaIngreso = resultSet.getDate("fecha_ingreso");
                    int stock = resultSet.getInt("fstock");

                    System.out.println("----------------------------");
                    System.out.println("Código: " + codigo);
                    System.out.println("Categoría: " + categoria);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Precio: " + precio);
                    System.out.println("Fecha de ingreso: " + fechaIngreso);
                    System.out.println("Stock: " + stock);
                }
            } catch (Exception e) {
                System.out.println("Error al obtener los datos: " + e.getMessage());
            } finally {
                // Cierra los recursos abiertos
                try {
                    if (resultSet != null) resultSet.close();
                    if (statement != null) statement.close();
                    if (conexion != null) conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }

        }

        }