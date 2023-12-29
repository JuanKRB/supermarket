
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Bebida"%>
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
        
        <% 

           Bebida bebida = (Bebida) request.getAttribute("bebida"); 

        %>
        
        <form action="BebidaController?accion=actualizar&id=<%=bebida.getId()%>&imagen=<%=bebida.getImagen()%>" method="POST">

            <div class="enLInea">


                <div class="enLinea2">
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" value="<%=bebida.getNombre()%>">
                </div>

                <div class="enLinea2">

                    <label for="descripcion">Descripción:</label>
                    <input type="text" name="descripcion" id="grasas" value="<%= bebida.getDescripcion() %>">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">
                    <label for="precio">Precio:</label>
                    <input type="text" name="precio" id="precio" value="<%= bebida.getPrecio() %>">
                </div>

                <div class="enLinea2">
                    <label for="cantidad">Cantidad:</label>
                    <input type="text" name="cantidad" id="nombre" value="<%= bebida.getCantidad() %>">
                </div>

            </div>

            <div class="enLInea">


                <div class="enLinea2">

                    <label for="idmarca">Id marca</label>
                    <input type="text" name="idmarca" id="sucursal" value="<%= bebida.getId_marca() %>">
                </div>

                <div class="enLinea2">

                    <label for="disponibilidad">Disponibilidad</label>
                    <input type="text" name="disponibilidad" id="marca" value="<%= bebida.getDisponibilidad() %>">
                </div>



            </div>


            <div class="enLInea">

                <div class="enLinea2">
                    <label for="idcategoria">Id categoria</label>
                    <input type="text" name="idcategoria" id="tipo" value="<%= bebida.getId_categoria() %>">
                </div>

                <div class="enLinea2">

                    <label for="idSubcategoria">Id Sub categoria</label>
                    <input type="text" name="idSubcategoria" id="tipo" value="<%= bebida.getId_subCategoria() %>">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">

                    <label for="ingredientes">Ingredientes</label>
                    <input type="text" name="ingredientes" id="marca" value="<%= bebida.getIngredientes() %>">
                </div>

                <div class="enLinea2">

                    <label for="cantidaLiquido">cantidaLiquido</label>
                    <input type="text" name="cantidaLiquido" id="calorias" value="<%= bebida.getCantidaLiquido() %>">
                </div>

            </div>

            <input type="submit" value="Guardar" class="boton">
        </form>
    </body>
</html>

