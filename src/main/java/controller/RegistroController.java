package controller;

import jakarta.resource.spi.AdministeredObject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        
        HttpSession session = request.getSession();

        RegistroJDBC registrojdbc = new RegistroJDBC();
        
        String noCuenta;

        if ("irALogin".equals(accion)) {
            noCuenta = "F";
            session.setAttribute("noCuenta", noCuenta);
            dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
            dispatcher.forward(request, response);
            
        } else if ("login".equals(accion)) {

            List<Cliente> listaClientes = registrojdbc.listaClientes(correo, contra);
            List<SuperAdministrador> listaSuperAdministradores = registrojdbc.listaSuperAdministradores(correo, contra);
            List<Administrador> listaAdministradores = registrojdbc.listaAdministradores(correo, contra);

             for (Cliente iteradorCliente : listaClientes) {
                if (iteradorCliente != null) {
                    if (iteradorCliente.getCorreoCliente().equals(correo) && iteradorCliente.getContraCliente().equals(contra)) {
                        dispatcher = request.getRequestDispatcher("usuario.jsp");
                        break;
                    }
                }
            }

            for (SuperAdministrador iteradorSuperAdministrador : listaSuperAdministradores) {
                if (iteradorSuperAdministrador != null) {
                    if (iteradorSuperAdministrador.getSuperAdminCorreo().equals(correo) && iteradorSuperAdministrador.getContraSuperAdmin().equals(contra)) {
                        dispatcher = request.getRequestDispatcher("superAdmin.jsp");
                        break;
                    }
                }
            }

            for (Administrador iteradorAdministrador : listaAdministradores) {
                if (iteradorAdministrador != null) {
                    if (iteradorAdministrador.getCorreoAdmin().equals(correo) && iteradorAdministrador.getContraAdmin().equals(contra)) {
                        dispatcher = request.getRequestDispatcher("admin.jsp");
                        break;
                    }
                }
            }

            if (dispatcher == null) { 
                noCuenta = "V";
                session.setAttribute("noCuenta", noCuenta);
                dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
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
            Logger.getLogger(RegistroController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistroController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
