
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Electronico"%>
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

           Electronico electronico = (Electronico) request.getAttribute("electronico"); 

        %>
        
        <form action="ElectronicoController?accion=actualizar&id=<%=electronico.getId()%>&imagen=<%=electronico.getImagen()%>" method="POST">

            <div class="enLInea">


                <div class="enLinea2">
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre" value="<%=electronico.getNombre()%>">
                </div>

                <div class="enLinea2">

                    <label for="descripcion">Descripción:</label>
                    <input type="text" name="descripcion" id="grasas" value="<%= electronico.getDescripcion() %>">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">
                    <label for="precio">Precio:</label>
                    <input type="text" name="precio" id="precio" value="<%= electronico.getPrecio() %>">
                </div>

                <div class="enLinea2">
                    <label for="cantidad">Cantidad:</label>
                    <input type="text" name="cantidad" id="nombre" value="<%= electronico.getCantidad() %>">
                </div>

            </div>

            <div class="enLInea">


                <div class="enLinea2">

                    <label for="idmarca">Id marca</label>
                    <input type="text" name="idmarca" id="sucursal" value="<%= electronico.getId_marca() %>">
                </div>

                <div class="enLinea2">

                    <label for="disponibilidad">Disponibilidad</label>
                    <input type="text" name="disponibilidad" id="marca" value="<%= electronico.getDisponibilidad() %>">
                </div>



            </div>


            <div class="enLInea">

                <div class="enLinea2">
                    <label for="idcategoria">Id categoria</label>
                    <input type="text" name="idcategoria" id="tipo" value="<%= electronico.getId_categoria() %>">
                </div>

                <div class="enLinea2">

                    <label for="idSubcategoria">Id Sub categoria</label>
                    <input type="text" name="idSubcategoria" id="tipo" value="<%= electronico.getId_subCategoria() %>">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">

                    <label for="cantidaLiquido">Especificaciones</label>
                    <input type="text" name="especificaciones" id="calorias" value="<%= electronico.getEspecificaciones() %>">
                </div>

            </div>

            <input type="submit" value="Guardar" class="boton">
        </form>
    </body>
</html>

