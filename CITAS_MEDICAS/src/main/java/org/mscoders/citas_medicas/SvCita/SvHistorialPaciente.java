package org.mscoders.citas_medicas.SvCita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mscoders.citas_medicas.BaseDatos.CRUD_Cita;
import org.mscoders.citas_medicas.model.Cita;
import org.mscoders.citas_medicas.model.Paciente;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SvHistorialPaciente", value = "/Historial-Paciente")
public class SvHistorialPaciente extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Paciente paciente = (Paciente) session.getAttribute("paciente");

        if (paciente == null) {
            resp.sendRedirect("../Paciente/loginPaciente.jsp");
            return;
        }

        List<Cita> citasPaciente = CRUD_Cita.obtCitasPorPaciente(paciente.getId());

        req.setAttribute("citasPaciente", citasPaciente);
        req.getRequestDispatcher("/Paciente/VerCitas.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("../Paciente/indexPaciente.jsp");
    }

}
