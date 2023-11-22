

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/header5.css">    
           <link rel="stylesheet" href="./css/producto9.css">
        <link rel="stylesheet" href="./css/categoria.css">
        <link rel="stylesheet" href="./css/productos-header.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
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
                            <a href="Inicio.jsp" class="dropdown__link">
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



        <div class="productoDiv">

            <a href="informacionProducto.jsp">
                <img src="./img-productos/redbull.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡1300</h4>
                    <p class="nombre">Jugo Naranja 1.8L</p>
                </div>
            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>



        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">
                <img src="./img-productos/rodillo quitapelusa.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>   

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">
                <img src="./img-productos/adan y eva.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>  

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/japon de barra.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/nintendo.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/fresca.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/Nochek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/ps5.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>
        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/mayonesa.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/guayabitas.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/Nochek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/escoba.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>


        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/aloe.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>


        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/palita.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/polvo gatorade.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/alfombrilla.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/microfono.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/audifonos.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/sandia.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/Nochek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">

                <img src="./img-productos/cas.webp" alt="alt" class="img-producto"/>
                <div class="disponibilidad">
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4 >Disponible</h4>
                </div>

                <div class="informacion">

                    <h4 class="precio">₡570</h4>
                    <p class="nombre">CocaCola Zero  355Ml</p>
                </div>

            </a>

            <form action="action">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>


        </div>

        <div class="cambioPaginas">
            <a href=""><<</a>
            <a href="productos.jsp">1</a>
            <a href="productos2.jsp">2</a>
            <a href="productos_3.jsp">3</a>
            <a href="productos_4.jsp">4</a>
            <a href="productos_5.jsp">5</a>
             <a href="productos_6.jsp">6</a>
           
            <a href="">>></a>
        </div>


    </body>
</html>
