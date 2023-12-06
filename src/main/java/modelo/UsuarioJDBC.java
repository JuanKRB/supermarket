package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioJDBC {

    static Connection con = null;
    String host;
    String user;
    String password;
    String bd;
    String driver;

    public UsuarioJDBC() {
        try {
            host = "127.0.0.1";
            user = "root";
            password = "1234";
            bd = "Supermercado";
            driver = "com.mysql.cj.jdbc.Driver";
            //String dir = "jdbc:mysql://"+host+":3306/?user="+user+"";
            Class.forName(driver);
//            String dir = "jdbc:mysql://"+host+":3306/clasesprogra?"+"zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&verifyServerCertificate="+Boolean.FALSE.toString()+"&useSSL="+Boolean.FALSE.toString()+" ["+user+" on Default schema]";
            String dir = "jdbc:mysql://" + host + ":3306/" + bd + "?" + "autoReconnect=true&useSSL=false";
//            String dir = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]";

            con = DriverManager.getConnection(dir, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }

    public void closeConexion() {
        try {
            con.close();
        } catch (SQLException e) {

        }
    }

    public Usuario2 save(Usuario2 usuario) {
        String sql = "INSERT INTO cliente (correo, contra, statusLogin, fechaRegistrado , nombreCliente) VALUES (?,?,?,?,?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getContra());
            String statusLogin = usuario.getStatusLogin();
            if (statusLogin == null) {
               
                statusLogin = "activo";
            }
            ps.setString(3, statusLogin);
            ps.setString(4, usuario.getFecharegistro());
            ps.setString(5, usuario.getNombrecliente());
            int rowcount = ps.executeUpdate();
            if (rowcount == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    usuario.setIdCliente(rs.getLong(1));
                }
            } else {
                throw new SQLException("El 'insert' no ocurrio, valor de: " + rowcount);
            }
            con.close();

        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return usuario;
    }

    public Usuario2 findByEmailAndPass(String correo, String contra) throws SQLException {
        Usuario2 usuario = null;
        String sql = "SELECT * FROM cliente u WHERE u.correo = ? and u.contra = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, correo);
        ps.setString(2, contra);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usuario = establecerLibro(rs);
        }
        return usuario;
    }

    private Usuario2 establecerLibro(ResultSet rs) {
        Usuario2 usuario = new Usuario2();
        try {
            usuario.setIdCliente(rs.getLong(1));
            usuario.setCorreo(rs.getString(2));
            usuario.setContra(rs.getString(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;

    }

}
