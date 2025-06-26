<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Acceso-Doctor</title>
</head>
  <body>
    <form action="../Registry-Paciente" method="post">
      <h1>Registrar Paciente :P</h1>
      <label for="nombre">Nombre</label>
      <input type="text" id="nombre" name="nombre" required>
      <button type="submit">Registrarse</button>
    </form>
    <hr>
    <br>
    <a href="loginPaciente.jsp">Iniciar Sesion</a>
  </body>
</html>