
package modelo;

public class Bebida extends ProductoConsumible{
    
    private String tipoBebida;
    private int cantidaLiquido;

    public Bebida(int id, String nombre, String descripcion, Double precio, int cantidad, String fechaRecibido, int id_sucursal, int id_proveedor, int id_marca, String disponibilidad, int id_categoria, String ingredientes, String calorias, String proteinas, String grasas, String fechaCaducidad, String tipoBebida, int cantidaLiquido) {
        super(id, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, id_categoria, ingredientes, calorias, proteinas, grasas, fechaCaducidad);
        this.tipoBebida = tipoBebida;
        this.cantidaLiquido = cantidaLiquido;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public int getCantidaLiquido() {
        return cantidaLiquido;
    }

    public void setCantidaLiquido(int cantidaLiquido) {
        this.cantidaLiquido = cantidaLiquido;
    }
     
}

