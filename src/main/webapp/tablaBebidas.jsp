<%-- 
    Document   : tablaBebidas
    Created on : 23 nov. 2023, 16:17:54
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
        <title>JSP Page</title>
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
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>FechaRecibido</th>
                        <th>Sucursal</th>
                        <th>Proveedor</th>
                        <th>Marca</th>
                        <th>Ingredientes</th>
                        <th>Calorias</th>
                        <th>Proteinas</th>
                        <th>Grasas</th>
                        <th>CAD</th>
                        <th>TipoBebida</th>
                        <th>cantidadLiquido</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Producto A</td>
                        <td>Descripción del Producto A</td>
                        <td>20.99</td>
                        <td>50</td>
                        <td>2023-11-23</td>
                        <td>Sucursal 1</td>
                        <td>Proveedor X</td>
                        <td>Marca Y</td>
                        <td>Ingredientes A, B, C</td>
                        <td>300</td>
                        <td>20</td>
                        <td>10</td>
                        <td>2025-12-31</td>
                        <td>Natural</td>
                        <td>600ml</td>
                        <td>
                            <div class="icon-buttons-container">
                                <form action="miFormulario" method="post" id="miFormulario" class="icon-form">
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
