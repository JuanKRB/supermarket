package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Alimento;
import modelo.AlimentoJDBC;
import modelo.Bebida;
import modelo.BebidaJDBC;
import modelo.Electronico;
import modelo.ElectronicoJDBC;
import modelo.Producto;
import modelo.ProductoJDBC;

@WebServlet(name = "MostrarController", urlPatterns = {"/MostrarController"})
public class MostrarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        AlimentoJDBC alimentoJDBC = new AlimentoJDBC();
        BebidaJDBC bebidaJDBC = new BebidaJDBC();
        ElectronicoJDBC electronicoJDBC = new ElectronicoJDBC();

        try {
            alimentoJDBC = new AlimentoJDBC();
            bebidaJDBC = new BebidaJDBC();
            electronicoJDBC = new ElectronicoJDBC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            /*
            dispatcher = request.getRequestDispatcher("productos.jsp");
            List<Producto> listaProductos = productoJDBC.listaProductos();
            request.setAttribute("lista", listaProductos);*/
        } else if ("mostrarAlimento".equals(accion)) {
            
            System.out.println("Estoy en mostar alimento");

            int id = Integer.parseInt(request.getParameter("id"));

            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();

            for (Alimento aliIT : listaAlimentos) {

                int idIT = aliIT.getId();
                
                System.out.println("22222222idIT// " + idIT + " 4444id// " + id);

                if (idIT == id) {

                    int idProducto = aliIT.getId();
                    String descripcionProducto = aliIT.getDescripcion();
                    String nombreProducto = aliIT.getNombre();
                    Double precioProducto = aliIT.getPrecio();
                    int cantidadProducto = aliIT.getCantidad();
                    int idMarcaProducto = aliIT.getId_marca();
                    String disponibilidadProducto = aliIT.getDisponibilidad();
                    int idCategoriaProducto = aliIT.getId_categoria();
                    int idSubCategoriaProducto = aliIT.getId_subCategoria();
                    String imagenProducto = aliIT.getImagen();
                    String ingredientesProducto = aliIT.getIngredientes();
                    String caloriasProducto = aliIT.getCalorias();

                    Alimento alimento = new Alimento(idProducto, nombreProducto, descripcionProducto, precioProducto, cantidadProducto, idMarcaProducto, disponibilidadProducto, idCategoriaProducto, idSubCategoriaProducto, imagenProducto, ingredientesProducto, caloriasProducto);

                    dispatcher = request.getRequestDispatcher("informacionProductoAlimento.jsp");
                    request.setAttribute("alimento", alimento);
                }

            }

        }else if ("mostrarElectronico".equals(accion)) {
            
            int id = Integer.parseInt(request.getParameter("id"));

            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();

            for (Electronico elecIT : listaElectronicos) {

                int idIT = elecIT.getId();
                

                if (idIT == id) {

                    int idProducto = elecIT.getId();
                    String descripcionProducto = elecIT.getDescripcion();
                    String nombreProducto = elecIT.getNombre();
                    Double precioProducto = elecIT.getPrecio();
                    int cantidadProducto = elecIT.getCantidad();
                    int idMarcaProducto = elecIT.getId_marca();
                    String disponibilidadProducto = elecIT.getDisponibilidad();
                    int idCategoriaProducto = elecIT.getId_categoria();
                    int idSubCategoriaProducto = elecIT.getId_subCategoria();
                    String imagenProducto = elecIT.getImagen();
                    String especificacionesProducto = elecIT.getEspecificaciones();

                    Electronico electronico = new Electronico(idProducto, nombreProducto, descripcionProducto, precioProducto, cantidadProducto, idMarcaProducto, disponibilidadProducto, idCategoriaProducto, idSubCategoriaProducto, imagenProducto, especificacionesProducto);

                    dispatcher = request.getRequestDispatcher("informacionProductoElectronico.jsp");
                    request.setAttribute("electronico", electronico);
                }

            }

        }else if ("mostrarBebida".equals(accion)) {
            
            int id = Integer.parseInt(request.getParameter("id"));

            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();

            for (Bebida bebiIT : listaBebidas) {

                int idIT = bebiIT.getId();
                

                if (idIT == id) {

                    int idProducto = bebiIT.getId();
                    String descripcionProducto = bebiIT.getDescripcion();
                    String nombreProducto = bebiIT.getNombre();
                    Double precioProducto = bebiIT.getPrecio();
                    int cantidadProducto = bebiIT.getCantidad();
                    int idMarcaProducto = bebiIT.getId_marca();
                    String disponibilidadProducto = bebiIT.getDisponibilidad();
                    int idCategoriaProducto = bebiIT.getId_categoria();
                    int idSubCategoriaProducto = bebiIT.getId_subCategoria();
                    String imagenProducto = bebiIT.getImagen();
                    String ingredientesProducto = bebiIT.getIngredientes();
                    String cantidadLiquidoProducto = bebiIT.getCantidaLiquido();

                    Bebida bebida = new Bebida(idProducto, nombreProducto, descripcionProducto, precioProducto, cantidadProducto, idMarcaProducto, disponibilidadProducto, idCategoriaProducto, idSubCategoriaProducto, imagenProducto, ingredientesProducto, cantidadLiquidoProducto);

                    dispatcher = request.getRequestDispatcher("informacionProductoBebida.jsp");
                    request.setAttribute("bebida", bebida);
                }

            }

        } else {/*
            dispatcher = request.getRequestDispatcher("productos.jsp");
            List<Producto> listaProductos = productoJDBC.listaProductos();
            request.setAttribute("lista", listaProductos);*/
        }

        if (dispatcher == null) {
            System.out.println("Estoy en igual null");
            dispatcher = request.getRequestDispatcher("Inicio.jsp");
        }

        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
