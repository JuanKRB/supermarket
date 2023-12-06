
package modelo;

public class Administrador extends Persona{
    
    private String adminNombre;
    private String correoAdmin;

    public Administrador(int id, int contra, String statusLogin, String fechaRegistrado, String adminNombre, String correoAdmin) {
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
