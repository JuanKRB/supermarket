
package modelo;

import controller.AlimentoController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ElectronicoController", urlPatterns = {"/ElectronicoController"})
public class ElectronicoController extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ElectronicoJDBC electronicoJDBC = null;

        try {
            electronicoJDBC = new ElectronicoJDBC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");
        
        if (accion == null || accion.isEmpty()) {

            dispatcher = request.getRequestDispatcher("productos.jsp");
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("lista", listaElectronicos);
            
        }  else if ("listarTablaElectronico".equals(accion)) {
            
            dispatcher = request.getRequestDispatcher("tablaElectrodomesticos.jsp");
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("lista", listaElectronicos);
             
        }else if ("eliminar".equals(accion)) {
           int id = Integer.parseInt(request.getParameter("id"));

            electronicoJDBC.eliminar(id);
            dispatcher = request.getRequestDispatcher("tablaElectrodomesticos.jsp");
            List<Electronico> listaElectronico = electronicoJDBC.listaElectronicos();
            request.setAttribute("lista", listaElectronico);
             
        }else if ("guardar".equals(accion)) {

            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int idmarca = Integer.parseInt(request.getParameter("idmarca"));
            String disponibilidad = request.getParameter("disponibilidad");
            int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
            int idSubCategoria = Integer.parseInt(request.getParameter("idSubcategoria"));
            String especificaciones = request.getParameter("especificaciones");

           
            String rutaImagen = "./imagenes/" + nombre + ".png";
            Electronico electronico = new Electronico(idmarca, nombre, descripcion, precio, cantidad, idmarca, disponibilidad, idCategoria, idSubCategoria, rutaImagen, especificaciones);
           
            electronicoJDBC.insertar(electronico);
            
            dispatcher = request.getRequestDispatcher("tablaElectrodomesticos.jsp");
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("lista", listaElectronicos);
            

        } else if ("modificar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            Electronico electronico = electronicoJDBC.mostrar(id);
            
            dispatcher = request.getRequestDispatcher("modificarElectronico.jsp"); 
            request.setAttribute("electronico", electronico);

           
        }else if ("actualizar".equals(accion)) {
            
             int id = Integer.parseInt(request.getParameter("id"));
            String imagen = request.getParameter("imagen");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int idmarca = Integer.parseInt(request.getParameter("idmarca"));
            String disponibilidad = request.getParameter("disponibilidad");
            int idCategoria = Integer.parseInt(request.getParameter("idcategoria"));
            int idSubCategoria = Integer.parseInt(request.getParameter("idSubcategoria"));
            String especificaciones = request.getParameter("especificaciones");
            
            Electronico electronico = new Electronico(id, nombre, descripcion, precio, cantidad, idmarca, disponibilidad, idCategoria, idSubCategoria, imagen, especificaciones);
            
            electronicoJDBC.actualizar(electronico);
            
            dispatcher = request.getRequestDispatcher("tablaElectrodomesticos.jsp");
            
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("lista", listaElectronicos);
          
        } else {
            dispatcher = request.getRequestDispatcher("Inicio.jsp");
            List<Electronico> listaElectronicos = electronicoJDBC.listaElectronicos();
            request.setAttribute("lista", listaElectronicos);
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
