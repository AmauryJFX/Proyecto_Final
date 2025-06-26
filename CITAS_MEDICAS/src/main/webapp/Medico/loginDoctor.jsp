<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Acceso - Doctor</title>
        <link rel="stylesheet" href="../Css/loginDoctor.css">
    </head>
    <body>

    <h1>Iniciar Sesión - Doctor</h1>

    <% if ("1".equals(request.getParameter("error"))) { %>
    <p style="color: red;">Usuario o contraseña incorrectos.</p>
    <% } %>

    <form action="../Login-Doctor" method="post">
        <label for="usuario">Usuario</label>
        <input type="text" id="usuario" name="usuario" required>

        <label for="contrasena">Contraseña</label>
        <input type="password" id="contrasena" name="contrasena" required>

        <button type="submit">Acceder</button>
        <a href="registryDoctor.jsp">¿No tienes cuenta? Regístrate</a>
    </form>

    </body>
    </html>
