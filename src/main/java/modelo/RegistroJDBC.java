package modelo;

import conexion.Conexion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

            ps = conexion.prepareStatement("SELECT id_cliente, contra, statusLogin, nombreCliente, correo FROM Cliente WHERE correo=? and contra=?");
            ps.setString(1, _correo);
            ps.setString(2, _contra);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_cliente");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String nombreCliente = rs.getString("nombreCliente");
                String correo = rs.getString("correo");

                cliente = new Cliente(id, statusLogin, nombreCliente, correo, contra);

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

            ps = conexion.prepareStatement("SELECT id_superAdmin, contra, statusLogin, superAdminNombre, correoSuperAdmin FROM SuperAdministrador WHERE correoSuperAdmin=? and contra=?");
            ps.setString(1, _correo);
            ps.setString(2, _contra);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_superAdmin");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String superAdminNombre = rs.getString("superAdminNombre");
                String superAdminCorreo = rs.getString("correoSuperAdmin");

                superAdministrador = new SuperAdministrador(id, statusLogin, superAdminNombre, superAdminCorreo, contra);

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

            ps = conexion.prepareStatement("SELECT id_admin, contra, statusLogin, adminNombre, correoEmpresarial FROM Administrador WHERE correoEmpresarial=? and contra=?");
            ps.setString(1, _correo);
            ps.setString(2, _contra);

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
            System.out.println("ERROR, RegistroJDBC, loginAdmin " + e);
            return null;
        }

    }

    public List<Cliente> listaClientes(String _correo, String _contra) {

        List<Cliente> lista = new ArrayList<>();

        Cliente cliente = loginCliente(_correo, _contra);

        lista.add(cliente);

        return lista;
    }

    public List<SuperAdministrador> listaSuperAdministradores(String _correo, String _contra) {

        List<SuperAdministrador> lista = new ArrayList<>();

        SuperAdministrador superAdministrador = loginSuperAdmin(_correo, _contra);

        lista.add(superAdministrador);

        return lista;
    }

    public List<Administrador> listaAdministradores(String _correo, String _contra) {

        List<Administrador> lista = new ArrayList<>();

        Administrador administrador = loginAdmin(_correo, _contra);

        lista.add(administrador);

        return lista;
    }

    /*
    public void Registrarse(Cliente cliente) {
        

        try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO Cliente (id_cliente, contra, statusLogin, nombreCliente, correo) VALUES (?,?,?,?,?)")) {
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getContraCliente());
            ps.setString(3, cliente.getStatusLogin());
            ps.setString(4, cliente.getNombreCliente());
            ps.setString(5, cliente.getCorreoCliente());

            ps.execute();
            
            

        } catch (SQLException e) {
            System.out.println("Error en registrar alimento" + e);
        }
        
        
        

    }

    public int crearCarrito() {

        PreparedStatement ps;
        ResultSet rs;

        int id = 0;

        try {

            ps = conexion.prepareStatement("SELECT LAST_INSERT_ID()");

            rs = ps.executeQuery();

            while (rs.next()) {

                id = rs.getInt(1);

            }
            return id;

        } catch (SQLException e) {
            System.out.println("ERROR, crearCarrito, loginCliente " + e);
            return 0;
        }

    }*/
    public void Registrarse(Cliente cliente) {
        try {

            try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO Cliente (contra, statusLogin, nombreCliente, correo) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, cliente.getContraCliente());
                ps.setString(2, cliente.getStatusLogin());
                ps.setString(3, cliente.getNombreCliente());
                ps.setString(4, cliente.getCorreoCliente());

                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {

                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {

                            int idCliente = generatedKeys.getInt(1);

                            crearCarrito(idCliente);
                        } else {
                            System.out.println("No se pudo obtener el ID generado para el cliente.");
                        }
                    }
                } else {
                    System.out.println("La inserción del cliente no tuvo éxito.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en registrar al cliente" + e);
        }
    }

    public void crearCarrito(int idCliente) {
        System.out.println("El id del cliente justo ingresado es: " + idCliente);
        try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO CarritoCompra (subtotal, precioTotal, id_cliente) VALUES (?,?,?)")) {
            ps.setDouble(1, 0.00);
            ps.setDouble(2, 0.00);
            ps.setInt(3, idCliente);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("ERROR, crearCarrito " + e);
        }
    }

    public int buscarIdCarrito(int idClienteLogueado) {
        PreparedStatement ps;
        ResultSet rs;
        int idCarritoCompra = 0;

        try {

            ps = conexion.prepareStatement("SELECT id_carritoCompra FROM CarritoCompra WHERE id_cliente=?");
            ps.setInt(1, idClienteLogueado);

            rs = ps.executeQuery();

            while (rs.next()) {

                idCarritoCompra = rs.getInt("id_carritoCompra");

            }
            return idCarritoCompra;
        } catch (SQLException e) {
            System.out.println("ERROR, Alimento, Select por id" + e);
            return 0;
        }
    }

    public String convertirdorHexMD5(String str) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(str.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02x", b));

        }
        return hexString.toString();
    }

}
