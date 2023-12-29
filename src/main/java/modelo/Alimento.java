
package modelo;




public class Alimento extends ProductoConsumible{
    
    private String calorias;

    public Alimento(int id, String nombre, String descripcion, Double precio, int cantidad, int id_marca, String disponibilidad, int id_categoria, int id_subCategoria, String imagen, String ingredientes, String calorias) {
        super(id, nombre, descripcion, precio, cantidad, id_marca, disponibilidad, id_categoria, id_subCategoria, imagen, ingredientes);
        this.calorias = calorias;
    }

    
    
    public Alimento() {
      
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }
    
    

       
}
