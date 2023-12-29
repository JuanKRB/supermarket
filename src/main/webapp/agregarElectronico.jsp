

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
        <form action="ElectronicoController?accion=guardar" method="POST">

            <div class="enLInea">


                <div class="enLinea2">
                    <label for="nombre">Nombre:</label>
                    <input type="text" name="nombre" id="nombre">
                </div>

                <div class="enLinea2">
                    <label for="nombre">Cantidad:</label>
                    <input type="text" name="cantidad" id="nombre">
                </div>

            </div>

            <div class="enLInea">

                <div class="enLinea2">

                    <label for="descripcion">Descripción:</label>
                    <input type="text" name="descripcion" id="grasas">
                </div>

                <div class="enLinea2">
                    <label for="precio">Precio:</label>
                    <input type="text" name="precio" id="precio" oninput="soloNumeros()">
                </div>

            </div>



            <div class="enLInea">


                <div class="enLinea2">

                    <label for="sucursal">Id marca</label>
                    <input type="text" name="idmarca" id="sucursal">
                </div>

                <div class="enLinea2">

                    <label for="marca">Especificaciones</label>
                    <input type="text" name="especificaciones" id="marca">
                </div>

            </div>



            <div class="enLInea">

                <div class="enLinea2">

                    <label for="ingredientes">Disponibilidad</label>
                    <input type="text" name="disponibilidad" id="marca">
                </div>
                
                <div class="enLinea2">
                    <label for="tipo">Id categoria</label>
                    <input type="text" name="idcategoria" id="tipo">
                </div>

            </div>



            

            <div class="enLInea">

                

                <div class="enLinea2">

                    <label for="tipo">Id Sub categoria</label>
                    <input type="text" name="idSubcategoria" id="tipo">
                </div>

            </div>

            <input type="submit" value="Guardar" class="boton">
        </form>
    </body>
</html>
