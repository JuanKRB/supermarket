

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/admin2.css">
         <link rel="stylesheet" href="./css/IniciarSesion2.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>
        
     <%@ include file="header.jsp" %>

        <main>


        <div class="informacion-usuario">

                <img src="img/perfil2.png" alt=""/>

                <h4>Admin1</h4>

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

                <a href="tablaClientes.jsp">
                    <div class="configuracionUsuarios">
                        <img src="img/configuracion.png" alt=""/>
                        <div class="h4">
                            <h4>Configuracion Usuarios</h4>
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
