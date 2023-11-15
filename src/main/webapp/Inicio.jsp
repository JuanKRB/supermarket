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
        <link rel="stylesheet" href="./css/Inicio.css">
        <title>JSP Page</title>
    </head>
    <body>
   <header>
        <h1>Mi Tienda en Línea</h1>
    </header>

    <form action="" method="get">
        <label for="busqueda">Buscar:</label>
        <input type="text" id="busqueda" name="q" placeholder="Escribe tu búsqueda aquí" required>
        <button type="submit">Buscar</button>

        <div class="enlaces-sesion">
            <a href="#" class="sesion">Iniciar Sesión</a>
            <a href="#" class="sesion">Registrarse</a>
        </div>

        <img id="cart-icon" width="35px" height="35px" class="icono" src="https://us.123rf.com/450wm/vectoraa/vectoraa1609/vectoraa160900985/62392824-icono-de-carrito-de-compras-icono-de-vector-de-mejor-dise%C3%B1o-plano.jpg">
    </form>

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
