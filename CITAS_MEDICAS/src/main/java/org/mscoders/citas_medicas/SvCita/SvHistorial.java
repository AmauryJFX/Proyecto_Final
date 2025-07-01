package org.mscoders.citas_medicas.SvCita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mscoders.citas_medicas.BaseDatos.CRUD_Cita;
import org.mscoders.citas_medicas.model.Cita;
import org.mscoders.citas_medicas.model.Doctor;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SvHistorial", value = "/Historial")
public class SvHistorial extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Doctor doctor = (Doctor) session.getAttribute("doctor");

        if (doctor == null) {
            resp.sendRedirect("../Medico/loginDoctor.jsp");
            return;
        }

        List<Cita> citasCompletadas = CRUD_Cita.obtCompletadoDoc(doctor.getId());

        req.setAttribute("citasCompletadas", citasCompletadas);
        req.getRequestDispatcher("Medico/historialDoctor.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("../Medico/historialDoctor.jsp");
    }

}
