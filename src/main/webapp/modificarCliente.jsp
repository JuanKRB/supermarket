
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="stylesheet" href="./css/agregarTabla2.css">
        <title>Supermercadoo</title>
    </head>

    <body>
        
        <% 

           Cliente cliente = (Cliente) request.getAttribute("cliente"); 

        %>
        
        <form action="ClienteController?accion=actualizar&id=<%=cliente.getId()%>" method="POST">

            <div class="enLInea">


                <div class="enLinea2">
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" value="<%=cliente.getNombreCliente()%>">
                </div>

                <div class="enLinea2">
                    <label for="nombre">Contraseña</label>
                    <input type="text" name="contra" id="contra" value="<%= cliente.getContraCliente() %>">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">

                    <label for="descripcion">StatusLogin</label>
                    <input type="text" name="statusLogin" id="statusLogin" value="<%= cliente.getStatusLogin() %>">
                </div>

                <div class="enLinea2">
                    <label for="precio">Correo</label>
                    <input type="text" name="correo" id="correo" value="<%= cliente.getCorreoCliente() %>">
                </div>

            </div>


            <input type="submit" value="Guardar" class="boton">
        </form>
    </body>
</html>
