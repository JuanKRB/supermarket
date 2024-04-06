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

    Connection conexion;

    public UsuarioJDBC() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();

    }

    public Usuario2 save(Usuario2 usuario) {
        String sql = "INSERT INTO cliente (correo, contra) VALUES (?,?)";
        try {

            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getContra());
           
            int rowcount = ps.executeUpdate();
            if (rowcount == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    usuario.setIdCliente(rs.getLong(1));
                }
            } else {
                throw new SQLException("El 'insert' no ocurrio, valor de: " + rowcount);
            }
            conexion.close();

        } catch (SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return usuario;
    }

    public Usuario2 findByEmailAndPass(String correo, String contra) throws SQLException {
        Usuario2 usuario = null;
        String sql = "SELECT * FROM cliente u WHERE u.correo = ? and u.contra = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, correo);
        ps.setString(2, contra);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usuario = establecerLibro(rs);
        }
        return usuario;
    }
       
    public List<Cliente> listaClientesTradu() {

        PreparedStatement ps;
        ResultSet rs;
        List<Cliente> lista = new ArrayList<>();

        try {

            ps = conexion.prepareStatement("SELECT * FROM cliente");

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_cliente");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String nombreCliente = rs.getString("nombreCliente");
                String correo = rs.getString("correo");
                
                Cliente cliente = new Cliente(id, statusLogin, nombreCliente,correo,contra);
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error lista clientes: " + e.getMessage());
            return null;
        }

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
