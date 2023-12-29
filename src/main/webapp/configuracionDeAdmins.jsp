
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Administrador"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/tablaClientes2.css">
        <link rel="stylesheet" href="./css/botonAtras.css">
        <link rel="stylesheet" href="./css/BotonesTablas.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/add.css' rel='stylesheet'>
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/trash.css' rel='stylesheet'>
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/pen.css' rel='stylesheet'>
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <div class="botonL">
            <a href="superAdmin.jsp" ><img src="img/atras.png" alt=""/> Atras</a>

        </div>
        <br><br><br>
        
        <a href="agregarAdmin.jsp">
            <div id="botonAgregar">
                <i class="gg-add"></i><h5>Agregar</h5>
            </div>
        </a>
        <br>


        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Contraseña</th>
                        <th>StatusLogin</th>
                        <th>Nombre Admin</th>
                        <th>Correo Admin</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <% 

                     List<Administrador> listaAdministradores = (List<Administrador>) request.getAttribute("lista"); 
            
                     for( Administrador adminIT : listaAdministradores) {
  
                %>
                <tbody>
                    <tr>
                        <td><%= adminIT.getId() %></td>
                        <td><%= adminIT.getContraAdmin() %></td>
                        <td><%= adminIT.getStatusLogin() %></td>
                        <td><%= adminIT.getAdminNombre() %></td>
                        <td><%= adminIT.getCorreoAdmin() %></td>
                        <td>
                            <div class="icon-buttons-container">
                                <form action="adminController?accion=eliminar&id=<%= adminIT.getId() %>" method="post" id="miFormulario" class="icon-form">
                                    <button type="submit" name="id" value="${usuario.id}" class="icon-button">
                                        <i class="gg-trash"></i>
                                    </button>
                                </form>
                                <form action="adminController?accion=modificar&id=<%= adminIT.getId() %>" method="post" class="icon-form">
                                    <button type="submit" name="agregar" class="icon-button">
                                        <i class="gg-pen"></i>
                                    </button>
                                </form>
                            </div>
                    </tr>

                </tbody>
                <% } %> 
            </table>
        </div>


    </body>
</html>
