package modelo;

public class CarritoAlimento {

    private int id_carritoAlimento;
    private int id_carritoCompra;
    private int id_alimento;
    private String nombreAlimento;
    private Double precioAlimento;
    private String imagen; 
    private int cantidad;
    private int cantidadEnCarrito;

    public CarritoAlimento(int id_carritoAlimento, int id_carritoCompra, int id_alimento, String nombreAlimento, Double precioAlimento, String imagen, int cantidad, int cantidadEnCarrito) {
        this.id_carritoAlimento = id_carritoAlimento;
        this.id_carritoCompra = id_carritoCompra;
        this.id_alimento = id_alimento;
        this.nombreAlimento = nombreAlimento;
        this.precioAlimento = precioAlimento;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.cantidadEnCarrito = cantidadEnCarrito;
    }
    
    public int getId_carritoAlimento() {
        return id_carritoAlimento;
    }

    public void setId_carritoAlimento(int id_carritoAlimento) {
        this.id_carritoAlimento = id_carritoAlimento;
    }

    public int getId_carritoCompra() {
        return id_carritoCompra;
    }

    public void setId_carritoCompra(int id_carritoCompra) {
        this.id_carritoCompra = id_carritoCompra;
    }

    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public Double getPrecioAlimento() {
        return precioAlimento;
    }

    public void setPrecioAlimento(Double precioAlimento) {
        this.precioAlimento = precioAlimento;
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

