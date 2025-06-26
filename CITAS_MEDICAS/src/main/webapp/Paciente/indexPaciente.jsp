<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Inicio</title>
</head>
<body>
<% String nombre = (String) request.getSession().getAttribute("nombre"); %>
<h1><%=nombre %></h1>
<br/>
<p><strong>Bienvenido Paciente</strong></p>

<a href="../Paciente/citaPaciente.jsp" > Agregar</a>

</body>
</html>