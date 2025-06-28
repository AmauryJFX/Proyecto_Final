<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Registro de Paciente</title>
    <link rel="stylesheet" href="../Css/registryPaciente.css">
</head>
<body>

<h2>Registro - Nuevo Paciente</h2>

<form action="../Registry-Paciente" method="post">
  <label>Nombre Completo:</label>
  <input type="text" name="nombre" value="<%= request.getAttribute("nombre") != null ? request.getAttribute("nombre") : "" %>" required><br><br>

  <label>Usuario:</label>
  <input type="text" name="usuario" value="<%= request.getAttribute("usuario") != null ? request.getAttribute("usuario") : "" %>" required><br><br>

  <label>Contraseña:</label>
  <input type="password" name="contrasena" required><br><br>

  <label>Correo Electrónico:</label>
  <input type="email" name="correo" value="<%= request.getAttribute("correo") != null ? request.getAttribute("correo") : "" %>" required><br><br>

  <label>Teléfono:</label>
  <input type="text" name="telefono" value="<%= request.getAttribute("telefono") != null ? request.getAttribute("telefono") : "" %>" required><br><br>

  <label>Género:</label>
  <select name="genero" required>
    <option value="masculino" <%= "masculino".equals(request.getAttribute("genero")) ? "selected" : "" %>>Masculino</option>
    <option value="femenino" <%= "femenino".equals(request.getAttribute("genero")) ? "selected" : "" %>>Femenino</option>
    <option value="otro" <%= "otro".equals(request.getAttribute("genero")) ? "selected" : "" %>>Otro</option>
  </select><br><br>

  <label>Fecha de Nacimiento:</label>
  <input type="date" name="fecha_nacimiento" value="<%= request.getAttribute("fecha_nacimiento") != null ? request.getAttribute("fecha_nacimiento") : "" %>" required><br><br>

  <hr>
  <h3>Historial Médico</h3>

  <label>Alergias:</label>
  <input type="text" name="alergias" value="<%= request.getAttribute("alergias") != null ? request.getAttribute("alergias") : "" %>"><br><br>

  <label>Antecedentes Médicos:</label>
  <input type="text" name="antecedentes" value="<%= request.getAttribute("antecedentes") != null ? request.getAttribute("antecedentes") : "" %>"><br><br>

  <button type="submit">Registrarse</button>
</form>

<%-- Alerta con JavaScript --%>
<%
  String error = (String) request.getAttribute("error");
  if (error != null) {
    String mensaje = "";
    if ("correo_duplicado".equals(error)) {
      mensaje = "El correo electrónico ya está registrado.";
    } else if ("usuario_duplicado".equals(error)) {
      mensaje = "El nombre de usuario ya existe.";
    } else if ("telefono_duplicado".equals(error)) {
      mensaje = "Este número telefónico ya fue registrado.";
    } else if ("historial_duplicado".equals(error)) {
      mensaje = "Este historial médico ya fue asignado.";
    } else if ("historial_fail".equals(error)) {
      mensaje = "No se pudo registrar el historial médico.";
    } else {
      mensaje = "Error inesperado. Intenta de nuevo.";
    }
%>
<script>
  alert("<%= mensaje %>");
</script>
<%
  }
%>

</body>
</html>
