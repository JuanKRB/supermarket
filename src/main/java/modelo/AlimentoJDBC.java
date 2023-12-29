package modelo;

import conexion.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlimentoJDBC {

    Connection conexion;

    public AlimentoJDBC() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();

    }

    public List<Alimento> listaAlimentos() {

        PreparedStatement ps;
        ResultSet rs;
        List<Alimento> lista = new ArrayList<>();

        try {

            ps = conexion.prepareStatement("SELECT id_alimento, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,ingredientes ,calorias FROM Alimentos");

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_alimento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                String ingredientes = rs.getString("ingredientes");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String calorias = rs.getString("calorias");
                
                Alimento alimento = new Alimento(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes, calorias);
                lista.add(alimento);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error lista alimentos: " + e.getMessage());
            return null;
        }

    }

    public Alimento mostrar(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Alimento alimento = null;

        try {

            ps = conexion.prepareStatement("SELECT id_alimento, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,ingredientes ,calorias FROM Alimentos WHERE id_alimento=?");
            ps.setInt(1, _id);

            rs = ps.executeQuery();

            while (rs.next()) {

               int id = rs.getInt("id_alimento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                String ingredientes = rs.getString("ingredientes");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String calorias = rs.getString("calorias");
                
                alimento = new Alimento(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes, calorias);

            }
            return alimento;
        } catch (SQLException e) {
            System.out.println("ERROR, Alimento, Select por id" + e);
            return null;
        }

    }

    public Alimento buscarPorNombre(String _nombre) {

        PreparedStatement ps;
        ResultSet rs;
        Alimento alimento = null;

        try {

            ps = conexion.prepareStatement("SELECT id_alimento, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen ,ingredientes ,calorias FROM Alimentos WHERE nombre=?");
            ps.setString(1, _nombre);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_alimento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                String ingredientes = rs.getString("ingredientes");
                int id_categoria = rs.getInt("id_categoria");
                int id_subCategoria = rs.getInt("id_subCategoria");
                String imagen = rs.getString("imagen");
                String calorias = rs.getString("calorias");
                
                alimento = new Alimento(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes, calorias);
                
               

            }
            return alimento;
        } catch (SQLException e) {
            System.out.println("ERROR, Alimento,buscar por nombre " + e);
            return null;
        }

    }

    public boolean Insertar(Alimento alimento) throws IOException {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO Alimentos (id_alimento, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad, tipoDeAlimento, id_categoria, id_subCategoria, imagen) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, alimento.getId());
            ps.setString(2, alimento.getNombre());
            ps.setString(3, alimento.getDescripcion());
            ps.setDouble(4, alimento.getPrecio());
            ps.setInt(5, alimento.getCantidad());
            ps.setInt(6, alimento.getId_marca());
            ps.setString(7, alimento.getDisponibilidad());
            ps.setString(8, alimento.getIngredientes());
            ps.setInt(9, alimento.getId_categoria());
            ps.setInt(10, alimento.getId_subCategoria());
            ps.setString(11, alimento.getImagen());

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, AlimentoJDBC, Insert " + e.getMessage());
            return false;
        }

    }

    public void insertarPersona(Alimento alimento)  {

        try (PreparedStatement ps = conexion.prepareStatement("INSERT INTO Alimentos (id_alimento, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes, calorias) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)")) {
            ps.setInt(1, alimento.getId());
            ps.setString(2, alimento.getNombre());
            ps.setString(3, alimento.getDescripcion());
            ps.setDouble(4, alimento.getPrecio());
            ps.setInt(5, alimento.getCantidad());
            ps.setInt(6, alimento.getId_marca());
            ps.setString(7, alimento.getDisponibilidad());
            ps.setInt(8, alimento.getId_categoria());
            ps.setInt(9, alimento.getId_subCategoria());
            ps.setString(10, alimento.getImagen());
            ps.setString(11, alimento.getIngredientes());
            ps.setString(12, alimento.getCalorias());
            

            ps.execute();

        } catch (SQLException e) {
            System.out.println("Error en insertar alimento" + e);
        }

    }

    
    public boolean actualizar(Alimento alimento) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE Alimentos SET nombre=?, descripcion=?, precio=?, cantidad=?, id_marca=?, disponibilidad=?, id_categoria=?, id_subCategoria=?, imagen=?, ingredientes=?, calorias=? WHERE id_alimento=?");
            
            ps.setString(1, alimento.getNombre());
            ps.setString(2, alimento.getDescripcion());
            ps.setDouble(3, alimento.getPrecio());
            ps.setInt(4, alimento.getCantidad());
            ps.setInt(5, alimento.getId_marca());
            ps.setString(6, alimento.getDisponibilidad());
            ps.setInt(7, alimento.getId_categoria());
            ps.setInt(8, alimento.getId_subCategoria());
            ps.setString(9, alimento.getImagen());
            ps.setString(10, alimento.getIngredientes());
            ps.setString(11, alimento.getCalorias());
            ps.setInt(12, alimento.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, AlimentoJDBC, actualizar" + e);
            return false;
        }

    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM Alimentos WHERE id_alimento=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, AlimentoJDBC, eliminar" + e);
            return false;
        }

    }
}
