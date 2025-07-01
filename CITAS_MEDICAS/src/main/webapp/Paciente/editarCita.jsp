<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.mscoders.citas_medicas.model.Cita" %>
<%
  Cita cita = (Cita) request.getSession().getAttribute("cita");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Cita</title>
  <link rel="stylesheet" href="../Css/verCitas.css">
</head>
<body>

<h1>Editar Cita</h1>

<% if (cita != null) { %>
<form action="${pageContext.request.contextPath}/SvActualizarCita" method="post">
  <input type="hidden" name="id" value="<%= cita.getId() %>">
  <input type="hidden" name="doctor_id" value="<%= cita.getDoctor_id() %>">
  <input type="hidden" name="paciente_id" value="<%= cita.getPaciente_id() %>">

  <label for="fecha">Fecha:</label>
  <input type="date" name="fecha" id="fecha" value="<%= cita.getFecha() %>" required><br><br>

  <label for="hora">Hora:</label>
  <input type="time" name="hora" id="hora" value="<%= cita.getHora() %>" required><br><br>

  <label for="motivo">Motivo:</label>
  <input type="text" name="motivo" id="motivo" value="<%= cita.getMotivo() %>" required><br><br>

  <label for="estado">Estado:</label>
  <select name="estado" id="estado">
    <option value="pendiente" <%= cita.getEstado().equals("pendiente") ? "selected" : "" %>>Pendiente</option>
    <option value="asignada" <%= cita.getEstado().equals("asignada") ? "selected" : "" %>>Asignada</option>
    <option value="completada" <%= cita.getEstado().equals("completada") ? "selected" : "" %>>Completada</option>
    <option value="cancelada" <%= cita.getEstado().equals("cancelada") ? "selected" : "" %>>Cancelada</option>
  </select><br><br>

  <button type="submit">Guardar Cambios</button>
</form>
<% } else { %>
<p style="color: red;">No se encontró la cita solicitada.</p>
<% } %>

</body>
</html>
