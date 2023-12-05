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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import modelo.UsuarioJDBC;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        try {
            RequestDispatcher dispatcher = null;
          
            String inicio = (String) request.getParameter("inicio");
            String register = (String) request.getParameter("register");
            String action = (String) request.getParameter("action");
            String email = (String) request.getParameter("email");
            String pass = (String) request.getParameter("password");
            String status = (String) request.getParameter("statusLogin");
            String fecha = (String) request.getParameter("fecharegistro");
            String nombre = (String) request.getParameter("nombrecliente");

            //hola
           //FALTA LO DEL ADMIN
           
            if (action != null && action.equals("salir")) {
                session.invalidate();
                response.sendRedirect("IniciarSesion.jsp");
            }
            // System.out.println("Valor de 'register': " + register);
            if (register != null) {
                if (registrarUsuario(email, pass)) {
                    session.setAttribute("registro", true);
                }
                response.sendRedirect("IniciarSesion.jsp");

            } else {
                if (inicio != null) {
                    if (buscarUsuario(email, pass)) {
                        request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                    } else  {
                        request.setAttribute("inicioSesion", false);
                        request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
                    }
                    dispatcher.forward(request, response);
                }
            }

        } catch (NoSuchAlgorithmException | SQLException e) {
            System.err.print(e.getMessage() + "\n");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    private boolean registrarUsuario(String correo, String contra) throws NoSuchAlgorithmException, ClassNotFoundException {

        String passEncrip = convertirdorHexMD5(contra);

        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        usuario.setContra(passEncrip);

        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        usuario = usuarioJDBC.save(usuario);

        return usuario.getIdCliente() != null;

    }

    private boolean buscarUsuario(String correo, String contra) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException {
        String passEncrip = convertirdorHexMD5(contra);
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        Usuario usuario = usuarioJDBC.findByEmailAndPass(correo, passEncrip);
        return usuario != null;
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
