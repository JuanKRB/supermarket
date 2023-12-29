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

@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        String accion;

        accion = request.getParameter("accion");

        RequestDispatcher dispatcher = null;

        AlimentoJDBC alimentoJDBC = new AlimentoJDBC();
        BebidaJDBC bebidaJDBC = new BebidaJDBC();
        ElectronicoJDBC electronicoJDBC = new ElectronicoJDBC();

        if ("mostraBuscarPagina".equals(accion)) {

            dispatcher = request.getRequestDispatcher("buscar.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("listaAlimentos", listaAlimentos);
            
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("listaElectronicos", listaElectronicos);
            
            
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("listaBebidas", listaBebidas);

        }else if ("buscar".equals(accion)) {

            String nombre = request.getParameter("nombre");

            alimentoJDBC.buscarPorNombre(nombre);
            dispatcher = request.getRequestDispatcher("buscado.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);
            
            
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("listaElectronicos", listaElectronicos);
            
            
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("listaBebidas", listaBebidas);
            
            
            request.setAttribute("nombre", nombre);

        } else if ("irCarnes".equals(accion)){
            dispatcher = request.getRequestDispatcher("Carnes.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("listaAlimentos", listaAlimentos);
            
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("listaBebidas", listaBebidas);
            
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("listaElectronicos", listaElectronicos);

        }else if ("categoriaFrutas".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Frutas.jsp");
             List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("listaAlimentos", listaAlimentos);
        }else if ("categoriaElectronicos".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Electrodomesticos.jsp");
             List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("listaElectronicos", listaElectronicos);
        }else if ("categoriaGalletas".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Galletas.jsp");
             List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("listaAlimentos", listaAlimentos);
        }else if ("categoriaBebidas".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Bebidas.jsp");
             List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("listaBebidas", listaBebidas);
        }else {
            dispatcher = request.getRequestDispatcher("productos.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("listaAlimentos", listaAlimentos);
            
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("listaBebidas", listaBebidas);
            
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("listaElectronicos", listaElectronicos);

        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
