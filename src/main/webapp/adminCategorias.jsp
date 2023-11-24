<%-- 
    Document   : adminCategorias
    Created on : 23 nov. 2023, 09:09:45
    Author     : Carlos Oviedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/adminCategorias1.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Categorias</h1><br><br><br>
        <section class="container">
            <div class="card">
                <div class="image">
                    <img src="./icons/alimentos.svg" alt="" />
                </div>
                <h2>Alimentos</h2>
          <a href="tablaAlimentos.jsp">Ver articulos</a>
            </div>
            <div class="card">
                <div class="image">
                    <img src="./icons/bebidas.svg" alt="" />
                </div>
                <h2>Bebidas</h2>
                <a href="tablaBebidas.jsp">Ver articulos</a>
            </div>
            <div class="card">
                <div class="image">
                    <img src="./icons/electrodomesticos.svg" alt="" />
                </div>
                <h2>Electrodomesticos</h2>
                <a href="tablaElectrodomesticos.jsp">Ver articulos</a>
           
              
            </div>
        </section>
    </body>
</html>