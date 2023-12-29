

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.CarritoAlimento"%>
<%@page import="modelo.CarritoBebida"%>
<%@page import="modelo.CarritoElectronico"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/carrito5.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %>

        <% 
            
            if (session.getAttribute("verificarSesion") == null) {
        %>  

        <div id="Nologueo">
            <img src="img/candado.png" alt=""/>
            <h4>Debe loguearse para tener un carrito</h4>
        </div>


        <%
        } else if (session.getAttribute("verificarSesion") != "C") {
        %>  

        <div id="Nologueo2">
            <img src="img/candado.png" alt=""/>
            <h4>Debe loguearse en una cuenta de cliente para tener un carrito</h4>
        </div>
        <%
        } else {

          List<CarritoAlimento> listaCarritoAlimento = null;
        
       if (session.getAttribute("listaCarritoAlimento") != null) {
          listaCarritoAlimento = (List<CarritoAlimento>) session.getAttribute("listaCarritoAlimento"); 
        }
             
        List<CarritoBebida> listaCarritoBebidas = null;
        
       if (session.getAttribute("listaCarritoBebidas") != null) {
          listaCarritoBebidas = (List<CarritoBebida>) session.getAttribute("listaCarritoBebidas"); 
        }
             
        List<CarritoElectronico> listaCarritoElectronicos = null;
        
       if (session.getAttribute("listaCarritoElectronicos") != null) {
          listaCarritoElectronicos = (List<CarritoElectronico>) session.getAttribute("listaCarritoElectronicos"); 
        }

       Double descuento = 0.0;

       if (session.getAttribute("descuento") != null) {
          descuento = (Double) session.getAttribute("descuento"); 
        }
        
        Double sumaAlimentos = 0.0;
        Double precioAlimento = 0.0;
        Double sumabebidas = 0.0;

        Double precioBebida = 0.0;
        Double sumaElectronicos = 0.0;
        Double precioElectronico = 0.0;

        Double subTotalAlimento = 0.0;
        Double subTotalBebida = 0.0;
        Double subTotalElectronico= 0.0;

        Double sumaTotal = 0.0;


        %>  

        <div class="principal">

            <div class="informacion">

                <h4 id="producto">Producto</h4>
                <h4>Precio</h4>
                <h4>Cantidad</h4>
                <h4 id="subTotal">Subtotal</h4>
            </div>
            <hr>
            <!--Inicio--> 
            <%
               if(listaCarritoBebidas != null){
               
               for( CarritoBebida bebIT : listaCarritoBebidas) {
               
             subTotalBebida = bebIT.getPrecioBebida() * bebIT.getCantidadEnCarrito();
             
             sumabebidas = sumabebidas + subTotalBebida;
             
            %>
            <div class="todo-producto">
                <div class="div-xRoja">
                    <a href="CarritoController?accion=eliminarbebida&id=<%= bebIT.getId_carritoBebida() %>">
                        <img src="img/xRoja.png" alt="" class="xRoja"/>
                    </a>
                </div>
                <div class="div-producto">
                    <a href="informacionProducto.jsp">
                        <img src="<%= bebIT.getImagen() %>" alt="" class="producto"/>
                    </a>
                </div>    
                <p id="nombreProducto"><%= bebIT.getNombreBebida() %></p>
                <p id="precio">₡<%= bebIT.getPrecioBebida() %></p>
                <form action="CarritoController?accion=actualizarCarritoBebida&idCarritoBebida=<%= bebIT.getId_carritoBebida() %>" method="post">
                    <input type="text" name="nuevaCantidad" value="  <%= bebIT.getCantidadEnCarrito() %>" id="cantidad" required>
                    <button type="submit" id="botonActualizar"><img src="img/actualizar.png" alt="" id="botonActualizarImg"/></button>
                </form>
                <p id="subTotalPrecio">₡<%= subTotalBebida %></p>
            </div>

            <hr>

            <!--Final-->    <% 
                    }
                       }
            %>  


            <%
               if(listaCarritoAlimento != null){
               
               for( CarritoAlimento carrIT : listaCarritoAlimento) {
               
             subTotalAlimento = carrIT.getPrecioAlimento() * carrIT.getCantidadEnCarrito();
             
             
             sumaAlimentos = sumaAlimentos + subTotalAlimento;
            %>
            <div class="todo-producto">
                <div class="div-xRoja">
                    <a href="CarritoController?accion=eliminarAlimento&id=<%= carrIT.getId_carritoAlimento() %>">
                        <img src="img/xRoja.png" alt="" class="xRoja"/>
                    </a>
                </div>
                <div class="div-producto">
                    <a href="informacionProducto.jsp">
                        <img src="<%= carrIT.getImagen() %>" alt="" class="producto"/>
                    </a>
                </div>    
                <p id="nombreProducto"><%= carrIT.getNombreAlimento() %></p>
                <p id="precio">₡<%= carrIT.getPrecioAlimento() %></p>
                <form action="CarritoController?accion=actualizarCarritoAlimento&idCarritoAlimento=<%= carrIT.getId_carritoAlimento() %>" method="post">
                    <input type="text" name="nuevaCantidad" value="  <%= carrIT.getCantidadEnCarrito() %>" id="cantidad" required>
                    <button type="submit" id="botonActualizar"><img src="img/actualizar.png" alt="" id="botonActualizarImg"/></button>
                </form>
                <p id="subTotalPrecio">₡<%= subTotalAlimento %></p>
            </div>

            <hr>

            <% 
               }
                  }
            %>  

            <%
              if(listaCarritoElectronicos != null){
               
              for( CarritoElectronico electIT : listaCarritoElectronicos) {
              
              subTotalElectronico = electIT.getPrecioElectronico() * electIT.getCantidadEnCarrito();
             
             sumaElectronicos = sumaElectronicos + subTotalElectronico;
            %>
            <div class="todo-producto">
                <div class="div-xRoja">
                    <a href="CarritoController?accion=eliminarElectronico&id=<%= electIT.getId_carritoElectronico() %>">
                        <img src="img/xRoja.png" alt="" class="xRoja"/>
                    </a>
                </div>
                <div class="div-producto">
                    <a href="informacionProducto.jsp">
                        <img src="<%= electIT.getImagen() %>" alt="" class="producto"/>
                    </a>
                </div>    
                <p id="nombreProducto"><%= electIT.getNombreElectronico() %></p>
                <p id="precio">₡<%= electIT.getPrecioElectronico() %></p>

                <form action="CarritoController?accion=actualizarCarritoElectronico&idCarritoElectronico=<%= electIT.getId_carritoElectronico() %>" method="post">
                    <input type="text" name="nuevaCantidad" value="  <%= electIT.getCantidadEnCarrito() %>" id="cantidad" required>
                    <button type="submit" id="botonActualizar"><img src="img/actualizar.png" alt="" id="botonActualizarImg"/></button>
                </form>
                <p id="subTotalPrecio">₡<%= subTotalElectronico %></p>
            </div>

            <hr>

            <% 
               }
                  }

             sumaTotal = sumaAlimentos + sumabebidas + sumaElectronicos;

             double impuestos = sumaTotal * 0.13;

             double sumaFinal = impuestos + sumaTotal - descuento;
            %> 
            <div class="div-final">
                <form action="CarritoController?accion=agregarCupon" class="cupon">
                    <input type="text" name="cupon" placeholder=" cupon" required>
                    <button type="sumbit">Aplicar cupon</button>
                </form>
            </div> 
        </div>

        <div class="totales-boton">
            <div class="totales-principal">


                <div class="totales">
                    <div class="subTotal-DIV">
                        <h4 id="7">Subtotal</h4>

                        <p>₡<%= sumaTotal %></p>
                    </div>
                    <hr>
                    <div class="subTotal-DIV">
                        <h4>Descuento</h4>
                        <p id="descuento">₡<%= descuento %></p>
                    </div>
                    <hr>
                    <div class="subTotal-DIV">
                        <h4>Impuestos</h4>
                        <p id="descuento">₡<%= impuestos %></p>
                    </div>
                    <hr>
                    <div class="subTotal-DIV">
                        <h4>Total</h4>
                        <p id="total2">₡<%= sumaFinal %></p>
                    </div>
                </div>

            </div>

            <a href="CarritoController?accion=mostarFactura&sumaTotal=<%= sumaTotal %>&impuestos=<%= impuestos %>&sumaFinal=<%= sumaFinal %>">
                <div class="boton"> 

                    <form action="" class="cupon">
                        <button type="button">Comprar</button>
                    </form>

                </div>
            </a>
        </div>

        <br><br><br>



        <%
        }
 
        %>




    </body>
</html>
