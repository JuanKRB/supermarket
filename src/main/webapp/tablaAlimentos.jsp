<%-- 
    Document   : tablaAlimentos
    Created on : 23 nov. 2023, 10:35:27
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


        <%  
            Boolean mostrarFormulario = (Boolean)session.getAttribute("mostrarFormulario");


            if (mostrarFormulario != null && mostrarFormulario) {
        %>
        <!-- Tu formulario aquí -->
        <form action="FormularioAgregar" method="post">
            <label for="id">ID:</label>
            <input type="text" name="id" id="id">
            <br>

            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre">
            <br>

            <label for="descripcion">Descripción:</label>
            <textarea name="descripcion" id="descripcion"></textarea>
            <br>

            <label for="precio">Precio:</label>
            <input type="text" name="precio" id="precio">
            <br>

            <label for="cantidad">Cantidad:</label>
            <input type="text" name="cantidad" id="cantidad">
            <br>

            <label for="fechaRecibido">Fecha Recibido:</label>
            <input type="text" name="fechaRecibido" id="fechaRecibido">
            <br>

            <label for="sucursal">Sucursal:</label>
            <input type="text" name="sucursal" id="sucursal">
            <br>

            <label for="proveedor">Proveedor:</label>
            <input type="text" name="proveedor" id="proveedor">
            <br>

            <label for="marca">Marca:</label>
            <input type="text" name="marca" id="marca">
            <br>

            <label for="ingredientes">Ingredientes:</label>
            <textarea name="ingredientes" id="ingredientes"></textarea>
            <br>

            <label for="calorias">Calorías:</label>
            <input type="text" name="calorias" id="calorias">
            <br>

            <label for="proteinas">Proteínas:</label>
            <input type="text" name="proteinas" id="proteinas">
            <br>

            <label for="grasas">Grasas:</label>
            <input type="text" name="grasas" id="grasas">
            <br>

            <label for="cad">CAD:</label>
            <input type="text" name="cad" id="cad">
            <br>

            <label for="tipo">Tipo:</label>
            <input type="text" name="tipo" id="tipo">
            <br>
            <input type="submit" value="Guardar">
        </form>
        <% 
            } else {
        %>
        <!-- Tu lógica de tabla o cualquier otra cosa que desees mostrar cuando no se muestra el formulario -->
        <!-- Por ejemplo, aquí podría ir tu tabla -->

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
                        <th>Tipo</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Producto A</td>
                        <td>Descripción del Producto A</td>
                        <td>19.99</td>
                        <td>50</td>
                        <td>2023-11-23</td>
                        <td>Sucursal 1</td>
                        <td>Proveedor X</td>
                        <td>Marca Y</td>
                        <td>Ingredientes A, B, C</td>
                        <td>300</td>
                        <td>20</td>
                        <td>10</td>
                        <td>2023-12-31</td>
                        <td>Alimento Tipo 1</td>
                        <td>
                            <button form="miFormulario" type="submit" name="id" value="${usuario.id}">
                                Eliminar
                            </button>
                    </tr>

                </tbody>
            </table>
        </div>



        <%
            }
        %>









    </body>
</html>
