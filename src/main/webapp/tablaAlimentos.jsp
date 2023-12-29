
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Alimento"%>
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Supermercado</title>
    </head>
    <body>

        <div class="botonL">
            <a href="adminCategorias.jsp" ><img src="img/atras.png" alt=""/> Atras</a>
        </div><br>


        <a href="agregarAlimento.jsp">
            <div id="botonAgregar">
                <i class="gg-add"></i><h5>Agregar</h5>
            </div>
        </a>


        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Imagen</th>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Marca</th>
                        <th>Disponibilidad</th>
                        <th>Categoria</th>
                        <th>Subcategoria</th>
                        <th>Ingredientes</th>
                        <th>Calorias</th>
                    </tr>
                </thead>

                <% 

                     List<Alimento> listaAlimentos = (List<Alimento>) request.getAttribute("lista"); 
            
                     for( Alimento alimIT : listaAlimentos) {
           

                %>
                <tbody>
                    <tr>

                        <td><%= alimIT.getId() %></td>
                        <td><img src="<%=alimIT.getImagen()%>" alt="<%=alimIT.getImagen()%>" id="img-producto"/></td>
                        <td><%= alimIT.getNombre() %></td>
                        <td><%= alimIT.getDescripcion() %></td>
                        <td><%= alimIT.getPrecio() %></td>
                        <td><%= alimIT.getCantidad() %></td>
                        <td><%= alimIT.getId_marca() %></td>
                        <td><%= alimIT.getDisponibilidad() %></td>
                        <td><%= alimIT.getId_categoria() %></td>
                        <td><%= alimIT.getId_subCategoria() %></td>
                        <td><%= alimIT.getIngredientes() %></td>
                        <td><%= alimIT.getCalorias() %></td>
                        <td>
                            <div class="icon-buttons-container">
                                <form action="AlimentoController?accion=eliminar&id=<%= alimIT.getId() %>" method="post" id="miFormulario" class="icon-form">
                                    <button type="submit" name="id" value="${usuario.id}" class="icon-button">
                                        <i class="gg-trash"></i>
                                    </button>
                                </form>

                                <form action="AlimentoController?accion=modificar&id=<%= alimIT.getId() %>" method="post" class="icon-form">
                                    <button type="submit" name="agregar" class="icon-button">
                                        <i class="gg-pen"></i>
                                    </button>
                                </form>
                            </div>
                    </tr>

                </tbody>
                <% } %>        
            </table>



            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </div>

        <br><br>

    </body>
</html>
