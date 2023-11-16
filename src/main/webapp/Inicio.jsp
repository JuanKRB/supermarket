<%-- 
    Document   : Inicio
    Created on : 15 nov. 2023, 13:21:15
    Author     : Carlos Oviedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/Inicio2.css">
        <title>JSP Pageeee</title>
    </head>
    <body>
        <header>

            <a href="Inicio.jsp" class="logo"><img src="./css/logo.png" alt="alt" class="imagenLogo"/></a>

            <div class="carrito">
                <a href="Inicio.jsp" class="imagenCarritoA"><img src="./css/carrito.png" alt="alt" class="imagenCarrito"/></a>
            </div>
         
            <nav>

               
                <a href="Inicio.jsp">Inicio</a>
                <a href="tienda.jsp">Tienda</a>
                <a href="IniciarSesion.jsp">Iniciar sesion</a>     
            </nav>

        </header>
        
        <div class="Carnes">
            <img src="./css/Alimentos3.png" alt="alt" class="alimentos"/>
        </div>





        <h1>Categorías</h1>

        <select id="categorias" onchange="mostrarSeleccion()">
            <option value="" selected disabled>Selecciona una categoría</option>
            <option value="alimentos">Alimentos</option>
            <option value="bebidas">Bebidas</option>
        </select>

        <div class="imagen-con-descripcion">
            <img src="ruta-de-la-imagen1.jpg" alt="img">
            <p>Descripción detallada de la Imagen 1.</p>
        </div>

        <div class="imagen-con-descripcion">
            <img src="ruta-de-la-imagen2.jpg" alt="img">
            <p>Descripción detallada de la Imagen 2.</p>
        </div>

        <div class="imagen-con-descripcion">
            <img src="ruta-de-la-imagen3.jpg" alt="img">
            <p>Descripción detallada de la Imagen 3.</p>
        </div>



    </body>
</html>
