package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Alimento;
import modelo.AlimentoJDBC;
import modelo.CarritoAlimento;
import modelo.CarritoBebida;
import modelo.CarritoElectronico;
import modelo.CarritoProductoJDBC;
import modelo.Cliente;

@WebServlet(name = "CarritoController", urlPatterns = {"/CarritoController"})
public class CarritoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        CarritoProductoJDBC carritoProductoJDBC = null;

        try {
            carritoProductoJDBC = new CarritoProductoJDBC();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlimentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String accion;
        RequestDispatcher dispatcher = null;

        accion = request.getParameter("accion");

        HttpSession session = request.getSession();

        int idCarritoCompra = 0;

        if (session.getAttribute("idCarritoCompra") != null) {
            idCarritoCompra = (Integer) session.getAttribute("idCarritoCompra");
        }

        if (accion == null || accion.isEmpty()) {

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("eliminarAlimento".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            carritoProductoJDBC.eliminarAlimento(id);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("eliminarbebida".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            carritoProductoJDBC.eliminarBebida(id);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("eliminarElectronico".equals(accion)) {

            int id = Integer.parseInt(request.getParameter("id"));

            carritoProductoJDBC.eliminarElectronico(id);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("agregarAcarritoAlimento".equals(accion)) {

            int id_alimento = Integer.parseInt(request.getParameter("id"));

            carritoProductoJDBC.insertar(idCarritoCompra, id_alimento);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("agregarAcarritoElectronico".equals(accion)) {

            int id_electronico = Integer.parseInt(request.getParameter("id"));

            carritoProductoJDBC.insertarCarritoElectronicos(idCarritoCompra, id_electronico);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("agregarAcarritoBebida".equals(accion)) {

            int id_bebida = Integer.parseInt(request.getParameter("id"));

            carritoProductoJDBC.insertarCarritoBebida(idCarritoCompra, id_bebida);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("actualizarCarritoBebida".equals(accion)) {

            int nuevaCantidad = Integer.parseInt(request.getParameter("nuevaCantidad").trim());
            int idCarritoBebida = Integer.parseInt(request.getParameter("idCarritoBebida"));

            carritoProductoJDBC.actualizarCarritoBebidas(idCarritoBebida, nuevaCantidad);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("actualizarCarritoAlimento".equals(accion)) {

            int nuevaCantidad = Integer.parseInt(request.getParameter("nuevaCantidad").trim());
            int idCarritoBebida = Integer.parseInt(request.getParameter("idCarritoAlimento"));

            carritoProductoJDBC.actualizarCarritoAlimentos(idCarritoBebida, nuevaCantidad);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("actualizarCarritoElectronico".equals(accion)) {

            int nuevaCantidad = Integer.parseInt(request.getParameter("nuevaCantidad").trim());
            int idCarritoBebida = Integer.parseInt(request.getParameter("idCarritoElectronico"));

            carritoProductoJDBC.actualizarCarritoElectronicos(idCarritoBebida, nuevaCantidad);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("agregarCupon".equals(accion)) {

            double cupon = Double.parseDouble(request.getParameter("cupon").trim());

            double descuento = 80.0;

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);
            session.setAttribute("descuento", descuento);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
            dispatcher.forward(request, response);

        } else if ("mostarFactura".equals(accion)) {

            Cliente clienteSesion;
            
            int idcliente = 0;

            if (session.getAttribute("clienteSesion") != null) {
                clienteSesion = (Cliente) session.getAttribute("clienteSesion");
                idcliente = clienteSesion.getId();
            }
            
            double sumaTotal = Double.parseDouble(request.getParameter("sumaTotal").trim());
            double impuestos = Double.parseDouble(request.getParameter("impuestos").trim());
            double sumaFinal = Double.parseDouble(request.getParameter("sumaFinal").trim());

            carritoProductoJDBC.insertarFactura(idcliente, sumaTotal, impuestos, sumaFinal);

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);
            List<CarritoElectronico> listaCarritoElectronicos = carritoProductoJDBC.listaCarritoElectronicoInnerJoin(idCarritoCompra);
            List<CarritoBebida> listaCarritoBebidas = carritoProductoJDBC.listaCarritoBebidaInnerJoin(idCarritoCompra);

            session.setAttribute("listaCarritoAlimento", listaCarritoAlimentos);
            session.setAttribute("listaCarritoElectronicos", listaCarritoElectronicos);
            session.setAttribute("listaCarritoBebidas", listaCarritoBebidas);

            dispatcher = request.getRequestDispatcher("factura.jsp");
            dispatcher.forward(request, response);

        } else {

            List<CarritoAlimento> listaCarritoAlimentos = carritoProductoJDBC.listaCarritoAlimentoInnerJoin(idCarritoCompra);

            dispatcher = request.getRequestDispatcher("carrito.jsp");
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
