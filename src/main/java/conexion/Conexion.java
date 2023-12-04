package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection conectar = null;
    String usuario = "root";
    String conrasenia = "1234";
    String bd = "Supermercado";
    String ip = "localhost";
    String puerto = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd + "?" + "autoReconnect=true&useSSL=false";   

    public Connection getConexion()  {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, conrasenia);
            System.out.println("Se conecto correctamente a la base de datos: " + bd);

        } catch (SQLException ex) {
            System.out.println("Conexion a base de datos fallida" + ex);

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

         return conectar;
    }
    

}

