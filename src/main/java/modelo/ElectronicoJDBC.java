
package modelo;

import conexion.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElectronicoJDBC {
    
    Connection conexion;

    public ElectronicoJDBC() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();

    }

    
    public List<Electronico> listaElectronicos() {

        PreparedStatement ps;
        ResultSet rs;
        List<Electronico> lista = new ArrayList<>();

        try {

            ps = conexion.prepareStatement("SELECT id_electrodomestico, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,especificaciones FROM Electronicos");

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_electrodomestico");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String especificaciones = rs.getString("especificaciones");
                
                Electronico electronico = new Electronico(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, especificaciones);
                lista.add(electronico);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error lista alectronicos: " + e.getMessage());
            return null;
        }

    }
    
    public Electronico mostrar(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Electronico electronico = null;

        try {

            ps = conexion.prepareStatement("SELECT id_electrodomestico, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,especificaciones FROM Electronicos WHERE id_electrodomestico=?");
            ps.setInt(1, _id);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_electrodomestico");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String especificaciones = rs.getString("especificaciones");
                
                electronico = new Electronico(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, especificaciones);

            }
            return electronico;
        } catch (SQLException e) {
            System.out.println("ERROR, ElectronicoJDBC, mostrar" + e);
            return null;
        }

    }
    
    
    public Electronico buscarPorNombre(String _nombre) {

        PreparedStatement ps;
        ResultSet rs;
        Electronico electronico = null;

        try {

            ps = conexion.prepareStatement("SELECT id_electrodomestico, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,especificaciones FROM Electronicos WHERE nombre=?");
            ps.setString(1, _nombre);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_electrodomestico");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String especificaciones = rs.getString("especificaciones");
                
                electronico = new Electronico(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, especificaciones);

            }
            return electronico;
        } catch (SQLException e) {
            System.out.println("ERROR, ElectronicoJDBC, buscarPorNombre" + e);
            return null;
        }

    }
    
    
    public boolean insertar(Electronico electronico) throws IOException {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement(" INSERT INTO Electronicos (nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, especificaciones) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, electronico.getNombre());
            ps.setString(2, electronico.getDescripcion());
            ps.setDouble(3, electronico.getPrecio());
            ps.setInt(4, electronico.getCantidad());
            ps.setInt(5, electronico.getId_marca());
            ps.setString(6, electronico.getDisponibilidad());
            ps.setInt(7, electronico.getId_categoria());
            ps.setInt(8, electronico.getId_subCategoria());
            ps.setString(9, electronico.getImagen());
            ps.setString(10, electronico.getEspecificaciones());

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, ElectronicoJDBC, Insert " + e.getMessage());
            return false;
        }

    }
    
    public boolean actualizar(Electronico electronico) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE Electronicos SET nombre=?, descripcion=?, precio=?, cantidad=?, id_marca=?, disponibilidad=?, id_categoria=?, id_subCategoria=?, imagen=?, especificaciones=? WHERE id_electrodomestico=?");
            
            ps.setString(1, electronico.getNombre());
            ps.setString(2, electronico.getDescripcion());
            ps.setDouble(3, electronico.getPrecio());
            ps.setInt(4, electronico.getCantidad());
            ps.setInt(5, electronico.getId_marca());
            ps.setString(6, electronico.getDisponibilidad());
            ps.setInt(7, electronico.getId_categoria());
            ps.setInt(8, electronico.getId_subCategoria());
            ps.setString(9, electronico.getImagen());
            ps.setString(10, electronico.getEspecificaciones());
            ps.setInt(11, electronico.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, ElectronicoJDBC, actualizar" + e);
            return false;
        }

    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM Electronicos WHERE id_electrodomestico=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, ElectronicoJDBC, eliminar" + e);
            return false;
        }

    }
    
    
}
