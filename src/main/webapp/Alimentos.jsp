

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="modelo.Alimento"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/productos8.css">
        <link rel="stylesheet" href="./css/categoria.css">
        <link rel="stylesheet" href="./css/productos-header.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %> 

        <% 

          List<Alimento> listaAlimentos = (List<Alimento>) request.getAttribute("lista"); 

           for( Alimento alimIT : listaAlimentos) {
            
              if(alimIT.getId_categoria() == 1) {

        %>

        <div class="productoDiv">

            <a href="informacionProducto.jsp">
                <img src="" alt="Imagen del producto" class="img-producto"/>
                <div class="disponibilidad">
                    <%
                      String disponiblidad = alimIT.getDisponibilidad();
                      
                      if(disponiblidad.equals("V")){
                    %>
                    <img src="./img-productos/chek.png" alt="alt" class="chek"/>
                    <h4>Disponible</h4>
                    <%
                   }else{
                    %>
                    <img src="./img-productos/Nochek.png" alt="alt" class="chek"/>
                    <h4>Disponible</h4>
                    <%           
                   }              
                    %>

                </div>

                <div class="informacion">

                    <h4 class="precio">₡<%= alimIT.getPrecio() %></h4>
                    <p class="nombre"><%= alimIT.getNombre() %></p>
                </div>
            </a>

            <form action="carritoServlet" method="POST">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>

        </div>
        <%           
           }              
        %>

        <% } %>        


        <div class="cambioPaginas">
            <a href=""><<</a>
            <a href="">1</a>
            <a href="">2</a>
            <a href="">3</a>
            <a href="">4</a>
            <a href="">>></a>
        </div>


    </body>
</html>
