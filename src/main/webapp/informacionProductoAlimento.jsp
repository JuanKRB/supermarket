

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Alimento"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/header7.css">
        <link rel="stylesheet" href="./css/productoInformacion8.css">
        <link rel="stylesheet" href="./css/categoria.css">
        <link rel="stylesheet" href="./css/productos-header.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %> 
        
        <% 

           Alimento alimento = (Alimento) request.getAttribute("alimento"); 

        %>

        <div class="productoInfo">

            <div class="imagen">
                <img src="<%=alimento.getImagen()%>" alt="alt" class="img-producto"/>
            </div>

            <div class="informacion-disponibilidad-boton">

                <h3 class="codigoProducto">#<%=alimento.getId()%></h3>

                <div class="informacion-disponibilidad">

                    <div class="disponibilidad">
                        <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                        <h4 >Disponible</h4>
                    </div>

                    <div class="informacion">

                        <h4 class="precio">₡<%=alimento.getPrecio()%></h4>
                        <p class="nombre"><%=alimento.getNombre()%></p>
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
