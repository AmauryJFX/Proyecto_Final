package org.mscoders.citas_medicas.SvCita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import org.mscoders.citas_medicas.BaseDatos.CRUD_Cita;
import org.mscoders.citas_medicas.model.Cita;

@WebServlet(name = "ActualizarEstadoCita", value = "/ActualizarEstadoCita")
public class ActualizarEstadoCita extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idCita = Integer.parseInt(req.getParameter("idCita"));
            String nuevoEstado = req.getParameter("estado");

            Cita cita = new Cita();
            cita.setId(idCita);
            cita.setEstado(nuevoEstado);

            boolean actualizado = CRUD_Cita.actualizarEstado(cita);

            if (actualizado) {
                resp.sendRedirect("Medico/indexDoctor.jsp");
            } else {
                resp.sendRedirect("Medico/indexDoctor.jsp?error=1");
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar estado de cita: " + e.getMessage());
            resp.sendRedirect("Medico/indexDoctor.jsp?error=1");
        }
    }
}
