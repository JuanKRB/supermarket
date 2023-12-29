

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.SuperAdministrador"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/superAdmin2.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %>
        
        <%

         SuperAdministrador superAdministradorSesion = null;

         if (session.getAttribute("superAdministradorSesion") != null) {
            superAdministradorSesion = (SuperAdministrador) session.getAttribute("superAdministradorSesion");
         }
        
        %>

        <main>

            <div class="informacion-usuario">

                <img src="img/perfil2.png" alt=""/>

                <h4><%=  superAdministradorSesion.getSuperAdminNombre() %></h4>

                <a href="RegistroController?accion=cerrarSesion" id="aCerrarSesion">
                    <div class="div-cerrarSesion">
                        <h4>Cerrar sesion</h4><img src="img/CerrarSesionIcono.png" alt="" id="CerrarSesionIcono"/>
                    </div>
                </a>

            </div>

            <div class="extras">

                <a href="adminCategorias.jsp">
                    <div class="configuracionProductos">

                        <img src="img/configuracion.png" alt=""/>

                        <div class="h4">
                            <h4>Configuracion Productos</h4>
                        </div>

                        <hr>

                    </div>
                </a>

                <a href="ClienteController">
                    <div class="configuracionUsuarios">
                        <img src="img/configuracion.png" alt=""/>
                        <div class="h4">
                            <h4>Configuracion Usuarios</h4>
                        </div>
                        <hr>
                    </div>
                </a>

                <a href="adminController">
                    <div class="configuracionCuenta">

                        <img src="img/configuracion.png" alt=""/>

                        <div class="h4">
                            <h4>Configuracion Admins</h4>
                        </div>

                        <hr>

                    </div>
                </a>

                <a href="configuracionAdmin.jsp">
                    <div class="configuracionCuenta">

                        <img src="img/configuracion.png" alt=""/>

                        <div class="h4">
                            <h4>Configuracion Cuenta</h4>
                        </div>

                        <hr>

                    </div>
                </a>

            </div>

        </main>

    </body>
</html>
