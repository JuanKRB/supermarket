package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "Supermercado")
public class Usuario2 {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idcliente")
    private Long idCliente;
    @Column(name = "contra")
    private String contra;
    @Column(name = "statusLogin")
    private String statusLogin;
    @Column(name = "fecharegistro")
    private String fecharegistro;
    @Column(name = "nombrecliente")
    private String nombrecliente;
    @Column(name = "correo")
    private String correo;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getStatusLogin() {
        return statusLogin;
    }

    public void setStatusLogin(String statusLogin) {
        this.statusLogin = statusLogin;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

 

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idCliente);
        hash = 83 * hash + Objects.hashCode(this.correo);
        hash = 83 * hash + Objects.hashCode(this.contra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario2 other = (Usuario2) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contra, other.contra)) {
            return false;
        }
        return Objects.equals(this.idCliente, other.idCliente);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("idUsuario=").append(idCliente);
        sb.append(", correo=").append(correo);
        sb.append(", contra=").append(contra);
        sb.append('}');
        return sb.toString();
    }
}
