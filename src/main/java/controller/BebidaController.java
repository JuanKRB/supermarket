
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
import modelo.Bebida;
import modelo.BebidaJDBC;

@WebServlet(name = "BebidaController", urlPatterns = {"/BebidaController"})
public class BebidaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        BebidaJDBC bebidaJDBC = null;

        try {
            bebidaJDBC = new BebidaJDBC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");
        
        if (accion == null || accion.isEmpty()) {

            dispatcher = request.getRequestDispatcher("productos.jsp");
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("lista", listaBebidas);
            
        }  else if ("listarTablaBebidas".equals(accion)) {
            
            dispatcher = request.getRequestDispatcher("tablaBebidas.jsp");
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("lista", listaBebidas);
             
        }else if ("eliminar".equals(accion)) {
           int id = Integer.parseInt(request.getParameter("id"));

            bebidaJDBC.eliminar(id);
            dispatcher = request.getRequestDispatcher("tablaBebidas.jsp");
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("lista", listaBebidas);
             
        }else if ("guardar".equals(accion)) {

            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Double precio = Double.parseDouble(request.getParameter("precio"));
             int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int idmarca = Integer.parseInt(request.getParameter("idmarca"));
            String disponibilidad = request.getParameter("disponibilidad");
            int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
            int idSubCategoria = Integer.parseInt(request.getParameter("idSubcategoria"));
            String ingredientes = request.getParameter("ingredientes");
            String cantidaLiquido = request.getParameter("cantidaLiquido");

            
            String rutaImagen = "./imagenes/" + nombre + ".png";
            Bebida bebida = new Bebida(idmarca, nombre, descripcion, precio, cantidad, idmarca, disponibilidad, idCategoria, idSubCategoria, rutaImagen, ingredientes, cantidaLiquido);
           
            bebidaJDBC.insertar(bebida);
            
            dispatcher = request.getRequestDispatcher("tablaBebidas.jsp");
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("lista", listaBebidas);
            

        } else if ("modificar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            Bebida bebida = bebidaJDBC.mostrar(id);
            
            dispatcher = request.getRequestDispatcher("modificarBebida.jsp"); 
            request.setAttribute("bebida", bebida);

           
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
            String cantidaLiquido = request.getParameter("cantidaLiquido");
            
            Bebida bebida = new Bebida(id, nombre, descripcion, precio, cantidad, idmarca, disponibilidad, idCategoria, idSubCategoria, imagen, ingredientes, cantidaLiquido);
            
            bebidaJDBC.actualizar(bebida);
            
            dispatcher = request.getRequestDispatcher("tablaBebidas.jsp");
            
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("lista", listaBebidas);
          
        } else {
            dispatcher = request.getRequestDispatcher("Inicio.jsp");
            List<Bebida> listaBebidas = bebidaJDBC.listaBebidas();
            request.setAttribute("lista", listaBebidas);
        }

        if (dispatcher == null) {
            dispatcher = request.getRequestDispatcher("Inicio.jsp");
        }

        dispatcher.forward(request, response);
        
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
