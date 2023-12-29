
package modelo;

public class Bebida extends ProductoConsumible{
    
    private String cantidaLiquido;

    public Bebida(int id, String nombre, String descripcion, Double precio, int cantidad, int id_marca, String disponibilidad, int id_categoria, int id_subCategoria, String imagen, String ingredientes, String cantidaLiquido) {
        super(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes);
        this.cantidaLiquido = cantidaLiquido;
    }

    public String getCantidaLiquido() {
        return cantidaLiquido;
    }

    public void setCantidaLiquido(String cantidaLiquido) {
        this.cantidaLiquido = cantidaLiquido;
    }
     
}

