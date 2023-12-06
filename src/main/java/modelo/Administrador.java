
package modelo;

public class Administrador extends Persona{
    
    private String adminNombre;
    private String correoAdmin;

    public Administrador(String adminNombre, String correoAdmin, int id, int contra, String statusLogin, String fechaRegistrado) {
        super(id, contra, statusLogin, fechaRegistrado);
        this.adminNombre = adminNombre;
        this.correoAdmin = correoAdmin;
    }

    public String getAdminNombre() {
        return adminNombre;
    }

    public void setAdminNombre(String adminNombre) {
        this.adminNombre = adminNombre;
    }

    public String getCorreoAdmin() {
        return correoAdmin;
    }

    public void setCorreoAdmin(String correoAdmin) {
        this.correoAdmin = correoAdmin;
    }
    
    
}
