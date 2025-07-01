package org.mscoders.citas_medicas;
import java.sql.*;

public class Conexion {

    public static Connection conectarBD(){
        Connection conectar = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/citas_medicas","root","AmauryJFX");
                System.out.println("Conectado a la base de datos correctamente.");
            }catch (ClassNotFoundException | SQLException e){
                System.out.println("Error al conectar BD " + e.getMessage());
            }
        return conectar;

    }

}
