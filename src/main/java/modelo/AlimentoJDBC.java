package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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

            ps = conexion.prepareStatement("SELECT id_alimento, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad, tipoDeAlimento FROM Alimentos");

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_alimento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                String fechaRecibido = rs.getString("fechaRecibido");
                int id_sucursal = rs.getInt("id_sucursal");
                int id_proveedor = rs.getInt("id_proveedor");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                String ingredientes = rs.getString("ingredientes");
                String calorias = rs.getString("calorias");
                String proteinas = rs.getString("proteinas");
                String grasas = rs.getString("grasas");
                String fechaCaducidad = rs.getString("fechaCaducidad");
                String tipoDeAlimentos = rs.getString("tipoDeAlimento");            
    
                Alimento alimento = new Alimento(id, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad, tipoDeAlimentos);
                lista.add(alimento);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error lista alimentos: " + e.getMessage());
            return null;
        }

    }

    public Producto mostarProducto(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        Alimento alimento = null;

        try {

            ps = conexion.prepareStatement("SELECT id_alimento, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad, tipoDeAlimento FROM Alimentos WHERE id=?");
            ps.setInt(1, _id);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_alimento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                String fechaRecibido = rs.getString("fechaRecibido");
                int id_sucursal = rs.getInt("id_sucursal");
                int id_proveedor = rs.getInt("id_proveedor");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                String ingredientes = rs.getString("ingredientes");
                String calorias = rs.getString("calorias");
                String proteinas = rs.getString("proteinas");
                String grasas = rs.getString("grasas");
                String fechaCaducidad = rs.getString("fechaCaducidad");
                String tipoDeAlimentos = rs.getString("tipoDeAlimento");

                alimento = new Alimento(id, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad, tipoDeAlimentos);

            }
            return alimento;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR, Alimento,Select por id " + e);
            return null;
        }

    }
    
    public Producto buscarPorNombre(String _nombre) {

        PreparedStatement ps;
        ResultSet rs;
        Alimento alimento = null;

        try {

            ps = conexion.prepareStatement("SELECT id_alimento, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad, tipoDeAlimento FROM Alimentos WHERE nombre=?");
            ps.setString(1, _nombre);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_alimento");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                String fechaRecibido = rs.getString("fechaRecibido");
                int id_sucursal = rs.getInt("id_sucursal");
                int id_proveedor = rs.getInt("id_proveedor");
                int id_marca = rs.getInt("id_marca");
                String disponibilidad = rs.getString("disponibilidad");
                String ingredientes = rs.getString("ingredientes");
                String calorias = rs.getString("calorias");
                String proteinas = rs.getString("proteinas");
                String grasas = rs.getString("grasas");
                String fechaCaducidad = rs.getString("fechaCaducidad");
                String tipoDeAlimentos = rs.getString("tipoDeAlimento");

                alimento = new Alimento(id, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad, tipoDeAlimentos);

            }
            return alimento;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR, Alimento,buscar por nombre " + e);
            return null;
        }

    }

    public boolean Insertar(Alimento alimento) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO Alimentos (id_alimento, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad, tipoDeAlimento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, alimento.getId());
            ps.setString(2, alimento.getNombre());
            ps.setString(3, alimento.getDescripcion());
            ps.setDouble(4, alimento.getPrecio());
            ps.setInt(5, alimento.getCantidad());
            ps.setString(6, alimento.getFechaRecibido());
            ps.setInt(7, alimento.getId_sucursal());
            ps.setInt(8, alimento.getId_proveedor());
            ps.setInt(9, alimento.getId_marca());
            ps.setString(10, alimento.getDisponibilidad());
            ps.setString(11, alimento.getIngredientes());
            ps.setString(12, alimento.getCalorias());
            ps.setString(13, alimento.getProteinas());
            ps.setString(14, alimento.getGrasas());
            ps.setString(15, alimento.getFechaCaducidad());
            ps.setString(16, alimento.getTipoDeAlimento());

            ps.execute();

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR, AlimentoJDBC ,Insert " + e);
            return false;
        }

    }

    public boolean actualizar(Alimento alimento) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE Alimentos SET nombre=?, descripcion=?, precio=?, cantidad=?, fechaRecibido=?, id_sucursal=?, id_proveedor=?, id_marca=?, disponibilidad=?, ingredientes=?, calorias=?, proteinas=?, grasas=?, fechaCaducidad=?, tipoDeAlimento=? WHERE id=?");
            ps.setString(1, alimento.getNombre());
            ps.setString(2, alimento.getDescripcion());
            ps.setDouble(3, alimento.getPrecio());
            ps.setInt(4, alimento.getCantidad());
            ps.setString(5, alimento.getFechaRecibido());
            ps.setInt(6, alimento.getId_sucursal());
            ps.setInt(7, alimento.getId_proveedor());
            ps.setInt(8, alimento.getId_marca());
            ps.setString(9, alimento.getDisponibilidad());
            ps.setString(10, alimento.getIngredientes());
            ps.setString(11, alimento.getCalorias());
            ps.setString(12, alimento.getProteinas());
            ps.setString(13, alimento.getGrasas());
            ps.setString(14, alimento.getFechaCaducidad());
            ps.setString(15, alimento.getTipoDeAlimento());
            ps.setInt(16, alimento.getId());

            ps.execute();

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR, AlimentoJDBC, actualizar" + e);
            return false;
        }

    }

    public boolean eliminar(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM Alimentos WHERE id=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR, AlimentoJDBC, elimnar" + e);
            return false;
        }

    }
}

