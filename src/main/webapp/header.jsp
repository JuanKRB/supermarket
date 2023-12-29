
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/header7.css">    
        <link rel="stylesheet" href="./css/categoria.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    <body>
         <header>
            <main class="nav">
                <div class="nav__container">
                    <a href="#menu" class="nav__menu">
                        <img src="./icons/3rayas.png" alt="Menú"
                             class="nav__icon1">
                    </a>

                    <a href="#" class="nav__menu nav__menu--second">
                        <img src="./icons/marca-x.png" alt="Cerrar Menú"
                             class="nav__icon">
                    </a>

                    <ul class="dropdown" id="menu">
                        <li class="dropdown__list">
                            <a href="Inicio.jsp" class="dropdown__link">
                                <img src="./icons/3844470-home-house_110332.png" alt="Inicio" class="nav__icon">
                                <span class="dropdown__span">Inicio</span>
                            </a>
                        </li>

                        <li class="dropdown__list">
                            <a href="#" class="dropdown__link">
                                <img src="./icons/comida-dietetica.png" alt="Alimentos" class="nav__icon">
                                <span class="dropdown__span">Categorias</span>
                                <img src="./icons/flecha-hacia-abajo (5).png" alt="Desplegar" class="dropdown__arrow">
                                <input type="checkbox" class="dropdown__check">
                            </a>

                            <div class="dropdown__content">
                                <ul class="dropdown__sub">
                                    <li class="dropdown__li">
                                        <a href="AlimentoController?accion=categoriaAlimento" class="dropdown__anchor">Alimentos</a>
                                    </li>
                                    <li class="dropdown__li">
                                        <a href="ProductoController?accion=irCarnes" class="dropdown__anchor">Carnes</a>
                                    </li>
                                    <li class="dropdown__li">
                                        <a href="ProductoController?accion=categoriaFrutas" class="dropdown__anchor">Frutas</a>
                                    </li>
                                    <li class="dropdown__li">
                                        <a href="ProductoController?accion=categoriaElectronicos" class="dropdown__anchor">Electronicos</a>
                                    </li>
                                    <li class="dropdown__li">
                                        <a href="ProductoController?accion=categoriaGalletas" class="dropdown__anchor">Galletas</a>
                                    </li>
                                    <li class="dropdown__li">
                                        <a href="ProductoController?accion=categoriaBebidas" class="dropdown__anchor">bebidas</a>
                                    </li>
                                </ul>
                            </div>
                        </li>


                    </ul>
                </div>
            </main>
            <!--<a href="Inicio.jsp" class="logo"><img src="./img/logo.png" alt="alt" class="imagenLogo"/></a>-->

            <nav>
                <div class="a-nav">
                    <a href="Inicio.jsp" class="inicio">Inicio</a>
                    <a href="ProductoController">Productos</a>
                    <a href="RegistroController?accion=verificarSesionApagina" class="inicisesion">Iniciar Sesion</a>       
                </div>

            </nav>

            <div class="carrito">
                <a href="carrito.jsp" class="imagenCarritoA"><img src="./img/carrito.png" alt="alt" class="imagenCarrito"/></a>
            </div>

            <div class="lupa">
                <a href="ProductoController?accion=mostraBuscarPagina" class="lupaA"><img src="./img/lupa.png" alt="alt" class=""/></a>
            </div>

            <div class="lupa">
                <a href="RegistroController?accion=verificarSesionApagina" class="lupaA"><img src="./img/perfil.png" alt="alt" class=""/></a>
            </div>

        </header>
    </body>
</html>
