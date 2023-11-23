
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


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            
            RequestDispatcher dispatcher = null;
            String correo = request.getParameter("correoLogin");
            String contra = request.getParameter("contraLogin");
            
            if (correo.equals("admin") && contra.equals("admin")) {
                 dispatcher = request.getRequestDispatcher("admin.jsp");
                  session.setAttribute("registro", true);
            }else if (correo.equals("usuario") && contra.equals("usuario")) {
                dispatcher = request.getRequestDispatcher("usuario.jsp");
                 session.setAttribute("registro", true);
            }else{
                dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
                session.setAttribute("registro", false);
            }
                
            
             dispatcher.forward(request, response);
            
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

}
