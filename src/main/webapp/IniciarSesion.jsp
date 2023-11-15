<%-- 
    Document   : IniciarSesion
    Created on : 15 nov. 2023, 14:24:06
    Author     : Carlos Oviedo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <title>Login y Register</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">


    <link rel="stylesheet" href="./css/IniciarSesion.css">
</head>
<body>

        <main>

            <div class="contenedor__todo">
                <div class="caja__trasera">
                    <div class="caja__trasera-login">
                        <h3>¿Ya tienes una cuenta?</h3>
                        <p>Inicia sesión para entrar en la página</p>
                        <button id="btn__iniciar-sesion">Iniciar Sesión</button>
                    </div>
                    <div class="caja__trasera-register">
                        <h3>¿Aún no tienes una cuenta?</h3>
                        <p>Regístrate para que puedas iniciar sesión</p>
                        <button id="btn__registrarse">Regístrarse</button>
                    </div>
                </div>

             
                <div class="contenedor__login-register">
                    <!--para el login-->
                    <form action="" class="formulario__login">
                        <h2>Iniciar Sesión</h2>
                        <input type="text" placeholder="Correo Electronico">
                        <input type="password" placeholder="Contraseña">
                        <button>Entrar</button>
                    </form>

                    <!--para registrarse-->
                    <form action="" class="formulario__register">
                        <h2>Regístrarse</h2>
                        <input type="text" placeholder="Nombre completo">
                        <input type="text" placeholder="Correo Electronico">
                        <input type="text" placeholder="Usuario">
                        <input type="password" placeholder="Contraseña">
                        <button>Regístrarse</button>
                    </form>
                </div>
            </div>

        </main>

       <script>
       
        document.getElementById("btn__iniciar-sesion").addEventListener("click", iniciarSesion);
        document.getElementById("btn__registrarse").addEventListener("click", register);
        window.addEventListener("resize", anchoPage);

      
        var formularioLogin = document.querySelector(".formulario__login");
        var formularioRegister = document.querySelector(".formulario__register");
        var contenedorLoginRegister = document.querySelector(".contenedor__login-register");
        var cajaTraseraLogin = document.querySelector(".caja__trasera-login");
        var cajaTraseraRegister = document.querySelector(".caja__trasera-register");

      

        function anchoPage() {
            if (window.innerWidth > 850) {
                cajaTraseraRegister.style.display = "block";
                cajaTraseraLogin.style.display = "block";
            } else {
                cajaTraseraRegister.style.display = "block";
                cajaTraseraRegister.style.opacity = "1";
                cajaTraseraLogin.style.display = "none";
                formularioLogin.style.display = "block";
                contenedorLoginRegister.style.left = "0px";
                formularioRegister.style.display = "none";
            }
        }

        anchoPage();

        function iniciarSesion() {
            if (window.innerWidth > 850) {
                formularioLogin.style.display = "block";
                contenedorLoginRegister.style.left = "10px";
                formularioRegister.style.display = "none";
                cajaTraseraRegister.style.opacity = "1";
                cajaTraseraLogin.style.opacity = "0";
            } else {
                formularioLogin.style.display = "block";
                contenedorLoginRegister.style.left = "0px";
                formularioRegister.style.display = "none";
                cajaTraseraRegister.style.display = "block";
                cajaTraseraLogin.style.display = "none";
            }
        }

        function register() {
            if (window.innerWidth > 850) {
                formularioRegister.style.display = "block";
                contenedorLoginRegister.style.left = "410px";
                formularioLogin.style.display = "none";
                cajaTraseraRegister.style.opacity = "0";
                cajaTraseraLogin.style.opacity = "1";
            } else {
                formularioRegister.style.display = "block";
                contenedorLoginRegister.style.left = "0px";
                formularioLogin.style.display = "none";
                cajaTraseraRegister.style.display = "none";
                cajaTraseraLogin.style.display = "block";
                cajaTraseraLogin.style.opacity = "1";
            }
        }
    </script>
    
    </body>
</html>