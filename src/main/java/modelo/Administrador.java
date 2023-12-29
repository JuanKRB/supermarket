
package modelo;

public class Administrador extends Persona{
    
    private String adminNombre;
    private String correoAdmin;
    private String contraAdmin;

    public Administrador(int id, String statusLogin,String adminNombre, String correoAdmin, String contraAdmin) {
        super(id, statusLogin);
        this.adminNombre = adminNombre;
        this.correoAdmin = correoAdmin;
        this.contraAdmin = contraAdmin;
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

    public String getContraAdmin() {
        return contraAdmin;
    }

    public void setContraAdmin(String contraAdmin) {
        this.contraAdmin = contraAdmin;
    }
    
    
    
}
