
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Alimento"%>
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

           Alimento alimento = (Alimento) request.getAttribute("alimento"); 

        %>
        
        <form action="AlimentoController?accion=actualizar&id=<%=alimento.getId()%>&imagen=<%=alimento.getImagen()%>" method="POST">

            <div class="enLInea">


                <div class="enLinea2">
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" value="<%=alimento.getNombre()%>">
                </div>

                <div class="enLinea2">
                    <label for="nombre">Cantidad:</label>
                    <input type="text" name="cantidad" id="nombre" value="<%= alimento.getCantidad() %>">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">

                    <label for="descripcion">Descripción:</label>
                    <input type="text" name="descripcion" id="grasas" value="<%= alimento.getDescripcion() %>">
                </div>

                <div class="enLinea2">
                    <label for="precio">Precio:</label>
                    <input type="text" name="precio" id="precio" value="<%= alimento.getPrecio() %>">
                </div>

            </div>



            <div class="enLInea">


                <div class="enLinea2">

                    <label for="sucursal">Id marca</label>
                    <input type="text" name="idmarca" id="sucursal" value="<%= alimento.getId_marca() %>">
                </div>

                <div class="enLinea2">

                    <label for="marca">Ingredientes</label>
                    <input type="text" name="ingredientes" id="marca" value="<%= alimento.getIngredientes() %>">
                </div>

            </div>



            <div class="enLInea">

                <div class="enLinea2">

                    <label for="ingredientes">Disponibilidad</label>
                    <input type="text" name="disponibilidad" id="marca" value="<%= alimento.getDisponibilidad() %>">
                </div>

                <div class="enLinea2">

                    <label for="calorias">Calorías:</label>
                    <input type="text" name="calorias" id="calorias" value="<%= alimento.getCalorias() %>">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">
                    <label for="tipo">Id categoria</label>
                    <input type="text" name="idcategoria" id="tipo" value="<%= alimento.getId_categoria() %>">
                </div>

                <div class="enLinea2">

                    <label for="tipo">Id Sub categoria</label>
                    <input type="text" name="idSubcategoria" id="tipo" value="<%= alimento.getId_subCategoria() %>">
                </div>

            </div>

            <input type="submit" value="Guardar" class="boton">
        </form>
    </body>
</html>
