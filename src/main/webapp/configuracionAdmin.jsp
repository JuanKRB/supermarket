

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/admin2.css">
        <link rel="stylesheet" href="./css/configuracionAdmin.css">
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="./icono/favicon.ico" type="image/x-icon">
        <title>Supermercado</title>
    </head>
    <body>


        <main>

  

                <div class="informacion-usuario">
                    <img src="img/perfil2.png" alt=""/>
                    <h4>Admin1</h4>

                    <form action="ProcesoActualizar" method="post">
                        <label for="usuario">Usuario:</label>
                        <input type="text" name="usuario" id="usuario" required>
                        <br>

                        <label for="contrasena">Contraseña:</label>
                        <input type="password" name="contrasena" id="contrasena" required>
                        <br>

                        <label for="nuevaContrasena">Nueva Contraseña:</label>
                        <input type="password" name="nuevaContrasena" id="nuevaContrasena" required>
                        <br>

                        <input type="submit" value="Actualizar">
                    </form>
                </div>

        </main>

    </body>
</html>
