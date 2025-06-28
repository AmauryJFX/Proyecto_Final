<%@ page import="org.mscoders.citas_medicas.model.Cita" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Cita> citas = (List<Cita>) request.getAttribute("citasCompletadas");
%>

<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="Css/historialDoc.css">
</head>
<body>


<h1>Historial de Citas Completadas</h1>

<table border="1" cellpadding="8">
  <tr>
    <th>ID</th>
    <th>Fecha</th>
    <th>Hora</th>
    <th>Motivo</th>
    <th>Estado</th>

  </tr>

  <% if (citas != null && !citas.isEmpty()) {
    for (Cita c : citas){
  %>

  <tr>
    <td><%=c.getId()%></td>
    <td><%=c.getFecha()%></td>
    <td><%=c.getHora()%></td>
    <td><%=c.getMotivo()%></td>
    <td><%=c.getPaciente_id()%></td>
  </tr>

  <%
    }
  } else {
  %>
  <tr><td colspan="5"> No hay citas completadas</td></tr>

  <%
    }
  %>

</table>
<br>
</body>
</html>
