<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Acceso-Doctor</title>
  <link rel="stylesheet" href="../Css/regDoctor.css">
</head>
  <body>
  <h1>Registrar Doctor</h1>
  <form action="../Registry-Doctor" method="post">

      <label for="nombre">Nombre: </label>
      <input type="text" id="nombre" name="nombre" required>

      <br>
      <label for="usuario">Usuario: </label>
      <input type="text" id="usuario" name="usuario" placeholder="Max. 30 Caracteres" required>

      <br>
      <label for="correo">Correo: </label>
      <input type="text" id="correo" name="correo" required>

      <br>
      <label for="contrasena">Contraseña: </label>
      <input type="password" id="contrasena" name="contrasena" placeholder="Max. 15 Digitos" required>

      <br>
      <label for="especialidad">Especialidad: </label>
      <input type="text" id="especialidad" name="especialidad" required>

      <br>
      <label for="cedula">Cedula: </label>
      <input type="text" id="cedula" name="cedula" placeholder="8 digitos" required>

      <br>
      <label for="telefono">Telefono: </label>
      <input type="text" id="telefono" name="telefono" placeholder="Opcional">

      <br>
      <button type="submit">Registrarse</button>

    </form>
    <hr>
    <br>
    <a href="loginDoctor.jsp">Iniciar Sesion</a>
  </body>
</html>