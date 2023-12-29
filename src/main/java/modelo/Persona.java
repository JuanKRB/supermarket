
package modelo;

 public class Persona {
    
    private int id;
    private String statusLogin;

    public Persona(int id, String statusLogin ) {
        this.id = id;
        this.statusLogin = statusLogin;
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

    
    
    
}
