
package modelo;


abstract public class ProductoConsumible extends Producto{
    
    private String ingredientes;

    public ProductoConsumible() {
    }

    public ProductoConsumible(int id, String nombre, String descripcion, Double precio, int cantidad, int id_marca, String disponibilidad, int id_categoria, int id_subCategoria, String imagen, String ingredientes) {
        super(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen);
        this.ingredientes = ingredientes;
    }

    public ProductoConsumible(int id, String nombre, String descripcion, Double precio, int cantidad, int id_marca, String disponibilidad, int id_categoria, int id_subCategoria, String ingredientes) {
        super(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria);
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }


}

