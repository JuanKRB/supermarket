package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductoJDBC {

    Connection conexion;

    public ProductoJDBC() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();

    }
 
     public List<Producto> listaProductosPorNombre(String nombre) throws ClassNotFoundException {

        AlimentoJDBC alimentojdbc = new AlimentoJDBC();
        Alimento alimento = alimentojdbc.buscarPorNombre(nombre);

        ElectronicoJDBC electronicoJDBC = new ElectronicoJDBC();
        Electronico electronico = electronicoJDBC.buscarPorNombre(nombre);
        
        BebidaJDBC bebidaJDBC = new BebidaJDBC();
        Bebida bebida = bebidaJDBC.buscarPorNombre(nombre);

        List<Producto> lista = new ArrayList<>();

        lista.add(alimento);
        lista.add(electronico);
        lista.add(bebida);

        return lista;

    }
    

}
