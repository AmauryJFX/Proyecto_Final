package org.mscoders.citas_medicas.SvPaciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.mscoders.citas_medicas.model.Paciente;

import java.io.IOException;

@WebServlet(name = "SvRegistryPaciente", value ="/Registry-Paciente")
public class SvRegistryPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Paciente paciente = new Paciente();

        paciente.setNombre( request.getParameter("nombre") );
        paciente.setCorreo( request.getParameter("correo"));
        paciente.setUsuario( request.getParameter("usuario"));
        paciente.setContrasena( request.getParameter("contrasena"));
        paciente.setNombre( request.getParameter("nombre"));
//        paciente.setNacimiento( request.getParameter( "nacimiento") );
        paciente.setTelefono( request.getParameter("telefono"));


        HttpSession session = request.getSession();
        session.setAttribute("activo", paciente);

        response.sendRedirect("Paciente/indexPaciente.jsp");

    }
}