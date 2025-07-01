<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.mscoders.citas_medicas.model.Doctor" %>
<%
    Doctor doctor = (Doctor) session.getAttribute("doctor");

    if (doctor == null) {
        response.sendRedirect("../Doctor/loginDoctor.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Panel del Doctor</title>
    <link rel="stylesheet" href="../Css/indexDoctor.css">
</head>
<body>
<h1>Bienvenido, Dr. <%= doctor.getNombre() %> 🩺</h1>
<p>Especialidad: <strong><%= doctor.getEspecialidad() %></strong></p>
<p>Correo: <%= doctor.getCorreo() %></p>

<hr>

<h2>Tus próximas citas</h2>
<%@ page import="java.util.List" %>
<%@ page import="org.mscoders.citas_medicas.model.Cita" %>
<%@ page import="org.mscoders.citas_medicas.BaseDatos.CRUD_Cita" %>

<%
    List<Cita> citas = CRUD_Cita.obtenerCitasPorDoctor(doctor.getId());
%>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Fecha</th>
        <th>Hora</th>
        <th>Motivo</th>
        <th>Estado</th>
        <th>Actualizar</th>
    </tr>

    <% for (Cita c : citas) { %>
    <form action="../ActualizarEstadoCita" method="post">
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getFecha() %></td>
            <td><%= c.getHora() %></td>
            <td><%= c.getMotivo() %></td>
            <td>
                <select name="estado">
                    <option value="pendiente" <%= c.getEstado().equals("pendiente") ? "selected" : "" %>>Pendiente</option>
                    <option value="asignada" <%= c.getEstado().equals("asignada") ? "selected" : "" %>>Asignada</option>
                    <option value="completada" <%= c.getEstado().equals("completada") ? "selected" : "" %>>Completada</option>
                    <option value="cancelada" <%= c.getEstado().equals("cancelada") ? "selected" : "" %>>Cancelada</option>
                </select>
            </td>
            <td>
                <input type="hidden" name="idCita" value="<%= c.getId() %>">
                <button type="submit">Guardar</button>
            </td>
        </tr>
    </form>
    <% } %>
</table>


<br>
<form action="../Cerrar-SesionDoc" method="post" style="\display:inline; margin-left: 10px;">
    <button type="submit">Cerrar Sesión</button>
</form>


<br>
<form action="../Historial" method="post">
    <button type="submit"> Historial </button>
</form>


</body>
</html>
