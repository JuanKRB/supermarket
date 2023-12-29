

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/usuario9.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %>

        <%

         Cliente clienteSesion = null;
         
         int idCarritoCompra = 0;

         if (session.getAttribute("clienteSesion") != null) {
            clienteSesion = (Cliente) session.getAttribute("clienteSesion");
         }
         
         if (session.getAttribute("idCarritoCompra") != null) {
            idCarritoCompra = (Integer) session.getAttribute("idCarritoCompra");
         }
        
        %>

        <main>

            <div class="informacion-usuario">

                <img src="img/perfil2.png" alt=""/>

                <h4><%=  clienteSesion.getNombreCliente() %></h4>

                    <a href="RegistroController?accion=cerrarSesion" id="aCerrarSesion">
                        <div class="div-cerrarSesion">
                            <h4>Cerrar sesion</h4><img src="img/CerrarSesionIcono.png" alt="" id="CerrarSesionIcono"/>
                        </div>
                    </a>

            </div>

            <div class="extras">


                <div class="tarjetas">
                    <div class="img-info">
                        <div class="img-tarjeta">
                            <img src="img/tarjetapng.png" alt=""/>
                        </div>
                        <div class="infoTarjeta">
                            <div class="div1">
                                <h4>Juan Rodriguez</h4>
                                <h4>**********</h4>
                            </div>
                            <div class="div2">
                                <h4>10/02/2023</h4>
                                <h4 id="codigo">***</h4>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <a href="tarjetas.jsp">Ver mis otras tarjetas</a>
                </div>


                <div class="facturas">

                    <div class="img-info-tarjeta">
                        <div class="img-tarjeta">
                            <img src="img/factura.png" alt=""/>
                        </div>
                        <div class="infoFactura">
                            <div class="div1">
                                <h4>Juan Rodriguez</h4>
                                <h4>₡140,000.00</h4>
                            </div>
                            <div class="div2">
                                <h4>10/02/2023</h4>
                                <h4 id="codigo">***</h4>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <a href="facturas.jsp">Ver mis otras facturas</a>

                </div>

                <div class="direcciones">

                    <div class="img-info-dirreciones">
                        <div class="img-tarjeta">
                            <img src="img/dirrecion.png" alt=""/>
                        </div>
                        <div class="infoTarjeta">
                            <div class="div10">
                                <h4>Alajuela</h4>
                                <h4 id="ciudad">Grecia<h4>
                                        </div>
                                        <div class="div11">
                                            <h4>Distrito central</h4>
                                            <h4 id="direccion-excata">500 metros..</h4>
                                        </div>
                                        </div>
                                        </div>
                                        <hr>
                                        <a href="dirreciones.jsp">Ver mis otras dirreciones</a>
                                        </div>

                                        <a href="ClienteController?accion=configuracion&id=<%=  clienteSesion.getId() %>">
                                            <div class="configuracionCuenta">

                                                <div class="img-info-configuracionCuenta">
                                                    <div class="configuracionCuenta-div1">
                                                        <img src="img/configuracion.png" alt=""/>
                                                    </div>  
                                                    <div class="configuracionCuenta-div2">
                                                        <h4>Configuracion cuenta</h4>                          
                                                    </div>
                                                </div>
                                                <hr>
                                            </div>
                                        </a>
                                        </main>



                                        </body>
                                        </html>
