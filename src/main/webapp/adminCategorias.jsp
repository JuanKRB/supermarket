
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/adminCategorias1.css">
        <link rel="stylesheet" href="./css/botonAtras.css">
        <link rel="stylesheet" href="./css/verArtirculoAdmin.css">
        <link rel="stylesheet" href="./css/transicion.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>

        <%

         String verificarSesion = null;

         if (session.getAttribute("verificarSesion") != null ) {
            verificarSesion = (String) session.getAttribute("verificarSesion");
            
            if (verificarSesion.equals("AD")) {
        %>
        <div class="botonL">
            <a href="admin.jsp" ><img src="img/atras.png" alt=""/> Atras</a>
        </div><br>

        <%
        }else{
        %>
        <div class="botonL">
            <a href="superAdmin.jsp" ><img src="img/atras.png" alt=""/> Atras</a>
        </div><br>

        <%
        
        }
            
     }

        %>




        <h1>Categorias</h1><br><br><br>

        <section class="container">
            <div class="card">
                <div class="image">
                    <img src="./icons/alimentos.svg" alt="" />
                </div>
                <h2>Alimentos</h2>
                <a href="AlimentoController?accion=mostrarTablaAlimentos">Ver articulos</a>
            </div>
            <div class="card">
                <div class="image">
                    <img src="./icons/bebidas.svg" alt="" />
                </div>
                <h2>Bebidas</h2>
                <a href="BebidaController?accion=listarTablaBebidas">Ver articulos</a>
            </div>
            <div class="card">
                <div class="image">
                    <img src="./icons/electrodomesticos.svg" alt="" />
                </div>
                <h2>Electrodomesticos</h2>
                <a href="ElectronicoController?accion=listarTablaElectronico">Ver articulos</a>


            </div>
        </section>


    </body>
</html>