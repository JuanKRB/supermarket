
<%@page import="java.util.List"%>
<%@page import="modelo.Alimento"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/buscar6.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./css/producto10.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %>

        <div class="div-buscar3">
            <form action="AlimentoController?accion=buscar" method="POST">   
                <input type="text" name="nombre" placeholder="     Buscar" id="input-div-buscar3" required>
                <button type="submit" id="boton-div-buscar3"><img src="img/lupa.png" alt=""/></button>
            </form>
        </div>

        <% 
         String nombre = request.getParameter("nombre").toLowerCase(); 
         
         boolean noProducto = true;

         List<Alimento> listaAlimentos = (List<Alimento>) request.getAttribute("lista");

         for (Alimento alimIT : listaAlimentos) {  
           String nombreProducto = alimIT.getNombre().toLowerCase();  
           String primeraLetraNombreProducto = nombreProducto.substring(0, 1);

        if (nombreProducto.contains(nombre) || primeraLetraNombreProducto.equals(nombre)) {
        noProducto = false;

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
             } 

         if (noProducto) {
        %>
        <div class="noEncontroDiv">
            <img src="img/caraTriste.png" alt=""/>
            <h4>Lo sentimos no hay productos de los que busco</h4>
        </div>
        <%

         }
        %> 



        <div class="cambioPaginas">
            <a href="" disabled><<</a>
            <a href="productos.jsp" class="active">1</a>
            <a href="productos2.jsp">2</a>
            <a href="productos_3.jsp">3</a>
            <a href="productos_4.jsp">4</a>
            <a href="productos_5.jsp">5</a>
            <a href="productos_6.jsp">6</a>
            <a href="" disabled>>></a>
        </div>


    </body>
</html>
