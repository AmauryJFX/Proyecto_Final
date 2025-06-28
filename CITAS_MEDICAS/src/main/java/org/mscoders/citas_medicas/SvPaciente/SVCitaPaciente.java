package org.mscoders.citas_medicas.SvPaciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mscoders.citas_medicas.BaseDatos.CRUD_Cita;
import org.mscoders.citas_medicas.model.Cita;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet (name = "SVCitaPaciente", value = "/Cita-Paciente")
public class SVCitaPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String motivo = req.getParameter("motivo");
            String fecha1 = req.getParameter("fecha");
            String hora1 = req.getParameter("hora");
            String estado = req.getParameter("estado");
            Integer doc = Integer.parseInt(req.getParameter("id_medico"));

            HttpSession session = req.getSession();
            Integer pacienteId = (Integer) session.getAttribute("paciente_id");

            LocalDate fecha = LocalDate.parse(fecha1);
            LocalTime hora = LocalTime.parse(hora1);

            Cita cita = new Cita();
            cita.setMotivo(motivo);
            cita.setFecha(fecha);
            cita.setHora(hora);
            cita.setEstado(estado);
            cita.setPaciente_id(pacienteId);
            cita.setDoctor_id(doc);

            boolean crear = CRUD_Cita.Create(cita);

            if (crear) {
                //Aqui
                //Ya le cambie
                resp.sendRedirect("Paciente/loginPaciente.jsp?success=1");
            } else {
                resp.sendRedirect("Paciente/loginPaciente.jsp?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("Paciente/loginPaciente.jsp?error=2");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("Paciente/loginPaciente.jsp");
    }

}
