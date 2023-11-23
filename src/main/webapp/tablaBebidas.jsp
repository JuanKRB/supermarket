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
                            <button form="miFormulario" type="submit" name="id" value="${usuario.id}">
                                Eliminar
                            </button>
                    </tr>

                </tbody>
            </table>
        </div>






    </body>
</html>
