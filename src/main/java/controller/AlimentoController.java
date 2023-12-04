
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


@WebServlet(name = "AlimentoController", urlPatterns = {"/AlimentoController"})
public class AlimentoController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        } else if ("nuevo".equals(accion)) {
               /*
            dispatcher = request.getRequestDispatcher("Productos/nuevo.jsp");
              */
        } else if ("insertar".equals(accion)) {

           /* String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));

            Producto producto = new Producto(0, codigo, nombre, precio, existencia);

            productoDAO.Insetar(producto);

            dispatcher = request.getRequestDispatcher("Productos/index.jsp");

            List<Producto> listaProductos = productoDAO.listaProductos();
            request.setAttribute("lista", listaProductos);
               */
        } else if ("modificar".equals(accion)) {
         /*
            dispatcher = request.getRequestDispatcher("Productos/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));

            Producto producto = productoDAO.mostarProducto(id);
            request.setAttribute("producto", producto);
          */
        } else if ("actualizar".equals(accion)) {
           /*
            int id = Integer.parseInt(request.getParameter("id"));
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));

            Producto producto = new Producto(id, codigo, nombre, precio, existencia);

            productoDAO.actualizar(producto);

            dispatcher = request.getRequestDispatcher("Productos/index.jsp");

            List<Producto> listaProductos = productoDAO.listaProductos();
            request.setAttribute("lista", listaProductos);
             */
        } else if ("eliminar".equals(accion)) {
            /*
            int id = Integer.parseInt(request.getParameter("id"));

            productoDAO.eliminar(id);
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Producto> listaProductos = productoDAO.listaProductos();
            request.setAttribute("lista", listaProductos);
            */
        }else if ("mostraBuscarPagina".equals(accion)) {
            
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
            
        } else {
            dispatcher = request.getRequestDispatcher("productos.jsp");
            List<Alimento> listaAlimentos = alimentoJDBC.listaAlimentos();
            request.setAttribute("lista", listaAlimentos);
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
