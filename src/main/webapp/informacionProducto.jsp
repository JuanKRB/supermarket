

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/header3.css">
        <link rel="stylesheet" href="./css/productoInformacion6.css">
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



        <div class="productoInfo">

            <div class="imagen">
                <img src="./img-productos/jugoNaranjaDosPinos.png" alt="alt" class="img-producto"/>
            </div>

            <div class="informacion-disponibilidad-boton">

                <h3 class="codigoProducto">#F54774GH</h3>

                <div class="informacion-disponibilidad">

                    <div class="disponibilidad">
                        <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                        <h4 >Disponible</h4>
                    </div>

                    <div class="informacion">

                        <h4 class="precio">₡1300</h4>
                        <p class="nombre">Jugo Naranja 1.8L</p>
                    </div>

                </div>

                <div class="boton">

                    <form action="action">           
                        <button type="submit" class="boton-agregar">+ Agregar</button>
                    </form><br><br><br>

                </div>

            </div>

        </div>





    </body>
</html>
