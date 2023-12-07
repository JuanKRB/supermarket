
package modelo;

public class Cliente extends Persona {
    
    private String NombreCliente;
    private String correoCliente;
    private String contraCliente;

    public Cliente(int id, String statusLogin, String fechaRegistrado, String NombreCliente, String correoCliente, String contraCliente) {
        super(id, statusLogin, fechaRegistrado);
        this.NombreCliente = NombreCliente;
        this.correoCliente = correoCliente;
        this.contraCliente = contraCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correo) {
        this.correoCliente = correo;
    }

    public String getContraCliente() {
        return contraCliente;
    }

    public void setContraCliente(String contraCliente) {
        this.contraCliente = contraCliente;
    }
    
    
    

}
