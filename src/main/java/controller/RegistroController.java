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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Administrador;
import modelo.Alimento;
import modelo.CarritoAlimento;
import modelo.CarritoProductoJDBC;
import modelo.Cliente;
import modelo.Persona;
import modelo.RegistroJDBC;
import modelo.SuperAdministrador;

@WebServlet(name = "RegistroController", urlPatterns = {"/RegistroController"})
public class RegistroController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");

        String correo = request.getParameter("email");
        String contra = request.getParameter("password");

        String contraEncrip = null;

        String contraEncripRegistro = null;

        String accion = request.getParameter("accion");

        RequestDispatcher dispatcher = null;

        HttpSession session = request.getSession();

        RegistroJDBC registrojdbc = new RegistroJDBC();

        CarritoProductoJDBC carritoProductoJDBC = new CarritoProductoJDBC();

        String noCuenta = null;

        String verificarSesion = null;

        if ("irALogin".equals(accion)) {
            noCuenta = "F";
            session.setAttribute("noCuenta", noCuenta);
            dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
            dispatcher.forward(request, response);

        } else if ("verificarSesionApagina".equals(accion)) {

            if (session.getAttribute("verificarSesion") == null) {
                dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
            } else {
                if (session.getAttribute("verificarSesion").equals("C")) {
                    dispatcher = request.getRequestDispatcher("usuario.jsp");
                } else if (session.getAttribute("verificarSesion").equals("SP")) {
                    dispatcher = request.getRequestDispatcher("superAdmin.jsp");
                } else {
                    dispatcher = request.getRequestDispatcher("admin.jsp");
                }
            }
            dispatcher.forward(request, response);

        } else if ("registro".equals(accion)) {

            String correoRegistro = request.getParameter("correoRegistro");
            String contraRegistro = request.getParameter("contraRegistro");
            String nombreRegistro = request.getParameter("nombreRegistro");

            if (contraRegistro != null) {
                contraEncripRegistro = convertirdorHexMD5(contraRegistro);
            }

            Cliente cliente = new Cliente(0, "Logueado", nombreRegistro, correoRegistro, contraEncripRegistro);

            registrojdbc.Registrarse(cliente);

            dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
            dispatcher.forward(request, response);

        } else if ("cerrarSesion".equals(accion)) {

            if (session != null) {
                session.invalidate();
                dispatcher = request.getRequestDispatcher("IniciarSesion.jsp");
                dispatcher.forward(request, response);
            }

        } else if ("login".equals(accion)) {

            if (contra != null) {
                contraEncrip = convertirdorHexMD5(contra);
            }

            List<Cliente> listaClientes = registrojdbc.listaClientes(correo, contraEncrip);
            List<SuperAdministrador> listaSuperAdministradores = registrojdbc.listaSuperAdministradores(correo, contraEncrip);
            List<Administrador> listaAdministradores = registrojdbc.listaAdministradores(correo, contraEncrip);

            for (Cliente iteradorCliente : listaClientes) {
                if (iteradorCliente != null) {
                    if (iteradorCliente.getCorreoCliente().equals(correo) && iteradorCliente.getContraCliente().equals(contraEncrip)) {
                        verificarSesion = "C";
                        session.setAttribute("verificarSesion", verificarSesion);

                        int idSesion = iteradorCliente.getId();
                        String nombreSesion = iteradorCliente.getNombreCliente();
                        String contraSesion = iteradorCliente.getContraCliente();
                        String correoSesion = iteradorCliente.getCorreoCliente();
                        String statustLoginSesion = iteradorCliente.getStatusLogin();

                        Cliente clienteSesion = new Cliente(idSesion, statustLoginSesion, nombreSesion, correoSesion, contraSesion);

                        session.setAttribute("clienteSesion", clienteSesion);

                        int idCarritoCompra = registrojdbc.buscarIdCarrito(idSesion);
                        
                        System.out.println("Id del carrito compra antes de insertart" + idCarritoCompra);

                        
                        //List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);

                        session.setAttribute("idCarritoCompra", idCarritoCompra);
                         /*
                        if (listaCarritoAlimentos.isEmpty()) {
                            System.out.println("La lista está vacía.");
                        } else {
                            System.out.println("La lista no está vacía.");
                        }

                        for (CarritoAlimento it : listaCarritoAlimentos) {

                            System.out.println("hola2");
                            System.out.println("aaaaaaaa488" + it.getNombreAlimento());
                        }

                        session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);

                         */
                        dispatcher = request.getRequestDispatcher("usuario.jsp");
                        break;
                    }
                }
            }

            for (SuperAdministrador iteradorSuperAdministrador : listaSuperAdministradores) {
                if (iteradorSuperAdministrador != null) {
                    if (iteradorSuperAdministrador.getSuperAdminCorreo().equals(correo) && iteradorSuperAdministrador.getContraSuperAdmin().equals(contraEncrip)) {
                        verificarSesion = "SP";
                        session.setAttribute("verificarSesion", verificarSesion);

                        int idSesion = iteradorSuperAdministrador.getId();
                        String nombreSesion = iteradorSuperAdministrador.getSuperAdminNombre();
                        String contraSesion = iteradorSuperAdministrador.getContraSuperAdmin();
                        String correoSesion = iteradorSuperAdministrador.getSuperAdminCorreo();
                        String statustLoginSesion = iteradorSuperAdministrador.getStatusLogin();

                        SuperAdministrador superAdministrador = new SuperAdministrador(idSesion, statustLoginSesion, nombreSesion, correoSesion, contraSesion);

                        session.setAttribute("superAdministradorSesion", superAdministrador);

                        dispatcher = request.getRequestDispatcher("superAdmin.jsp");
                        break;
                    }
                }
            }

            for (Administrador iteradorAdministrador : listaAdministradores) {
                if (iteradorAdministrador != null) {
                    if (iteradorAdministrador.getCorreoAdmin().equals(correo) && iteradorAdministrador.getContraAdmin().equals(contraEncrip)) {
                        verificarSesion = "AD";
                        session.setAttribute("verificarSesion", verificarSesion);

                        int idSesion = iteradorAdministrador.getId();
                        String nombreSesion = iteradorAdministrador.getAdminNombre();
                        String contraSesion = iteradorAdministrador.getContraAdmin();
                        String correoSesion = iteradorAdministrador.getCorreoAdmin();
                        String statustLoginSesion = iteradorAdministrador.getStatusLogin();

                        Administrador Administrador = new Administrador(idSesion, statustLoginSesion, nombreSesion, correoSesion, contraSesion);

                        session.setAttribute("administradorSesion", Administrador);

                        dispatcher = request.getRequestDispatcher("admin.jsp");
                        break;
                    }
                }
            }

            if (dispatcher == null || contraEncrip == null) {
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
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
