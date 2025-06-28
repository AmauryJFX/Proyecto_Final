
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Cita</title>
</head>
<body>

        <form action="Cita-Paciente" method="post" >

                <p>Agenda una cita</p>

            <label for="motivo" > Motivo</label>
            <input type="text" id="motivo" name="motivo" required><br><br>

            <label for="fecha"> Fecha</label>
            <input type="date" id="fecha" name="fecha" required><br><br>

            <label for="hora"> Hora:</label>
            <input type="time" id="hora" name="hora" required><br><br>

            <label for="estado"> Estado </label>
            <input type="text" id="estado" name="estado" Value="Pendiente" readonly>

            <label for="id_medico"> ID Medico </label>
            <input type="text" id="id_medico" name="id_medico" required>



            <button type="submit"> Agendar </button><br><br>


        </form>



</body>
</html>
