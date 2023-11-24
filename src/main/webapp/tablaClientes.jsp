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
        <link rel="stylesheet" href="./css/botonAtras.css">
        <link rel="stylesheet" href="./css/BotonesTablas.css">
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/add.css' rel='stylesheet'>
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/trash.css' rel='stylesheet'>
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/pen.css' rel='stylesheet'>
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <div class="botonL">
            <a href="adminCategorias.jsp" ><img src="img/atras.png" alt=""/> Atras</a>

        </div><br>



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
                            <div class="icon-buttons-container">
                                <form action="#" method="post" id="miFormulario" class="icon-form">
                                    <button type="submit" name="id" value="${usuario.id}" class="icon-button">
                                        <i class="gg-trash"></i>
                                    </button>
                                </form>
                                <form action="FormularioAgregar" method="post" class="icon-form">
                                    <button type="submit" name="agregar" class="icon-button">
                                        <i class="gg-add"></i>
                                    </button>
                                </form>
                                <form action="FormularioAgregar" method="post" class="icon-form">
                                    <button type="submit" name="agregar" class="icon-button">
                                        <i class="gg-pen"></i>
                                    </button>
                                </form>
                            </div>
                    </tr>

                </tbody>
            </table>
        </div>


    </body>
</html>
