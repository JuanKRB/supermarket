
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
import modelo.Administrador;
import modelo.Cliente;
import modelo.ClienteJDBC;

@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        ClienteJDBC clienteJDBC = null;

        //try {
            clienteJDBC = new ClienteJDBC();
        //} catch (ClassNotFoundException ex) {
           // Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
       // }

        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {

            dispatcher = request.getRequestDispatcher("tablaClientes.jsp");
            List<Cliente> listaClientes = clienteJDBC.listaClientes();
            request.setAttribute("lista", listaClientes);
            
        }  else if ("eliminar".equals(accion)) {
           int id = Integer.parseInt(request.getParameter("id"));

            clienteJDBC.eliminar(id);
            dispatcher = request.getRequestDispatcher("tablaClientes.jsp");
            List<Cliente> listaClientes = clienteJDBC.listaClientes();
            request.setAttribute("lista", listaClientes);
             
        } else if ("modificar".equals(accion)) {
            
            
            
            int id = Integer.parseInt(request.getParameter("id"));

            Cliente cliente = clienteJDBC.mostrar(id);
            
            dispatcher = request.getRequestDispatcher("modificarCliente.jsp"); 
            request.setAttribute("cliente", cliente);

           
        }else if ("guardar".equals(accion)) {

            String nombre = request.getParameter("nombre");
            String contra = request.getParameter("contra");
            String statusLogin = request.getParameter("statusLogin");
            String correo = request.getParameter("correo");

            String contraEncrip = convertirdorHexMD5(contra);

            Cliente cliente = new Cliente(0, statusLogin, nombre, correo, contraEncrip);

            clienteJDBC.insertar(cliente);

            dispatcher = request.getRequestDispatcher("tablaClientes.jsp");

            List<Cliente> listaClientes = clienteJDBC.listaClientes();
            request.setAttribute("lista", listaClientes);

        }else if ("actualizar".equals(accion)) {
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String contra = request.getParameter("contra");
            String statusLogin = request.getParameter("statusLogin");
            String correo = request.getParameter("correo");
            
            
            Cliente cliente = new Cliente(id, statusLogin, nombre, correo, contra);
            
            clienteJDBC.actualizar(cliente);
            
            dispatcher = request.getRequestDispatcher("tablaClientes.jsp");
            
            List<Cliente> listaClientes = clienteJDBC.listaClientes();
            request.setAttribute("lista", listaClientes);
           
        }else if ("configuracion".equals(accion)) {
            

            
            dispatcher = request.getRequestDispatcher("configuracionCuenraUsuario.jsp");
            

           
        }else if ("actualizarNombre".equals(accion)) {
           /* 
            int id = Integer.parseInt(request.getParameter("id"));
            int id = Integer.parseInt(request.getParameter("id"));
            int id = Integer.parseInt(request.getParameter("id"));
            
            
            clienteJDBC.actualizarNombreYcorreo(accion, accion, id);
            
            dispatcher = request.getRequestDispatcher("tablaClientes.jsp");
            
            List<Cliente> listaClientes = clienteJDBC.listaClientes();
            request.setAttribute("lista", listaClientes);
           */
        }  else {
            dispatcher = request.getRequestDispatcher("tablaClientes.jsp");
            List<Cliente> listaClientes = clienteJDBC.listaClientes();
            request.setAttribute("lista", listaClientes);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
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
