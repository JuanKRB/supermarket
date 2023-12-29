
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Bebida" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/TablaAlimentos4.css">
        <link rel="stylesheet" href="./css/botonAtras.css">
        <link rel="stylesheet" href="./css/BotonesTablas.css">
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/add.css' rel='stylesheet'>
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/trash.css' rel='stylesheet'>
        <link href='https://unpkg.com/css.gg@2.0.0/icons/css/pen.css' rel='stylesheet'>
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>

    <body>
        <style>
            table {
                color: #333;
                font-size: 12px;
                table-layout: fixed;
                border-collapse: collapse;
                width: 40%;
                margin: 20px 0;
                margin-left: 30%;
            }
        </style>
        
        
        <div class="botonL">
            <a href="adminCategorias.jsp" ><img src="img/atras.png" alt=""/> Atras</a>

        </div><br><br>
        
        <a href="agregarBebida.jsp">
            <div id="botonAgregar">
                <i class="gg-add"></i><h5>Agregar</h5>
            </div>
        </a><br>
        
        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Imagen</th>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Id marca</th>
                        <th>Disponibilidad</th>
                        <th>Id categoria</th>
                        <th>Id subcategoria</th>
                        <th>Ingredients</th>
                        <th>Cantidad Liquido</th>
                        <th>Acciónes</th>
                    </tr>
                </thead>
                
                <% 

                     List<Bebida> listaBebidas = (List<Bebida>) request.getAttribute("lista"); 
            
                     for( Bebida bebIT : listaBebidas) {
           

                %>
                
                <tbody>
                    <tr>
                        <td><%= bebIT.getId() %></td>
                        <td><img src="<%=bebIT.getImagen()%>" alt="<%=bebIT.getImagen()%>" id="img-producto"/></td>
                        <td><%= bebIT.getNombre() %></td>
                        <td><%= bebIT.getDescripcion() %></td>
                        <td><%= bebIT.getPrecio() %></td>
                        <td><%= bebIT.getCantidad() %></td>
                        <td><%= bebIT.getId_marca() %></td>
                        <td><%= bebIT.getDisponibilidad() %></td>
                        <td><%= bebIT.getId_categoria() %></td>
                        <td><%= bebIT.getId_subCategoria() %></td>
                        <td><%= bebIT.getIngredientes() %></td>
                        <td><%= bebIT.getCantidaLiquido() %></td>
                        <td>
                            <div class="icon-buttons-container">
                                <form action="BebidaController?accion=eliminar&id=<%= bebIT.getId() %>" method="post" id="miFormulario" class="icon-form">
                                    <button type="submit" name="id" value="${usuario.id}" class="icon-button">
                                        <i class="gg-trash"></i>
                                    </button>
                                </form>

                                <form action="BebidaController?accion=modificar&id=<%= bebIT.getId() %>" method="post" class="icon-form">
                                    <button type="submit" name="agregar" class="icon-button">
                                        <i class="gg-pen"></i>
                                    </button>
                                </form>
                            </div>
                    </tr>

                </tbody>
                <% } %>        
            </table>
        </div>






    </body>
</html>
