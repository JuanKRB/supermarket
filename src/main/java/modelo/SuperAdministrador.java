
package modelo;

public class SuperAdministrador extends Persona{

    private String superAdminNombre;
    private String superAdminCorreo;
    private String contraSuperAdmin;

    public SuperAdministrador(int id, String statusLogin, String superAdminNombre, String superAdminCorreo, String contraSuperAdmin) {
        super(id, statusLogin);
        this.superAdminNombre = superAdminNombre;
        this.superAdminCorreo = superAdminCorreo;
        this.contraSuperAdmin = contraSuperAdmin;
    }

    public String getSuperAdminNombre() {
        return superAdminNombre;
    }

    public void setSuperAdminNombre(String superAdminNombre) {
        this.superAdminNombre = superAdminNombre;
    }

    public String getSuperAdminCorreo() {
        return superAdminCorreo;
    }

    public void setSuperAdminCorreo(String superAdminCorreo) {
        this.superAdminCorreo = superAdminCorreo;
    }

    public String getContraSuperAdmin() {
        return contraSuperAdmin;
    }

    public void setContraSuperAdmin(String contraSuperAdmin) {
        this.contraSuperAdmin = contraSuperAdmin;
    }
    
    
 
}
