
package modelo;

abstract public class ProductoConsumible extends Producto{
    
    private String ingredientes;
    private String calorias;
    private String proteinas;
    private String grasas;
    private String fechaCaducidad;

    public ProductoConsumible(int id, String nombre, String descripcion, Double precio, int cantidad, String fechaRecibido, int id_sucursal, int id_proveedor, int id_marca, String disponibilidad, int id_categoria, String ingredientes, String calorias, String proteinas, String grasas, String fechaCaducidad) {
        super(id, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, id_categoria);
        this.ingredientes = ingredientes;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getProteinas() {
        return proteinas;
    }

    public void setProteinas(String proteinas) {
        this.proteinas = proteinas;
    }

    public String getGrasas() {
        return grasas;
    }

    public void setGrasas(String grasas) {
        this.grasas = grasas;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

}

