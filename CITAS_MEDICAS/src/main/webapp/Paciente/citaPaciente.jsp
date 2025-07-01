<%@ page import="java.util.List" %>
<%@ page import="org.mscoders.citas_medicas.model.Doctor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Cita</title>
    <link rel="stylesheet" href="Css/crearCita.css">
</head>
<body>

<form action="Cita-Paciente" method="post">

    <p>Agenda una cita</p>

    <label for="motivo">Motivo</label>
    <input type="text" id="motivo" name="motivo" required><br><br>

    <label for="fecha">Fecha</label>
    <input type="date" id="fecha" name="fecha" required><br><br>

    <label for="hora">Hora:</label>
    <input type="time" id="hora" name="hora" required><br><br>

    <label for="estado">Estado</label>
    <input type="text" id="estado" name="estado" value="Pendiente" readonly><br><br>

    <label for="id_medico">ID Médico</label>
    <select name="id_medico" id="id_medico" required>
        <%
            List<Doctor> doctores = (List<Doctor>) request.getSession().getAttribute("ListaDoctor");
            if (doctores != null && !doctores.isEmpty()) {
                for (Doctor doctor : doctores) {
        %>
        <option value="<%= doctor.getId() %>"><%= doctor.getNombre() %></option>
        <%
            }
        } else {
        %>
        <option disabled>No hay doctores disponibles</option>
        <%
            }
        %>
    </select><br><br>

    <button type="submit">Agendar</button>

</form>

</body>
</html>
