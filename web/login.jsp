<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
        <style>
            body{
                background-size: 100vw 100vh;
                background-attachment: fixed;
                background-color: #FFF;
                background-image: url(cobweb.jpg);
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            <h4>Iniciar sesión</h4>
                        </div>
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}/Login" method="POST" class="was-validated">
                                <div class="form-group">
                                    <label for="correo">Direccion de correo</label>
                                    <input type="email" class="form-control" name="correo" placeholder="Introduce email" required value>
                                </div>
                                <div class="form-group">
                                    <label for="contrasena">Introduce contraseña</label>
                                    <input type="password" class="form-control" name="contrasena" placeholder="Password" required value>
                                </div>
                                <div class="form-group">
                                    <br><button type="submit" class="btn btn-primary">Entrar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
