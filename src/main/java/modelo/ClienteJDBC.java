
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClienteJDBC {
    
    Connection conexion;

    public ClienteJDBC() {
        
        Conexion con = new Conexion();
        conexion = con.getConexion();
        
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

