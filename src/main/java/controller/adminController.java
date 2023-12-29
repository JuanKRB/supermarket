package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AdminJDBC;
import modelo.Administrador;
import modelo.Alimento;
import modelo.Cliente;
import modelo.ClienteJDBC;

@WebServlet(name = "adminController", urlPatterns = {"/adminController"})
public class adminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");

        AdminJDBC adminJDBC = null;

        //try {
        adminJDBC = new AdminJDBC();
        //} catch (ClassNotFoundException ex) {
        // Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        // }

        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {

            dispatcher = request.getRequestDispatcher("configuracionDeAdmins.jsp");
            List<Administrador> listaAdministradores = adminJDBC.listaAdministradores();
            request.setAttribute("lista", listaAdministradores);

        } else if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));

            adminJDBC.eliminar(id);
            dispatcher = request.getRequestDispatcher("configuracionDeAdmins.jsp");
            List<Administrador> listaAdministradores = adminJDBC.listaAdministradores();
            request.setAttribute("lista", listaAdministradores);

        } else if ("modificar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            Administrador administrador = adminJDBC.mostrar(id);

            dispatcher = request.getRequestDispatcher("modificarAdmin.jsp");
            request.setAttribute("administrador", administrador);

        } else if ("guardar".equals(accion)) {

            String nombre = request.getParameter("nombre");
            String contra = request.getParameter("contra");
            String statusLogin = request.getParameter("statusLogin");
            String correo = request.getParameter("correo");

            String contraEncrip = convertirdorHexMD5(contra);

            Administrador administrador = new Administrador(0, statusLogin, nombre, correo, contraEncrip);

            adminJDBC.insertar(administrador);

            dispatcher = request.getRequestDispatcher("configuracionDeAdmins.jsp");

            List<Administrador> listaAdministradores = adminJDBC.listaAdministradores();
            request.setAttribute("lista", listaAdministradores);

        } else if ("actualizar".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String contra = request.getParameter("contra");
            String statusLogin = request.getParameter("statusLogin");
            String correo = request.getParameter("correo");

            Administrador administrador = new Administrador(id, statusLogin, nombre, correo, contra);

            adminJDBC.actualizar(administrador);

            dispatcher = request.getRequestDispatcher("configuracionDeAdmins.jsp");

            List<Administrador> listaAdministradores = adminJDBC.listaAdministradores();
            request.setAttribute("lista", listaAdministradores);

        } else {
            dispatcher = request.getRequestDispatcher("configuracionDeAdmins.jsp");
            List<Administrador> listaAdministradores = adminJDBC.listaAdministradores();
            request.setAttribute("lista", listaAdministradores);
        }

        if (dispatcher == null) {
            dispatcher = request.getRequestDispatcher("superAdmin.jsp");
        }

        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public String convertirdorHexMD5(String str) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(str.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02x", b));

        }
        return hexString.toString();
    }

}
