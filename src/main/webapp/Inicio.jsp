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
        <link rel="stylesheet" href="./css/header5.css">
        <link rel="stylesheet" href="./css/inicio6.css">   
        <link rel="stylesheet" href="./css/inicio-header4.css">
        <link rel="stylesheet" href="./css/categoria.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercadohola4</title>
    </head>
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
                            <a href="#" class="dropdown__link">
                                <img src="./icons/3844470-home-house_110332.png" alt="Inicio" class="nav__icon">
                                <span class="dropdown__span">Inicio</span>
                            </a>
                        </li>

                        <li class="dropdown__list">
                            <a href="#" class="dropdown__link">
                                <img src="./icons/comida-dietetica.png" alt="Alimentos" class="nav__icon">
                                <span class="dropdown__span">Alimentos</span>
                                <img src="./icons/flecha-hacia-abajo (5).png" alt="Desplegar" class="dropdown__arrow">
                                <input type="checkbox" class="dropdown__check">
                            </a>

                            <div class="dropdown__content">
                                <ul class="dropdown__sub">
                                    <li class="dropdown__li">
                                        <a href="#" class="dropdown__anchor">Proyecto 1</a>
                                    </li>
                                    <li class="dropdown__li">
                                        <a href="#" class="dropdown__anchor">Proyecto 2</a>
                                    </li>
                                    <li class="dropdown__li">
                                        <a href="#" class="dropdown__anchor">Proyecto 3</a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <li class="dropdown__list">
                            <a href="#" class="dropdown__link">
                                <img src="./icons/electrodomestico.png" alt="Electrodomesticos" class="nav__icon">
                                <span class="dropdown__span">Electrodomesticos</span>
                                <img src="./icons/flecha-hacia-abajo (5).png" alt="Desplegar" class="dropdown__arrow">
                                <input type="checkbox" class="dropdown__check">
                            </a>

                            <div class="dropdown__content">
                                <ul class="dropdown__sub">
                                    <li class="dropdown__li">
                                        <a href="#" class="dropdown__anchor">Contacto 1</a>
                                        <a href="#" class="dropdown__anchor">Contacto 1</a>
                                    </li>
                                    <li class="dropdown__li">
                                        <a href="#" class="dropdown__anchor">Contacto 2</a>
                                    </li>
                                </ul>
                            </div>
                        </li>

                        <li class="dropdown__list">
                            <a href="#" class="dropdown__link">
                                <img src="./icons/boton-web-de-ayuda.png" alt="Ayuda" class="nav__icon">
                                <span class="dropdown__span">Ayuda</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </main>
            <!--<a href="Inicio.jsp" class="logo"><img src="./img/logo.png" alt="alt" class="imagenLogo"/></a>-->

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

        <div class="principal">
            <img src="img/principal.jpg" alt=""/>
        </div>

        <div class="categorias-principal">

            <div class="categorias-1">
                <a href="url">
                    <div class="categoria2">
                        <img src="img-categorias/alimentos.svg" alt="Descripción del SVG">
                        <hr>
                        <h2 id="alimentos">Alimentos</h2>
                    </div>
                </a>
                <a href="url">
                    <div class="categoria2">
                        <img src="img-categorias/carnes.svg" alt="Descripción del SVG">
                        <hr>
                        <h2 id="carnes">Carnes</h2>
                    </div>
                </a>
                <a href="url">
                <div class="categoria2">
                    <img src="img-categorias/frutas.svg" alt="Descripción del SVG">
                    <hr>
                    <h2 id="frutas">Frutas</h2>
                </div>
                </a>    
                <a href="url">
                <div class="categoria2">
                    <img src="img-categorias/electronica.svg" alt="Descripción del SVG">
                    <hr>
                    <h2 id="electro-h2">Electrónica</h2>
                </div> 
                </a>    
                <a href="url">
                <div class="categoria2">
                    <img src="img-categorias/limpieza.svg" alt="Descripción del SVG">
                    <hr>
                    <h2>Limpieza</h2>
                </div>  
                </a>    
                <a href="url">
                <div class="categoria2">
                    <img src="img-categorias/panaderia.svg" alt="Descripción del SVG">
                    <hr>
                    <h2>Panaderia</h2>
                </div>
                </a>

            </div>

        </div>
        <!--
        <div class="categorias-2">
            
            <div class="categoria3">
                <img src="img-categorias/carnes.svg" alt="Descripción del SVG">
                <hr>
                <h2>Bebidas</h2>
            </div>
            <div class="categoria3">
                <img src="img-categorias/lacteo.svg" alt="Descripción del SVG">
                <hr>
                <h2>Lacteos</h2>
            </div>  
            <div class="categoria3">
                <img src="img-categorias/frutas.svg" alt="Descripción del SVG">
                <hr>
                <h2>Frutas</h2>
            </div>  
            <div class="categoria3">
                <img src="img-categorias/electronica.svg" alt="Descripción del SVG">
                <hr>
                <h2>Electrónica</h2>
            </div>  
            <div class="categoria3">
                <img src="img-categorias/limpieza.svg" alt="Descripción del SVG">
                <hr>
                <h2>Limpieza</h2>
            </div>  
            <div class="categoria3">
                <img src="img-categorias/panaderia.svg" alt="Descripción del SVG">
                <hr>
                <h2>Panaderia</h2>
            </div>
        -->
    </div>


</body>
</html>
