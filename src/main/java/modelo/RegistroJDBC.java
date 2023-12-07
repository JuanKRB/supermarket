package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RegistroJDBC {

    Connection conexion;

    public RegistroJDBC() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();

    }

    public Cliente loginCliente(String _correo, String _contra) {

        PreparedStatement ps;
        ResultSet rs;
        Cliente cliente = null;

        try {

            ps = conexion.prepareStatement("SELECT id_cliente, contra, statusLogin, fechaRegistrado, nombreCliente, correo FROM Cliente WHERE correo=? and contra=?");
            ps.setString(1, _correo);
            ps.setString(2, _contra);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_cliente");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String fechaRegistrado = rs.getString("fechaRegistrado");
                String nombreCliente = rs.getString("nombreCliente");
                String correo = rs.getString("correo");

                cliente = new Cliente(id, contra, statusLogin, fechaRegistrado, nombreCliente, correo);

            }
            return cliente;
        } catch (SQLException e) {
            System.out.println("ERROR, RegistroJDBC, loginCliente " + e);
            return null;
        }

    }

    public SuperAdministrador loginSuperAdmin(String _correo, String _contra) {

        PreparedStatement ps;
        ResultSet rs;
        SuperAdministrador superAdministrador = null;

        try {

            ps = conexion.prepareStatement("SELECT id_superAdmin, contra, statusLogin, fechaRegistrado, superAdminNombre, correoSuperAdmin FROM SuperAdministrador WHERE correoSuperAdmin=? and contra=?");
            ps.setString(1, _correo);
            ps.setString(2, _contra);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_superAdmin");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String fechaRegistrado = rs.getString("fechaRegistrado");
                String superAdminNombre = rs.getString("superAdminNombre");
                String superAdminCorreo = rs.getString("correoSuperAdmin");

                superAdministrador = new SuperAdministrador(id, contra, statusLogin, fechaRegistrado, superAdminNombre, superAdminCorreo);

            }
            return superAdministrador;
        } catch (SQLException e) {
            System.out.println("ERROR, RegistroJDBC, loginSuperAdmin" + e);
            return null;
        }

    }

    public Administrador loginAdmin(String _correo, String _contra) {

        PreparedStatement ps;
        ResultSet rs;
        Administrador administrador = null;

        try {

            ps = conexion.prepareStatement("SELECT id_admin, contra, statusLogin, fechaRegistrado, adminNombre, correoEmpresarial FROM Administrador WHERE correoEmpresarial=? and contra=?");
            ps.setString(1, _correo);
            ps.setString(2, _contra);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_admin");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String fechaRegistrado = rs.getString("fechaRegistrado");
                String adminNombre = rs.getString("adminNombre");
                String correoEmpresarial = rs.getString("correoEmpresarial");

                administrador = new Administrador(id, contra, statusLogin, fechaRegistrado, adminNombre, correoEmpresarial);

            }
            return administrador;
        } catch (SQLException e) {
            System.out.println("ERROR, RegistroJDBC, loginAdmin " + e);
            return null;
        }

    }

    public List<Persona> listaPersonas(String _correo, String _contra) {
        
            List<Persona> lista = new ArrayList<>();

            Cliente cliente = loginCliente(_correo, _contra);
            SuperAdministrador superAdministrador = loginSuperAdmin(_correo, _contra);
            Administrador administrador = loginAdmin(_correo, _contra);

            lista.add(cliente);
            lista.add(superAdministrador);
            lista.add(administrador);

            return lista;
    }

}
