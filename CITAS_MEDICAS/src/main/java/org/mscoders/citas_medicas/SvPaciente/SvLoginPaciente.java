package org.mscoders.citas_medicas.SvPaciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.mscoders.citas_medicas.BaseDatos.CRUD_His_medico;
import org.mscoders.citas_medicas.BaseDatos.CRUD_Paciente;
import org.mscoders.citas_medicas.model.Paciente;
import org.mscoders.citas_medicas.model.His_Medico;

import java.io.IOException;

@WebServlet(name = "SvLoginPaciente", value = "/Login-Paciente")
public class SvLoginPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario = req.getParameter("usuario");
        String contrasena = req.getParameter("contrasena");

        Paciente paciente = CRUD_Paciente.loginPaciente(usuario, contrasena);

        if (paciente != null) {
            HttpSession session = req.getSession(true);

            session.setAttribute("paciente", paciente);
            session.setAttribute("paciente_id", paciente.getId());

            His_Medico historial = CRUD_His_medico.obtenerPorPacienteId(paciente.getId());
            session.setAttribute("historial", historial);

            session.setMaxInactiveInterval(30 * 60);

            resp.sendRedirect("Paciente/indexPaciente.jsp");
        } else {
            System.out.println("Intento de acceso fallido para usuario: " + usuario);
            resp.sendRedirect("Paciente/loginPaciente.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Paciente/loginPaciente.jsp");
    }
}
