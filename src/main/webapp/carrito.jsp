

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/carrito.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %>

        <div class="principal">

            <div class="informacion">

                <h4 id="producto">Producto</h4>
                <h4>Precio</h4>
                <h4>Cantidad</h4>
                <h4 id="subTotal">Subtotal</h4>
            </div>
            <hr>
            <div class="todo-producto">
                <div class="div-xRoja">
                    <a href="#">
                        <img src="img/xRoja.png" alt="" class="xRoja"/>
                    </a>
                </div>
                <div class="div-producto">
                    <a href="informacionProducto.jsp">
                        <img src="img-productos/jugoNaranjaDosPinos.png" alt="" class="producto"/>
                    </a>
                </div>    
                <p id="nombreProducto">Jugo de Naranja</p>
                <p id="precio">₡1300</p>
                <form action="action">
                    <input type="text" name="name" placeholder="  1" id="cantidad">
                </form>
                <p id="subTotalPrecio">₡1300</p>
            </div>
            <hr>
            <div class="todo-producto">
                <div class="div-xRoja">
                    <a href="#">
                            <img src="img/xRoja.png" alt="" class="xRoja"/>
                    </a>
                </div>
                <div class="div-producto">
                    <a href="informacionProducto.jsp">
                        <img src="img-productos/pepsiEnLata.png" alt="" class="producto"/>
                    </a>
                </div>    
                <p id="nombreProducto">Pepsi</p>
                <p id="precio2">₡570</p>
                <form action="action">
                    <input type="text" name="name" placeholder="  2" id="cantidad">
                </form>
                <p id="subTotalPrecio">₡1140</p>
            </div>
            <hr>
            <div class="todo-producto">
                <div class="div-xRoja">
                    <a href="#">
                        <img src="img/xRoja.png" alt="" class="xRoja"/>   
                    </a>
                </div>
                <div class="div-producto">
                    <a href="informacionProducto.jsp">
                        <img src="img-productos/cocaCola-500ml.png" alt="" class="producto"/>
                    </a>
                </div>    
                <p id="nombreProducto">Coca Cola</p>
                <p id="precio3">₡570</p>
                <form action="action">
                    <input type="text" name="name" placeholder="  2" id="cantidad">
                </form>
                <p id="subTotalPrecio">₡1140</p>
            </div>
            <hr>
            <div class="div-final">
                <form action="action" class="cupon">
                    <input type="text" name="name" placeholder=" cupon" >
                    <button type="button">Aplicar cupon</button>
                </form>
            </div>
        </div>

        <div class="totales-boton">
            <div class="totales-principal">


                <div class="totales">
                    <div class="subTotal-DIV">
                        <h4 id="7">Subtotal</h4>

                        <p>₡3580</p>
                    </div>
                    <hr>
                    <div class="subTotal-DIV">
                        <h4>Descuento</h4>
                        <p id="descuento">₡100</p>
                    </div>
                    <hr>
                    <div class="subTotal-DIV">
                        <h4>Impuestos</h4>
                        <p id="descuento">₡200</p>
                    </div>
                    <hr>
                    <div class="subTotal-DIV">
                        <h4>Total</h4>
                        <p id="total2">₡3680</p>
                    </div>
                </div>

            </div>

            <a href="carrito.jsp">
                <div class="boton">

                    <form action="carrito.jsp" class="cupon">
                        <button type="button">Comprar</button>
                    </form>

                </div>
                <a/>
        </div>

    </body>
</html>
