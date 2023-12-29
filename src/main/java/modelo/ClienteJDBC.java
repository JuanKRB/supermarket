
package modelo;

import conexion.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteJDBC {
    
    Connection conexion;

    public ClienteJDBC() {
        
        Conexion con = new Conexion();
        conexion = con.getConexion();
        
    }
    
    
    public List<Cliente> listaClientes() {

        PreparedStatement ps;
        ResultSet rs;
        List<Cliente> lista = new ArrayList<>();

        try {

            ps = conexion.prepareStatement("SELECT id_cliente, contra, statusLogin, nombreCliente, correo FROM Cliente");

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_cliente");
                String contra = rs.getString("contra");
                String statusLogin = rs.getString("statusLogin");
                String nombreCliente = rs.getString("nombreCliente");
                String correo = rs.getString("correo");

                Cliente cliente = new Cliente(id, statusLogin, nombreCliente, correo, contra);
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error lista Clientes " + e.getMessage());
            return null;
        }

    }

    public Cliente mostrar(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Cliente cliente = null;

        try {

            ps = conexion.prepareStatement("SELECT id_cliente, contra, statusLogin, nombreCliente, correo FROM Cliente WHERE id_cliente=?");
            ps.setInt(1, _id);

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
            System.out.println("ERROR, Cliente, Select por id" + e);
            return null;
        }

    }


    
    public boolean insertar(Cliente cliente) throws IOException {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO Cliente (contra, statusLogin, nombreCliente, correo) VALUES (?,?,?,?)");
            ps.setString(1, cliente.getContraCliente());
            ps.setString(2, cliente.getStatusLogin());
            ps.setString(3, cliente.getNombreCliente());
            ps.setString(4, cliente.getCorreoCliente());

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, ClienteJDBC, Insert " + e.getMessage());
            return false;
        }

    }


    
    public boolean actualizar(Cliente cliente) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE Cliente SET contra=?, statusLogin=?, nombreCliente=?, correo=? WHERE id_cliente=?");
            
            ps.setString(1, cliente.getContraCliente());
            ps.setString(2, cliente.getStatusLogin());
            ps.setString(3, cliente.getNombreCliente());
            ps.setString(4, cliente.getCorreoCliente());
            ps.setInt(5, cliente.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, clienteJDBC, actualizar" + e);
            return false;
        }

    }
    
    public boolean actualizarNombreYcorreo(String nombreCliente, String correo, int id_cliente) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE Cliente SET nombreCliente=?, correo=? WHERE id_cliente=?");
            
            ps.setString(1, nombreCliente);
            ps.setString(2, correo);
            ps.setInt(3, id_cliente);

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, clienteJDBC, actualizarNombreYcorreo" + e);
            return false;
        }

    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM Cliente WHERE id_cliente=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, ClienteJDBC, eliminar" + e);
            return false;
        }

    }
    

}

