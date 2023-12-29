
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
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

        <%

         String verificarSesion = null;

         if (session.getAttribute("verificarSesion") != null ) {
            verificarSesion = (String) session.getAttribute("verificarSesion");
            
            if (verificarSesion.equals("AD")) {
        %>
        <div class="botonL">
            <a href="admin.jsp" ><img src="img/atras.png" alt=""/> Atras</a>
        </div><br>

        <%
        }else{
        %>
        <div class="botonL">
            <a href="superAdmin.jsp" ><img src="img/atras.png" alt=""/> Atras</a>
        </div><br>

        <%
        
        }
            
     }

        %>
        
        <br><br><br>
        
        <a href="agregarCliente.jsp">
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
                        <th>Nombre Cliente</th>
                        <th>Correo</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <% 

                     List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("lista"); 
            
                     for( Cliente clienIT : listaClientes) {
  
                %>
                <tbody>
                    <tr>
                        <td><%= clienIT.getId() %></td>
                        <td><%= clienIT.getContraCliente() %></td>
                        <td><%= clienIT.getStatusLogin() %></td>
                        <td><%= clienIT.getNombreCliente() %></td>
                        <td><%= clienIT.getCorreoCliente() %></td>
                        <td>
                            <div class="icon-buttons-container">
                                <form action="ClienteController?accion=eliminar&id=<%= clienIT.getId() %>" method="post" id="miFormulario" class="icon-form">
                                    <button type="submit" name="id" value="${usuario.id}" class="icon-button">
                                        <i class="gg-trash"></i>
                                    </button>
                                </form>
                                <form action="ClienteController?accion=modificar&id=<%= clienIT.getId() %>" method="post" class="icon-form">
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
