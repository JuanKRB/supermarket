
<%@page import="java.util.List"%>
<%@page import="modelo.Alimento"%>
<%@page import="modelo.Electronico"%>
<%@page import="modelo.Bebida"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/buscar7.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./css/producto10.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %>

        <div class="div-buscar3">
            <form action="ProductoController?accion=buscar" method="POST">   
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

            <a href="MostrarController?accion=mostrarAlimento&id=<%=alimIT.getId()%>">
                <img src="<%=alimIT.getImagen()%>" alt="<%=alimIT.getImagen()%>" class="img-producto"/>
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

            %>

       <% 
         

         List<Electronico> listaElectronicos = (List<Electronico>) request.getAttribute("listaElectronicos");

         for (Electronico electmIT : listaElectronicos) {  
           String nombreProducto = electmIT.getNombre().toLowerCase();  
           String primeraLetraNombreProducto = nombreProducto.substring(0, 1);

        if (nombreProducto.contains(nombre) || primeraLetraNombreProducto.equals(nombre)) {
        noProducto = false;

        %>



        <div class="productoDiv">

            <a href="MostrarController?accion=mostrarElectronico&id=<%=electmIT.getId()%>">
                <img src="<%=electmIT.getImagen()%>" alt="<%=electmIT.getImagen()%>" class="img-producto"/>
                <div class="disponibilidad">
                    <%
                      String disponiblidad = electmIT.getDisponibilidad();
                      
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

                    <h4 class="precio">₡<%= electmIT.getPrecio() %></h4>
                    <p class="nombre"><%= electmIT.getNombre() %></p>
                </div>
            </a>

            <form action="carritoServlet" method="POST">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>

        </div>

        <%
            } 
             } 

            %>

            
            <% 
         

         List<Bebida> listaBebidas = (List<Bebida>) request.getAttribute("listaBebidas");

         for (Bebida bebidaIT : listaBebidas) {  
           String nombreProducto = bebidaIT.getNombre().toLowerCase();  
           String primeraLetraNombreProducto = nombreProducto.substring(0, 1);

        if (nombreProducto.contains(nombre) || primeraLetraNombreProducto.equals(nombre)) {
        noProducto = false;

        %>



        <div class="productoDiv">

            <a href="MostrarController?accion=mostrarBebida&id=<%=bebidaIT.getId()%>">
                <img src="<%=bebidaIT.getImagen()%>" alt="<%=bebidaIT.getImagen()%>" class="img-producto"/>
                <div class="disponibilidad">
                    <%
                      String disponiblidad = bebidaIT.getDisponibilidad();
                      
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

                    <h4 class="precio">₡<%= bebidaIT.getPrecio() %></h4>
                    <p class="nombre"><%= bebidaIT.getNombre() %></p>
                </div>
            </a>

            <form action="carritoServlet" method="POST">           
                <button type="submit" class="boton-agregar">+ Agregar</button>
            </form>

        </div>

        <%
            } 
             } 

            %>


        <%
         if (noProducto) {
        %>
        <div class="noEncontroDiv">
            <img src="img/caraTriste.png" alt=""/>
            <h4>Lo sentimos, no tenemos ese producto</h4>
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
