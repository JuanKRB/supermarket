package modelo;

public class Electronico extends Producto{
    
    private int peso;
    private int altura;
    private int ancho;
    private String color;
    private String especificaciones;

    public Electronico(int id, String nombre, String descripcion, Double precio, int cantidad, String fechaRecibido, int id_sucursal, int id_proveedor, int id_marca, String disponibilidad, int peso, int altura, int ancho, String color, String especificaciones) {
        super(id, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad);
        this.peso = peso;
        this.altura = altura;
        this.ancho = ancho;
        this.color = color;
        this.especificaciones = especificaciones;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }
    
}
