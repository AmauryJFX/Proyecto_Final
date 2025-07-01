<%@ page import="org.mscoders.citas_medicas.model.Cita" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Cita> citas = (List<Cita>) request.getAttribute("citasPaciente");
%>

<html>
<head>
    <title>Historial de Citas</title>
    <link rel="stylesheet" href="Css/editarCitas.css">
</head>
<body>

<h1>Historial de Citas de Paciente</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Fecha</th>
        <th>Hora</th>
        <th>Motivo</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>

    <% if (citas != null && !citas.isEmpty()) {
        for (Cita c : citas) {
    %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getFecha() %></td>
        <td><%= c.getHora() %></td>
        <td><%= c.getMotivo() %></td>
        <td><%= c.getDoctor_id() %></td>
        <td>
            <form action="${pageContext.request.contextPath}/SvActualizarCita" method="get">
            <input type="hidden" name="id" value="<%= c.getId() %>">

                <button type="submit">Modificar</button>
            </form>
        </td>
    </tr>
    <% } %>
    <% } else { %>
    <tr><td colspan="6"> No hay citas completadas</td></tr>
    <% } %>

</table>
<br>
</body>
</html>
