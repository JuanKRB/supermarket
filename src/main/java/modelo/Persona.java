
package modelo;

abstract public class Persona {
    
    private int id;
    private int contra;
    private String statusLogin;
    private String fechaRegistrado;

    public Persona(int id, int contra, String statusLogin, String fechaRegistrado) {
        this.id = id;
        this.contra = contra;
        this.statusLogin = statusLogin;
        this.fechaRegistrado = fechaRegistrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContra() {
        return contra;
    }

    public void setContra(int contra) {
        this.contra = contra;
    }

    public String getStatusLogin() {
        return statusLogin;
    }

    public void setStatusLogin(String statusLogin) {
        this.statusLogin = statusLogin;
    }

    public String getFechaRegistrado() {
        return fechaRegistrado;
    }

    public void setFechaRegistrado(String fechaRegistrado) {
        this.fechaRegistrado = fechaRegistrado;
    }
    
    
    
}
