


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Administrador"%>
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

           Administrador administrador = (Administrador) request.getAttribute("administrador"); 

        %>
        
        <form action="adminController?accion=actualizar&id=<%=administrador.getId()%>" method="POST">

            <div class="enLInea">


                <div class="enLinea2">
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" value="<%=administrador.getAdminNombre()%>">
                </div>

                <div class="enLinea2">
                    <label for="nombre">Contraseña</label>
                    <input type="text" name="contra" id="contra" value="<%= administrador.getContraAdmin() %>">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">

                    <label for="descripcion">StatusLogin</label>
                    <input type="text" name="statusLogin" id="statusLogin" value="<%= administrador.getStatusLogin() %>">
                </div>

                <div class="enLinea2">
                    <label for="precio">Correo</label>
                    <input type="text" name="correo" id="correo" value="<%= administrador.getCorreoAdmin() %>">
                </div>

            </div>


            <input type="submit" value="Guardar" class="boton">
        </form>
    </body>
</html>
