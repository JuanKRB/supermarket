
package modelo;

public class Cliente extends Persona {
    
    private String NombreCliente;
    private String direccion;
    private String correoCliente;

    public Cliente(int id, int contra, String statusLogin, String fechaRegistrado, String NombreCliente, String direccion, String correoCliente) {
        super(id, contra, statusLogin, fechaRegistrado);
        this.NombreCliente = NombreCliente;
        this.direccion = direccion;
        this.correoCliente = correoCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correo) {
        this.correoCliente = correo;
    }
    
    
    
    
    
}
