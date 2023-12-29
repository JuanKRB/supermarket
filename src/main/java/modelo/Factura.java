
package modelo;


public class Factura {
    
    private int id_factura;
    private int id_cliente;
    private double sumaTotal;
    private double impuestos;
    private double sumaFinal;

    public Factura(int id_factura, int id_cliente, double sumaTotal, double impuestos, double sumaFinal) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.sumaTotal = sumaTotal;
        this.impuestos = impuestos;
        this.sumaFinal = sumaFinal;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getSumaTotal() {
        return sumaTotal;
    }

    public void setSumaTotal(double sumaTotal) {
        this.sumaTotal = sumaTotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getSumaFinal() {
        return sumaFinal;
    }

    public void setSumaFinal(double sumaFinal) {
        this.sumaFinal = sumaFinal;
    }
    
    
    
}
