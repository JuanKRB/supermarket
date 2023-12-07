package controller;

import jakarta.resource.spi.AdministeredObject;
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
import modelo.Administrador;
import modelo.Alimento;
import modelo.Cliente;
import modelo.Persona;
import modelo.RegistroJDBC;
import modelo.SuperAdministrador;

@WebServlet(name = "RegistroController", urlPatterns = {"/RegistroController"})
public class RegistroController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        String correo = request.getParameter("email");
        String contra = request.getParameter("password");

        String accion = request.getParameter("accion");

        RequestDispatcher dispatcher = null;

        RegistroJDBC registrojdbc = new RegistroJDBC();

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
        } else if ("login".equals(accion)) {

            List<Persona> listaPersonas = registrojdbc.listaPersonas(correo, contra);

            for (Persona iterador : listaPersonas) {
                if (iterador instanceof Cliente) {
                    Cliente cliente = (Cliente) iterador;
                    System.out.println(cliente.getNombreCliente());
                    if (cliente.getCorreoCliente().equals(correo) && cliente.getContraCliente().equals(contra)) {
                        dispatcher = request.getRequestDispatcher("usuario.jsp");
                        break;
                    }

                } else if (iterador instanceof SuperAdministrador) {
                    SuperAdministrador superadmin = (SuperAdministrador) iterador;
                    if (superadmin.getSuperAdminCorreo().equals(correo) && superadmin.getContraSuperAdmin().equals(contra)) {
                        dispatcher = request.getRequestDispatcher("SuperAdministrador.jsp");
                        break;
                    }

                } else if (iterador instanceof Administrador) {
                    Administrador admin = (Administrador) iterador;
                    if (admin.getCorreoAdmin().equals(correo) && admin.getContraAdmin().equals(contra)) {
                        dispatcher = request.getRequestDispatcher("admin.jsp");
                        break;
                    }
                } else {
                    dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
                    break;
                }

            }
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
