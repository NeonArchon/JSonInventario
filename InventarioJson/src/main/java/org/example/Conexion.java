package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection conexion;
    private static String usuario = "root";
    private static String pass = "";
    private static String servidor = "localhost";
    private static String Puerto = "3306";
    private static String bbdd = "inventariojson";
    private static String url="jdbc:mysql://"+servidor+":"+Puerto+"/"+bbdd;
    private static String driver="com.mysql.jdbc.Driver";

    public static Connection getConnection(){

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, pass);

            if (conexion!=null){
                System.out.println("org.example.Conexion Correcta");
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar "+e);
        }
        return conexion;

    }

}
