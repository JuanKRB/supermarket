


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
        <title>Supermercado</title>
    </head>
    
    <body>
        <form action="adminController?accion=guardar" method="POST">

            <div class="enLInea">


                <div class="enLinea2">
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre">
                </div>

                <div class="enLinea2">
                    <label for="nombre">Contraseña:</label>
                    <input type="text" name="contra" id="contra">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">

                    <label for="descripcion">Status Login:</label>
                    <input type="text" name="statusLogin" id="statusLogin">
                </div>

                <div class="enLinea2">
                    <label for="precio">Correo Empresarial</label>
                    <input type="text" name="correo" id="correo">
                </div>

            </div>

            <input type="submit" value="Guardar" class="boton">
        </form>
    </body>
</html>
