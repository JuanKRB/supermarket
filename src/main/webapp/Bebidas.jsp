

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="modelo.Bebida"%>
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

           List<Bebida> listaBebidas = (List<Bebida>) request.getAttribute("listaBebidas"); 
            
            for( Bebida bebiIT : listaBebidas) {
           

        %>

        <div class="productoDiv">

            <a href="MostrarController?accion=mostrarBebida&id=<%=bebiIT.getId()%>">
                <img src="<%=bebiIT.getImagen()%>" alt="<%=bebiIT.getImagen()%>" class="img-producto"/>
                <div class="disponibilidad">
                    <%
                      String disponiblidad = bebiIT.getDisponibilidad();
                      
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

                    <h4 class="precio">₡<%= bebiIT.getPrecio() %></h4>
                    <p class="nombre"><%= bebiIT.getNombre() %></p>
                </div>
            </a>
                
             <%
                       disponiblidad = bebiIT.getDisponibilidad();
                      
                      if(disponiblidad.equals("V")){
             %>

            <form action="CarritoController?accion=agregarAcarritoBebida&id=<%= bebiIT.getId() %>" method="POST">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>
                
             <%
                   }else{
              %>
              <form action="" method="POST">          
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>
                <%           
                   }              
                    %>

        </div>

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
