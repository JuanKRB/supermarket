
package modelo;

import conexion.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminJDBC {
    
    
    Connection conexion;

    public AdminJDBC() {
        
        Conexion con = new Conexion();
        conexion = con.getConexion();
        
    }
    
    
    public List<Administrador> listaAdministradores() {

        PreparedStatement ps;
        ResultSet rs;
        List<Administrador> lista = new ArrayList<>();

        try {

            ps = conexion.prepareStatement("SELECT id_admin, contra, statusLogin, adminNombre, correoEmpresarial FROM Administrador");

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_admin");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String adminNombre = rs.getString("adminNombre");
                String correoEmpresarial = rs.getString("correoEmpresarial");

                Administrador administrador = new Administrador(id, statusLogin, adminNombre, correoEmpresarial, contra);
                lista.add(administrador);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error lista Administradores " + e.getMessage());
            return null;
        }

    }

    public Administrador mostrar(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Administrador administrador = null;

        try {

            ps = conexion.prepareStatement("SELECT id_admin, contra, statusLogin, adminNombre, correoEmpresarial FROM Administrador WHERE id_admin=?");
            ps.setInt(1, _id);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_admin");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String adminNombre = rs.getString("adminNombre");
                String correoEmpresarial = rs.getString("correoEmpresarial");

                administrador = new Administrador(id, statusLogin, adminNombre, correoEmpresarial, contra);

            }
            return administrador;
        } catch (SQLException e) {
            System.out.println("ERROR, Admin, Select por id" + e);
            return null;
        }

    }

    

    public boolean insertar(Administrador administrador) throws IOException {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO Administrador (contra, statusLogin, adminNombre, correoEmpresarial) VALUES (?,?,?,?)");
            ps.setString(1, administrador.getContraAdmin());
            ps.setString(2, administrador.getStatusLogin());
            ps.setString(3, administrador.getAdminNombre());
            ps.setString(4, administrador.getCorreoAdmin());

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, AdministradorJDBC, Insert " + e.getMessage());
            return false;
        }

    }


    
    public boolean actualizar(Administrador administrador) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE Administrador SET contra=?, statusLogin=?, adminNombre=?, correoEmpresarial=? WHERE id_admin=?");
            
            ps.setString(1, administrador.getContraAdmin());
            ps.setString(2, administrador.getStatusLogin());
            ps.setString(3, administrador.getAdminNombre());
            ps.setString(4, administrador.getCorreoAdmin());
            ps.setInt(5, administrador.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, AdministradorJDBC, actualizar" + e);
            return false;
        }

    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM Administrador WHERE id_admin=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, AdministradorJDBC, eliminar" + e);
            return false;
        }

    }
    
}
