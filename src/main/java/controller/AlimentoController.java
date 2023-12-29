package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Alimento;
import modelo.AlimentoJDBC;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@MultipartConfig(maxFileSize = 16 * 1024 * 1024)
@WebServlet(name = "AlimentoController", urlPatterns = {"/AlimentoController"})
public class AlimentoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        AlimentoJDBC alimentoJDBC = null;

        try {
            alimentoJDBC = new AlimentoJDBC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {

            dispatcher = request.getRequestDispatcher("productos.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);
            
        }  else if ("eliminar".equals(accion)) {
           int id = Integer.parseInt(request.getParameter("id"));

            alimentoJDBC.eliminar(id);
            dispatcher = request.getRequestDispatcher("tablaAlimentos.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);
             
        } else if ("mostraBuscarPagina".equals(accion)) {

            dispatcher = request.getRequestDispatcher("buscar.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);

        } else if ("buscar".equals(accion)) {

            String nombre = request.getParameter("nombre");

            alimentoJDBC.buscarPorNombre(nombre);
            dispatcher = request.getRequestDispatcher("buscado.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);
            request.setAttribute("nombre", nombre);

        } else if ("categoriaAlimento".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Alimentos.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);

        } else if ("categoriaCarne".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Carnes.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);

        } else if ("categoriaFrutas".equals(accion)) {
            dispatcher = request.getRequestDispatcher("Frutas.jsp");
             List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
             request.setAttribute("lista", listaAlimentos);

        }  else if ("mostrarTablaAlimentos".equals(accion)) {
            dispatcher = request.getRequestDispatcher("tablaAlimentos.jsp");
             List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
             request.setAttribute("lista", listaAlimentos);

        }else if ("guardar".equals(accion)) {

            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Double precio = Double.parseDouble(request.getParameter("precio"));
             int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int idmarca = Integer.parseInt(request.getParameter("idmarca"));
            String disponibilidad = request.getParameter("disponibilidad");
            String ingredientes = request.getParameter("ingredientes");
            int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
            int idSubCategoria = Integer.parseInt(request.getParameter("idSubcategoria"));
            String calorias = request.getParameter("calorias");

            
            String rutaImagen = "./imagenes/" + nombre + ".png";
            Alimento alimento = new Alimento(0, nombre, descripcion, precio, cantidad, idmarca, disponibilidad, idCategoria, idSubCategoria, rutaImagen, ingredientes, calorias);
           
            alimentoJDBC.insertarPersona(alimento);
            
             dispatcher = request.getRequestDispatcher("tablaAlimentos.jsp");
            
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);
            

        } else if ("modificar".equals(accion)) {
            
            
            int id = Integer.parseInt(request.getParameter("id"));

            Alimento alimento = alimentoJDBC.mostrar(id);
            
            dispatcher = request.getRequestDispatcher("modificarAlimento.jsp"); 
            request.setAttribute("alimento", alimento);

           
        }else if ("actualizar".equals(accion)) {
            
            int id = Integer.parseInt(request.getParameter("id"));
            String imagen = request.getParameter("imagen");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int idmarca = Integer.parseInt(request.getParameter("idmarca"));
            String disponibilidad = request.getParameter("disponibilidad");
            String ingredientes = request.getParameter("ingredientes");
            int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
            int idSubCategoria = Integer.parseInt(request.getParameter("idSubcategoria"));
            String calorias = request.getParameter("calorias");
            
            Alimento alimento = new Alimento(id, nombre, descripcion, precio, cantidad, idmarca, disponibilidad, idCategoria, idSubCategoria, imagen, ingredientes, calorias);
            
            alimentoJDBC.actualizar(alimento);
            
            dispatcher = request.getRequestDispatcher("tablaAlimentos.jsp");
            
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);
           
        } else {
            dispatcher = request.getRequestDispatcher("productos.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);
        }

        if (dispatcher == null) {
            dispatcher = request.getRequestDispatcher("Inicio.jsp");
        }

        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
