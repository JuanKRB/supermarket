package modelo;

import java.io.InputStream;
import java.sql.Blob;

public class Electronico extends Producto{
    
    private String especificaciones;
  
    public Electronico(int id, String nombre, String descripcion, Double precio, int cantidad, int id_marca, String disponibilidad, int id_categoria, int id_subCategoria, String imagen,String especificaciones) {
        super(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen);
        this.especificaciones = especificaciones;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }
    
}
