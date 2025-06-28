<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Acceso Paciente</title>
  <link rel="stylesheet" href="../Css/loginPaciente.css">
</head>
<body>

<h2>Iniciar Sesión Paciente</h2>

<% if ("1".equals(request.getParameter("success"))) { %>
<script>alert("✅ Cita registrada con éxito. Inicia sesión para continuar.");</script>
<% } %>

<% if ("1".equals(request.getParameter("error"))) { %>
<p style="color: red;">Usuario o contraseña incorrectos.</p>
<% } %>

<form action="../Login-Paciente" method="post">
  <label for="usuario">Usuario</label>
  <input type="text" id="usuario" name="usuario" required><br><br>

  <label for="contrasena">Contraseña</label>
  <input type="password" id="contrasena" name="contrasena" required><br><br>

  <button type="submit">Acceder</button><br><br>

  <a href="registryPaciente.jsp" class="extra-link">¿No tienes cuenta? Regístrate</a>
</form>

</body>
</html>
