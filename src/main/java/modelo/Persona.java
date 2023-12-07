
package modelo;

 public class Persona {
    
    private int id;
    private String statusLogin;
    private String fechaRegistrado;

    public Persona(int id, String statusLogin, String fechaRegistrado) {
        this.id = id;
        this.statusLogin = statusLogin;
        this.fechaRegistrado = fechaRegistrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
