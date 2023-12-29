

package modelo;

public class CarritoBebida {
    
    private int id_carritoBebida;
    private int id_carritoCompra;
    private int id_bebida;
    private String nombreBebida;
    private Double precioBebida;
    private String imagen; 
    private int cantidad;
    private int cantidadEnCarrito;

    public CarritoBebida(int id_carritoBebida, int id_carritoCompra, int id_bebida, String nombreBebida, Double precioBebida, String imagen, int cantidad, int cantidadEnCarrito) {
        this.id_carritoBebida = id_carritoBebida;
        this.id_carritoCompra = id_carritoCompra;
        this.id_bebida = id_bebida;
        this.nombreBebida = nombreBebida;
        this.precioBebida = precioBebida;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.cantidadEnCarrito = cantidadEnCarrito;
    }

    public int getId_carritoBebida() {
        return id_carritoBebida;
    }

    public void setId_carritoBebida(int id_carritoBebida) {
        this.id_carritoBebida = id_carritoBebida;
    }

    public int getId_carritoCompra() {
        return id_carritoCompra;
    }

    public void setId_carritoCompra(int id_carritoCompra) {
        this.id_carritoCompra = id_carritoCompra;
    }

    public int getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(int id_bebida) {
        this.id_bebida = id_bebida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public Double getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(Double precioBebida) {
        this.precioBebida = precioBebida;
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
