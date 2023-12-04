
package modelo;

public class Alimento extends ProductoConsumible{
    
    private String tipoDeAlimento;

    public Alimento(int id, String nombre, String descripcion, Double precio, int cantidad, String fechaRecibido, int id_sucursal, int id_proveedor, int id_marca, String disponibilidad, String ingredientes, String calorias, String proteinas, String grasas, String fechaCaducidad, String tipoDeAlimento) {
        super(id, nombre, descripcion, precio, cantidad, fechaRecibido, id_sucursal, id_proveedor, id_marca, disponibilidad, ingredientes, calorias, proteinas, grasas, fechaCaducidad);
        this.tipoDeAlimento = tipoDeAlimento;
    }

    public String getTipoDeAlimento() {
        return tipoDeAlimento;
    }

    public void setTipoDeAlimento(String tipoDeAlimento) {
        this.tipoDeAlimento = tipoDeAlimento;
    }
       
}
