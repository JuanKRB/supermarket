package modelo;

import conexion.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarritoProductoJDBC {

    Connection conexion;

    public CarritoProductoJDBC() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();

    }

    public List<CarritoAlimento> listaCarritoAlimentoInnerJoin(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        List<CarritoAlimento> lista = new ArrayList<>();

        try {
            
            String consulta = "SELECT cp.id_carritoAlimento, cp.id_carritoCompra, cp.id_alimento, cp.cantidadEnCarrito, a.nombre, a.precio, a.imagen, a.cantidad FROM CarritoAlimentos cp JOIN Alimentos a ON cp.id_alimento = a.id_alimento WHERE cp.id_carritoCompra = ?";

            ps = conexion.prepareStatement(consulta);

            ps.setInt(1, _id);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id_carritoAlimento = rs.getInt("cp.id_carritoAlimento");
                int id_carritoCompra = rs.getInt("cp.id_carritoCompra");
                int id_alimento = rs.getInt("cp.id_alimento");
                int cantidadEnCarrito = rs.getInt("cp.cantidadEnCarrito");
                String nombreAlimento = rs.getString("a.nombre");
                double precioAlimento = rs.getDouble("a.precio");
                String imagen = rs.getString("a.imagen");
                int cantidad = rs.getInt("a.cantidad");

                CarritoAlimento carritoAlimento = new CarritoAlimento(id_carritoAlimento, id_carritoCompra, id_alimento, nombreAlimento, precioAlimento, imagen, cantidad, cantidadEnCarrito);
                lista.add(carritoAlimento);
            }
            return lista;
            } catch (SQLException e) {
            System.out.println("Error lista alimentos: " + e.getMessage());
            return null;
        }

    }

    public boolean insertar(int id_carritoCompra, int id_alimento) throws IOException {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO CarritoAlimentos (id_carritoCompra, id_alimento, cantidadEnCarrito) VALUES (?,?,?)");
            ps.setInt(1, id_carritoCompra);
            ps.setInt(2, id_alimento);
            ps.setInt(3, 1);

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, CarritoProductoJDBC, Insert " + e.getMessage());
            return false;
        }

    }
    
    public List<CarritoElectronico> listaCarritoElectronicoInnerJoin(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        List<CarritoElectronico> lista = new ArrayList<>();

        try {
            
            String consulta = "SELECT cp.id_carritoElectronico, cp.id_carritoCompra, cp.id_electrodomestico, cp.cantidadEnCarrito, a.nombre, a.precio, a.imagen, a.cantidad FROM CarritoElectrodomestico cp JOIN Electronicos a ON cp.id_electrodomestico = a.id_electrodomestico WHERE cp.id_carritoCompra = ?";

            ps = conexion.prepareStatement(consulta);

            ps.setInt(1, _id);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id_carritoElectronico = rs.getInt("cp.id_carritoElectronico");
                int id_carritoCompra = rs.getInt("cp.id_carritoCompra");
                int id_electrodomestico = rs.getInt("cp.id_electrodomestico");
                int cantidadEnCarrito = rs.getInt("cp.cantidadEnCarrito");
                String nombreElectronico = rs.getString("a.nombre");
                double precioElectronico= rs.getDouble("a.precio");
                String imagen = rs.getString("a.imagen");
                int cantidad = rs.getInt("a.cantidad");

                CarritoElectronico carritoElectronico = new CarritoElectronico(id_carritoElectronico, id_carritoCompra, id_electrodomestico, nombreElectronico, precioElectronico, imagen, cantidad, cantidadEnCarrito);
                lista.add(carritoElectronico);
            }
            return lista;
            } catch (SQLException e) {
            System.out.println("Error lista listaCarritoElectronicoInnerJoin: " + e.getMessage());
            return null;
        }

    }

    public boolean insertarCarritoElectronicos(int id_carritoCompra, int id_electronico) throws IOException {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO CarritoElectrodomestico (id_carritoCompra, id_electrodomestico, cantidadEnCarrito) VALUES (?,?,?)");
            ps.setInt(1, id_carritoCompra);
            ps.setInt(2, id_electronico);
            ps.setInt(3, 1);

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, insertarCarritoElectronicos, Insert " + e.getMessage());
            return false;
        }

    }
    
    
    public List<CarritoBebida> listaCarritoBebidaInnerJoin(int _id) {

        PreparedStatement ps;
        ResultSet rs;
        List<CarritoBebida> lista = new ArrayList<>();

        try {
            
            String consulta = "SELECT cp.id_carritoBebida, cp.id_carritoCompra, cp.id_bebida, cp.cantidadEnCarrito, a.nombre, a.precio, a.imagen, a.cantidad FROM CarritoBebida cp JOIN Bebida a ON cp.id_bebida = a.id_bebida WHERE cp.id_carritoCompra = ?";

            ps = conexion.prepareStatement(consulta);

            ps.setInt(1, _id);

            rs = ps.executeQuery();

            while (rs.next()) {

                int id_carritoBebida = rs.getInt("cp.id_carritoBebida");
                int id_carritoCompra = rs.getInt("cp.id_carritoCompra");
                int id_bebida = rs.getInt("cp.id_bebida");
                int cantidadEnCarrito = rs.getInt("cp.cantidadEnCarrito");
                String nombreBebida = rs.getString("a.nombre");
                double precioBebida = rs.getDouble("a.precio");
                String imagen = rs.getString("a.imagen");
                int cantidad = rs.getInt("a.cantidad");

                CarritoBebida carritoBebida = new CarritoBebida(id_carritoBebida, id_carritoCompra, id_bebida, nombreBebida, precioBebida, imagen, cantidad, cantidadEnCarrito);
                lista.add(carritoBebida);
            }
            return lista;
            } catch (SQLException e) {
            System.out.println("Error lista listaCarritoBebidaInnerJoin: " + e.getMessage());
            return null;
        }

    }

    public boolean insertarCarritoBebida(int id_carritoCompra, int id_bebida) throws IOException {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO CarritoBebida (id_carritoCompra, id_bebida, cantidadEnCarrito) VALUES (?,?,?)");
            ps.setInt(1, id_carritoCompra);
            ps.setInt(2, id_bebida);
            ps.setInt(3, 1);

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, insertarCarritoBebida, Insert " + e.getMessage());
            return false;
        }

    }
    
    public boolean eliminarAlimento(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM CarritoAlimentos WHERE id_carritoAlimento=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, CarritoProductoJDBC, eliminar" + e);
            return false;
        }

    }
    
    public boolean eliminarBebida(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM CarritoBebida WHERE id_carritoBebida=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, CarritoProductoJDBC, eliminarBebida" + e);
            return false;
        }

    }
    
    public boolean eliminarElectronico(int _id) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("DELETE FROM CarritoElectrodomestico WHERE id_carritoElectronico=?");

            ps.setInt(1, _id);
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, CarritoProductoJDBC, eliminarElectronico" + e);
            return false;
        }

    }
    
    public boolean actualizarCarritoAlimentos(int idCarritoAlimento, int nuevaCantidad) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE CarritoAlimentos SET cantidadEnCarrito = ? WHERE id_carritoAlimento = ?");
            
            ps.setInt(1, nuevaCantidad);
            ps.setInt(2, idCarritoAlimento);

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, CarritoProductoJDBC, actualizarCarritoAlimentos" + e);
            return false;
        }

    }
    
    public boolean actualizarCarritoBebidas(int idCarritobebida, int nuevaCantidad) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE CarritoBebida SET cantidadEnCarrito = ? WHERE id_carritoBebida = ?");
            
            ps.setInt(1, nuevaCantidad);
            ps.setInt(2, idCarritobebida);

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, CarritoProductoJDBC, actualizarCarritoBebida" + e);
            return false;
        }

    }
    
    public boolean actualizarCarritoElectronicos(int id_carritoElectronico, int nuevaCantidad) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("UPDATE CarritoElectrodomestico SET cantidadEnCarrito = ? WHERE id_carritoElectronico = ?");
            
            ps.setInt(1, nuevaCantidad);
            ps.setInt(2, id_carritoElectronico);

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("ERROR, CarritoProductoJDBC, actualizarCarritoElectronicos" + e);
            return false;
        }

    }
    
    public boolean insertarFactura(int id_cliente, double sumaTotal, double impuestos, double sumaFinal) {

        PreparedStatement ps;

        try {

            ps = conexion.prepareStatement("INSERT INTO Factura (id_cliente, sumaTotal, impuestos, sumaFinal) VALUES (?,?,?,?)");
            ps.setInt(1, id_cliente);
            ps.setDouble(2, sumaTotal);
            ps.setDouble(3, impuestos);
            ps.setDouble(4, sumaFinal);

            ps.execute();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR, insertarFactura, Insert " + e.getMessage());
            return false;
        }

    }
    

}
