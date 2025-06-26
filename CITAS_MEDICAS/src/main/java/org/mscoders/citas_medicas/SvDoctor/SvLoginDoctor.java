package org.mscoders.citas_medicas.SvDoctor;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mscoders.citas_medicas.BaseDatos.CRUD_Doctor;
import org.mscoders.citas_medicas.model.Doctor;

@WebServlet(name = "SvLoginDoctor", value ="/Login-Doctor")
public class SvLoginDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usuario = req.getParameter("usuario");
        String contrasena = req.getParameter("contrasena");

        Doctor doctor = CRUD_Doctor.loginDoctor(usuario,contrasena);

        if (doctor != null) {
            HttpSession session = req.getSession();
            session.setAttribute("doctor", doctor);

            resp.sendRedirect("Medico/indexDoctor.jsp");
        } else {
            System.out.println("Intento fallido de login para el doctor: " + usuario);
            resp.sendRedirect("Medico/loginDoctor.jsp?error=1");
        }
    }//era la ruta
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("Medico/loginDoctor.jsp");
    }
}