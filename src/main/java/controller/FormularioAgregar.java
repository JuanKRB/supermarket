
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



@WebServlet(name = "FormularioAgregar", urlPatterns = {"/FormularioAgregar"})
public class FormularioAgregar extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        // Verifica si se presionó el botón de agregar
        if (request.getParameter("agregar") != null) {
            // Configura el atributo en la sesión para mostrar el formulario
            session.setAttribute("mostrarFormulario", true);
        } else {
            // Lógica de procesamiento del formulario aquí si es necesario
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String precio = request.getParameter("precio");
            String cantidad = request.getParameter("cantidad");
            String fechaRecibido = request.getParameter("fechaRecibido");
            String sucursal = request.getParameter("sucursal");
            String proveedor = request.getParameter("proveedor");
            String marca = request.getParameter("marca");
            String ingredientes = request.getParameter("ingredientes");
            String calorias = request.getParameter("calorias");
            String proteinas = request.getParameter("proteinas");
            String grasas = request.getParameter("grasas");
            String cad = request.getParameter("cad");
            String tipo = request.getParameter("tipo");

            // Validación simple: verifica si todos los campos requeridos están presentes
            if (id != null && nombre != null && descripcion != null) {
                // Crea un nuevo producto como cadena y agrega a la lista en la sesión
                String nuevoProducto = "ID: " + id + ", Nombre: " + nombre + ", Descripción: " + descripcion
                        + ", Precio: " + precio + ", Cantidad: " + cantidad + ", Fecha Recibido: " + fechaRecibido
                        + ", Sucursal: " + sucursal + ", Proveedor: " + proveedor + ", Marca: " + marca
                        + ", Ingredientes: " + ingredientes + ", Calorías: " + calorias + ", Proteínas: " + proteinas
                        + ", Grasas: " + grasas + ", CAD: " + cad + ", Tipo: " + tipo;

                List<String> listaProductos = obtenerListaProductosDesdeSesion(session);
                listaProductos.add(nuevoProducto);
            }

            // Después de procesar, vuelve a configurar el atributo en la sesión para ocultar el formulario
            session.setAttribute("mostrarFormulario", false);
        }

        // Redirecciona de nuevo a tu página JSP
        dispatcher = request.getRequestDispatcher("tablaAlimentos.jsp");
        dispatcher.forward(request, response);
    }

    private List<String> obtenerListaProductosDesdeSesion(HttpSession session) {
        // Obtiene la lista de productos desde la sesión, si no existe, la crea
        List<String> listaProductos = (List<String>) session.getAttribute("listaProductos");
        if (listaProductos == null) {
            listaProductos = new ArrayList<>();
            session.setAttribute("listaProductos", listaProductos);
        }
        return listaProductos;
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
