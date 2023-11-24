

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Supermercado</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/admin3.css">
        <link rel="stylesheet" href="./css/configuracionAdmin2.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>
        <div class="botonAtras">
            <a href="admin.jsp" ><img src="img/atras.png" alt=""/></a>
        </div><br>
        <main>

            <div class="informacion-usuario">

                <img src="img/perfil2.png" alt=""/>
                <h4>Admin1</h4>
              

            </div>

            <div id="a25">
                
     
     
            <div class="container mt-5">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home">Datos Administrador</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile">Actualizar Contraseña</a>
                    </li>
                </ul>

                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="col-7">


                            <div class="form-group row">
                                <label for="usuario" class="col-4">Usuario:</label>
                                <div class="col-8">
                                    <input type="text" class="form-control" value="marco antonio">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="email" class="col-4">Correo:</label>
                                <div class="col-8">
                                    <input type="email" class="form-control" value="marco@centroPInf.com">
                                </div>
                            </div>

                            <div class="form-group text-center">
                                <button class="btn btn-info">Actualizar</button>
                                <button class="btn btn-danger">Cancelar</button>
                            </div>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">


                        <div class="form-group row">
                            <label for="contrasenia" class="col-4">Contraseña:</label>
                            <div class="col-8">
                                <input type="password" class="form-control" style="width: 400px;">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="ncontrasenia" class="col-4">Nueva Contraseña:</label>
                            <div class="col-8">
                                <input type="password" class="form-control" style="width: 400px;">
                            </div>
                        </div>

                        <div class="form-group text-center">
                            <button class="btn btn-info">Cambiar</button>
                            <button class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </main>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>