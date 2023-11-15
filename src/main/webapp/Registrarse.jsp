<%-- 
    Document   : Registrarse
    Created on : 15 nov. 2023, 14:24:18
    Author     : Carlos Oviedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="miFormulario" action="" method="POST">
           <label for="correo">Correo:</label>
            <input type="text" id="correo" name="correo" required>

            <label for="contra">Contraseña:</label>
            <input type="password" id="contra" name="contra" required><br><br>

            <button type="submit">Registrarse</button><br>

        </form>
    </body>
</html>
