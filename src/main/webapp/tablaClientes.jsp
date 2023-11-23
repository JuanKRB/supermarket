<%-- 
    Document   : tablaClientes
    Created on : 23 nov. 2023, 16:26:14
    Author     : Carlos Oviedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/TablaAlimentos.css">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="FormularioAgregar" method="post">
            <input type="submit" name="agregar" value="Agregar">
        </form><br>
        <form action="FormularioAgregar" method="post">
            <input type="submit" name="agregar" value="Modificar">
        </form> 

        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Contraseña</th>
                        <th>StatusLogin</th>
                        <th>FechaRegistrado</th>
                        <th>nombreCliente</th>
                        <th>Dirrecion</th>
                        <th>Correo</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>*****</td>
                        <td>Registrado</td>
                        <td>2022</td>
                        <td>Carlos Oviedo</td>
                        <td>Francia</td>
                        <td>coviedoballe@hotmail.com</td>
                        <td>
                            <button form="miFormulario" type="submit" name="id" value="${usuario.id}">
                                Eliminar
                            </button>
                    </tr>

                </tbody>
            </table>
        </div>

        
    </body>
</html>
