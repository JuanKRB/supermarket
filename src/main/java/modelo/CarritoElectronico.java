
package modelo;

public class CarritoElectronico {
    
    private int id_carritoElectronico;
    private int id_carritoCompra;
    private int id_electronico;
    private String nombreElectronico;
    private Double precioElectronico;
    private String imagen; 
    private int cantidad;
    private int cantidadEnCarrito;

    public CarritoElectronico(int id_carritoElectronico, int id_carritoCompra, int id_electronico, String nombreElectronico, Double precioElectronico, String imagen, int cantidad, int cantidadEnCarrito) {
        this.id_carritoElectronico = id_carritoElectronico;
        this.id_carritoCompra = id_carritoCompra;
        this.id_electronico = id_electronico;
        this.nombreElectronico = nombreElectronico;
        this.precioElectronico = precioElectronico;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.cantidadEnCarrito = cantidadEnCarrito;
    }

    public int getId_carritoElectronico() {
        return id_carritoElectronico;
    }

    public void setId_carritoElectronico(int id_carritoElectronico) {
        this.id_carritoElectronico = id_carritoElectronico;
    }

    public int getId_carritoCompra() {
        return id_carritoCompra;
    }

    public void setId_carritoCompra(int id_carritoCompra) {
        this.id_carritoCompra = id_carritoCompra;
    }

    public int getId_electronico() {
        return id_electronico;
    }

    public void setId_electronico(int id_electronico) {
        this.id_electronico = id_electronico;
    }

    public String getNombreElectronico() {
        return nombreElectronico;
    }

    public void setNombreElectronico(String nombreElectronico) {
        this.nombreElectronico = nombreElectronico;
    }

    public Double getPrecioElectronico() {
        return precioElectronico;
    }

    public void setPrecioElectronico(Double precioElectronico) {
        this.precioElectronico = precioElectronico;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadEnCarrito() {
        return cantidadEnCarrito;
    }

    public void setCantidadEnCarrito(int cantidadEnCarrito) {
        this.cantidadEnCarrito = cantidadEnCarrito;
    }
    
    
    
    
}
