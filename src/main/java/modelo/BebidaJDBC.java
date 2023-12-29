
package modelo;

import conexion.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BebidaJDBC {
    
    Connection conexion;

    public BebidaJDBC() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();

    }
    
    
    public List<Bebida> listaBebidas() {

        PreparedStatement ps;
        ResultSet rs;
        List<Bebida> lista = new ArrayList<>();

        try {

            ps = conexion.prepareStatement("SELECT id_bebida, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,ingredientes ,cantidadLiquido FROM Bebida");

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_bebida");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String ingredientes = rs.getString("ingredientes");
                String cantidadLiquido = rs.getString("cantidadLiquido");
                
                Bebida bebida = new Bebida(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes, cantidadLiquido);
                lista.add(bebida);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error lista alimentos: " + e.getMessage());
            return null;
        }

    }
    
    public Bebida mostrar(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Bebida bebida = null;

        try {

            ps = conexion.prepareStatement("SELECT id_bebida, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,ingredientes ,cantidadLiquido FROM Bebida WHERE id_bebida=?");
            ps.setInt(1, _id);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_bebida");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String ingredientes = rs.getString("ingredientes");
                String cantidadLiquido = rs.getString("cantidadLiquido");
                
                bebida = new Bebida(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes, cantidadLiquido);

            }
            return bebida;
        } catch (SQLException e) {
            System.out.println("ERROR, BebidaJDBC, mostrar" + e);
            return null;
        }

    }
    
    public Bebida buscarPorNombre(String _nombre) {

        PreparedStatement ps;
        ResultSet rs;
        Bebida bebida = null;

        try {

            ps = conexion.prepareStatement("SELECT id_bebida, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,ingredientes ,cantidadLiquido FROM Bebida WHERE nombre=?");
            ps.setString(1, _nombre);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_bebida");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String ingredientes = rs.getString("ingredientes");
                String cantidadLiquido = rs.getString("cantidadLiquido");
                
                bebida = new Bebida(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes, cantidadLiquido);

            }
            return bebida;
        } catch (SQLException e) {
            System.out.println("ERROR, BebidaJDBC, buscar por nombre" + e);
            return null;
        }

    }
    
    
    public boolean insertar(Bebida bebida) throws IOException {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement(" INSERT INTO Bebida (nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes, cantidadLiquido) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, bebida.getNombre());
            ps.setString(2, bebida.getDescripcion());
            ps.setDouble(3, bebida.getPrecio());
            ps.setInt(4, bebida.getCantidad());
            ps.setInt(5, bebida.getId_marca());
            ps.setString(6, bebida.getDisponibilidad());
            ps.setInt(7, bebida.getId_categoria());
            ps.setInt(8, bebida.getId_subCategoria());
            ps.setString(9, bebida.getImagen());
            ps.setString(10, bebida.getIngredientes());
            ps.setString(11, bebida.getCantidaLiquido());

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, BebidaJDBC, Insert " + e.getMessage());
            return false;
        }

    }
    
    public boolean actualizar(Bebida bebida) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE Bebida SET nombre=?, descripcion=?, precio=?, cantidad=?, id_marca=?, disponibilidad=?, id_categoria=?, id_subCategoria=?, imagen=?, ingredientes=?, cantidadLiquido=? WHERE id_bebida=?");
            
            ps.setString(1, bebida.getNombre());
            ps.setString(2, bebida.getDescripcion());
            ps.setDouble(3, bebida.getPrecio());
            ps.setInt(4, bebida.getCantidad());
            ps.setInt(5, bebida.getId_marca());
            ps.setString(6, bebida.getDisponibilidad());
            ps.setInt(7, bebida.getId_categoria());
            ps.setInt(8, bebida.getId_subCategoria());
            ps.setString(9, bebida.getImagen());
            ps.setString(10, bebida.getIngredientes());
            ps.setString(11, bebida.getCantidaLiquido());
            ps.setInt(12, bebida.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, BebidaJDBC, actualizar" + e);
            return false;
        }

    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM Bebida WHERE id_bebida=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, BebidaJDBC, elimnar" + e);
            return false;
        }

    }
    
}
