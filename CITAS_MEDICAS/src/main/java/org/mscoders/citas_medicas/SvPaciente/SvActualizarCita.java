package org.mscoders.citas_medicas.SvPaciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.mscoders.citas_medicas.BaseDatos.CRUD_Cita;
import org.mscoders.citas_medicas.model.Cita;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "SvActualizarCita", value = "/SvActualizarCita")
public class SvActualizarCita extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String motivo = req.getParameter("motivo");
            LocalDate fecha = LocalDate.parse(req.getParameter("fecha"));
            LocalTime hora = LocalTime.parse(req.getParameter("hora"));
            String estado = req.getParameter("estado");

            int doctorId = Integer.parseInt(req.getParameter("doctor_id"));
            int pacienteId = Integer.parseInt(req.getParameter("paciente_id"));

            Cita cita = new Cita();
            cita.setId(id);
            cita.setMotivo(motivo);
            cita.setFecha(fecha);
            cita.setHora(hora);
            cita.setEstado(estado);
            cita.setDoctor_id(doctorId);
            cita.setPaciente_id(pacienteId);

            boolean actualizado = CRUD_Cita.Update(cita);

            if (actualizado) {
                resp.sendRedirect("Paciente/indexPaciente.jsp?mod=1");
            } else {
                resp.sendRedirect("Paciente/indexPaciente.jsp?mod=0");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("Paciente/indexPaciente.jsp?mod=error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Cita cita = CRUD_Cita.buscarCitaPorId(id);
        HttpSession session = req.getSession(); // Pues habria que crear otro css, no? por que no tiene los mismos inputs que crear cita
        session.setAttribute("cita", cita);
        resp.sendRedirect("Paciente/editarCita.jsp");
    }
}
