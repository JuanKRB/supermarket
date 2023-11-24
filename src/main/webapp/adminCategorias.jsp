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
        <link rel="stylesheet" href="./css/botonAtras.css">
        <link rel="stylesheet" href="./css/verArtirculoAdmin.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>
         <div class="botonL">
             <a href="admin.jsp" ><img src="img/atras.png" alt=""/> Atras</a>
             
         </div><br>
         
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