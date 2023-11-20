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
        <link rel="stylesheet" href="./css/header3.css">
        <link rel="stylesheet" href="./css/inicio-header2.css">
        <link rel="stylesheet" href="./css/inicio4.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>
       <header>

            <a href="Inicio.jsp" class="logo"><img src="./img/logo.png" alt="alt" class="imagenLogo"/></a>

            <nav>
                <div class="a-nav">
                    <a href="Inicio.jsp" class="inicio">Inicio</a>
                    <a href="productos.jsp">Productos</a>
                    <a href="IniciarSesion.jsp" class="inicisesion">Iniciar Sesion</a>     
                </div>

            </nav>

            <div class="carrito">
                <a href="Inicio.jsp" class="imagenCarritoA"><img src="./img/carrito.png" alt="alt" class="imagenCarrito"/></a>
            </div>

            <div class="lupa">
                <a href="Inicio.jsp" class="lupaA"><img src="./img/lupa.png" alt="alt" class=""/></a>
            </div>
            
            <div class="lupa">
                <a href="IniciarSesion.jsp" class="lupaA"><img src="./img/perfil.png" alt="alt" class=""/></a>
            </div>

        </header>

        <div>

            <div class="Carnes">
                <a href="alimentos.jsp"><img src="./img/Alimentos4.png" alt="alt" class="alimentos"/></a>
            </div>

            <div class="Bebidas">
                <a href="bebidas.jsp"><img src="./img/bebidas.png" alt="alt" class="alimentos"/> </a>
            </div>

            <div class="Electrodomesticos">
                <a href="electrodomesticos.jsp"><img src="./img/electrodomesticos.png" alt="alt" class="alimentos"/> </a>
            </div>
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
