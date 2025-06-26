package org.mscoders.citas_medicas.SvPaciente;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mscoders.citas_medicas.BaseDatos.CRUD_Paciente;
import org.mscoders.citas_medicas.model.Paciente;

@WebServlet(name = "SvLoginPaciente", value = "/Login-Paciente")
public class SvLoginPaciente extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String usuario = req.getParameter("usuario");
    String contrasena = req.getParameter("contrasena");
    Paciente paciente = CRUD_Paciente.loginPaciente(usuario, contrasena);
    if (paciente != null) {
        HttpSession session = req.getSession();
        session.setAttribute("paciente", paciente);
        session.setAttribute("paciente_id", paciente.getId());
        resp.sendRedirect("Paciente/indexPaciente.jsp");
    }else{
        System.out.println("Intento de acceso fallido para usuario: " + usuario);
        resp.sendRedirect("Paciente/loginPaciente.jsp?error=1");
    }
}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect("Paciente/loginPaciente.jsp");
    }
}

