
package modelo;

import java.io.InputStream;
import java.sql.Blob;


abstract public class Producto {
    
    private int id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int cantidad;
    private int id_marca;
    private String disponibilidad;
    private int id_categoria;
    private int id_subCategoria;
    private String imagen;

    public Producto() {
    }
   
    public Producto(int id, String nombre, String descripcion, Double precio, int cantidad, int id_marca, String disponibilidad, int id_categoria, int id_subCategoria, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_marca = id_marca;
        this.disponibilidad = disponibilidad;
        this.id_categoria = id_categoria;
        this.id_subCategoria = id_subCategoria;
        this.imagen = imagen;
    }

    public Producto(int id, String nombre, String descripcion, Double precio, int cantidad, int id_marca, String disponibilidad, int id_categoria, int id_subCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_marca = id_marca;
        this.disponibilidad = disponibilidad;
        this.id_categoria = id_categoria;
        this.id_subCategoria = id_subCategoria;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }   

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_subCategoria() {
        return id_subCategoria;
    }

    public void setId_subCategoria(int id_subCategoria) {
        this.id_subCategoria = id_subCategoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    

  
}

