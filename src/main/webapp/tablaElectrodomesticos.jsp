

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Electronico" %>
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
        
        <a href="agregarElectronico.jsp">
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
                        <th>Especificaciones</th>
                        <th>Acciónes</th>
                    </tr>
                </thead>
                
                <% 

                     List<Electronico> listaElectronicos = (List<Electronico>) request.getAttribute("lista"); 
            
                     for( Electronico electIT : listaElectronicos) {
           

                %>
                
                <tbody>
                    <tr>
                        <td><%= electIT.getId() %></td>
                        <td><img src="<%=electIT.getImagen()%>" alt="<%=electIT.getImagen()%>" id="img-producto"/></td>
                        <td><%= electIT.getNombre() %></td>
                        <td><%= electIT.getDescripcion() %></td>
                        <td><%= electIT.getPrecio() %></td>
                        <td><%= electIT.getCantidad() %></td>
                        <td><%= electIT.getId_marca() %></td>
                        <td><%= electIT.getDisponibilidad() %></td>
                        <td><%= electIT.getId_categoria() %></td>
                        <td><%= electIT.getId_subCategoria() %></td>
                        <td><%= electIT.getEspecificaciones() %></td>
                        <td>
                            <div class="icon-buttons-container">
                                <form action="ElectronicoController?accion=eliminar&id=<%= electIT.getId() %>" method="post" id="miFormulario" class="icon-form">
                                    <button type="submit" name="id" value="${usuario.id}" class="icon-button">
                                        <i class="gg-trash"></i>
                                    </button>
                                </form>

                                <form action="ElectronicoController?accion=modificar&id=<%= electIT.getId() %>" method="post" class="icon-form">
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
