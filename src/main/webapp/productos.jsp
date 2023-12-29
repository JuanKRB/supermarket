

<%@page import="java.util.List"%>
<%@page import="modelo.Alimento"%>
<%@page import="modelo.Bebida"%>
<%@page import="modelo.Electronico"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="./css/header5.css">    
        <link rel="stylesheet" href="./css/producto10.css">
        <link rel="stylesheet" href="./css/categoria.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%@ include file="header.jsp" %> 

        <% 

            List<Alimento> listaAlimentos = (List<Alimento>) request.getAttribute("listaAlimentos"); 
            
            for( Alimento aliIT : listaAlimentos) {
           

        %>

        <div class="productoDiv">

            <a href="MostrarController?accion=mostrarAlimento&id=<%=aliIT.getId()%>">
                <img src="<%=aliIT.getImagen()%>" alt="<%=aliIT.getImagen()%>" class="img-producto"/>
                <div class="disponibilidad">
                    <%
                      String disponiblidad = aliIT.getDisponibilidad();
                      
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

                    <h4 class="precio">₡<%= aliIT.getPrecio() %></h4>
                    <p class="nombre"><%= aliIT.getNombre() %></p>
                </div>
            </a>
                
                
              <%
                       disponiblidad = aliIT.getDisponibilidad();
                      
                      if(disponiblidad.equals("V")){
             %>
            <form action="CarritoController?accion=agregarAcarritoAlimento&id=<%= aliIT.getId() %>" method="POST">          
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

        <% 

            List<Electronico> listaElectronicos = (List<Electronico>) request.getAttribute("listaElectronicos"); 
            
            for( Electronico elecIT : listaElectronicos) {
           

        %>

        <div class="productoDiv">

            <a href="MostrarController?accion=mostrarElectronico&id=<%=elecIT.getId()%>">
                <img src="<%=elecIT.getImagen()%>" alt="<%=elecIT.getImagen()%>" class="img-producto"/>
                <div class="disponibilidad">
                    <%
                      String disponiblidad = elecIT.getDisponibilidad();
                      
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

                    <h4 class="precio">₡<%= elecIT.getPrecio() %></h4>
                    <p class="nombre"><%= elecIT.getNombre() %></p>
                </div>
            </a>
                
                <%
                       disponiblidad = elecIT.getDisponibilidad();
                      
                      if(disponiblidad.equals("V")){
             %>

            <form action="CarritoController?accion=agregarAcarritoElectronico&id=<%= elecIT.getId() %>" method="POST">           
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
            <a href="" disabled><<</a>
            <a href="productos.jsp" class="active">1</a>
            <a href="productos2.jsp">2</a>
            <a href="productos_3.jsp">3</a>
            <a href="productos_4.jsp">4</a>
            <a href="productos_5.jsp">5</a>
            <a href="productos_6.jsp">6</a>
            <a href="" disabled>|    >></a>
        </div>


    </body>
</html>
