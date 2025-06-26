package org.mscoders.citas_medicas.SvDoctor;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mscoders.citas_medicas.BaseDatos.CRUD_Doctor;
import org.mscoders.citas_medicas.model.Doctor;

@WebServlet(name = "SvRegistryDoctor", value ="/Registry-Doctor")
public class SvRegistryDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean crear;

        Doctor doctor = new Doctor();

        doctor.setNombre( request.getParameter("nombre") );
        doctor.setUsuario( request.getParameter("usuario") );
        doctor.setCorreo( request.getParameter("correo") );
        doctor.setContrasena(   request.getParameter("contrasena") );
        doctor.setEspecialidad( request.getParameter("especialidad") );
        doctor.setCedula( request.getParameter("cedula") );
        doctor.setTelefono( request.getParameter("telefono") );

        crear = CRUD_Doctor.Create( doctor );

        if( crear == true) {
            HttpSession session = request.getSession();
            session.setAttribute("activo", doctor);
            response.sendRedirect("Medico/loginDoctor.jsp");
        } else {
        }

    }
}