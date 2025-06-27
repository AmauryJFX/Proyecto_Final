<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="org.mscoders.citas_medicas.model.Paciente" %>
<%@ page import="org.mscoders.citas_medicas.model.His_Medico" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Inicio - Paciente</title>
</head>
<body>

<%
  Paciente paciente = (Paciente) session.getAttribute("paciente");
  His_Medico historial = (His_Medico) session.getAttribute("historial");

  if (paciente == null) {
%>
<p>No hay sesión activa. <a href="loginPaciente.jsp">Iniciar sesión</a></p>
<%
} else {
%>

<h2>Bienvenido, <%= paciente.getNombre() %> 👋</h2>

<h3>Datos Personales</h3>
<ul>
  <li><strong>Usuario:</strong> <%= paciente.getUsuario() %></li>
  <li><strong>Correo:</strong> <%= paciente.getCorreo() %></li>
  <li><strong>Teléfono:</strong> <%= paciente.getTelefono() %></li>
  <li><strong>Nacimiento:</strong> <%= paciente.getNacimiento() %></li>
</ul>

<h3>Historial Médico</h3>
<% if (historial != null) { %>
<ul>
  <li><strong>Alergias:</strong> <%= historial.getAlergia() %></li>
  <li><strong>Antecedentes:</strong> <%= historial.getAntecedente() %></li>
</ul>
<% } else { %>
<p>No se encontró historial médico asignado.</p>
<% } %>

<hr>

<h3>Opciones</h3>

<form action="../Cargar-Doctores" method="get" style="display:inline;">
  <button type="submit">Agendar Cita</button>
</form>

<form action="../CerrarSesion" method="post" style="display:inline; margin-left: 10px;">
  <button type="submit">Cerrar Sesión</button>
</form>

<% } %>

</body>
</html>
