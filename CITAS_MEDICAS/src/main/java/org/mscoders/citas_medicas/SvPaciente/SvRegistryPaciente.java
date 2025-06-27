package org.mscoders.citas_medicas.SvPaciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.mscoders.citas_medicas.BaseDatos.CRUD_His_medico;
import org.mscoders.citas_medicas.BaseDatos.CRUD_Paciente;
import org.mscoders.citas_medicas.model.His_Medico;
import org.mscoders.citas_medicas.model.Paciente;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;

@WebServlet(name = "SvRegistryPaciente", value = "/Registry-Paciente")
public class SvRegistryPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String alergias = request.getParameter("alergias");
        String antecedentes = request.getParameter("antecedentes");

        His_Medico hisMedico = new His_Medico();
        hisMedico.setAlergia(alergias);
        hisMedico.setAntecedente(antecedentes);

        int idHistorial = CRUD_His_medico.Create(hisMedico);

        if (idHistorial > 0) {
            Paciente paciente = new Paciente();
            paciente.setNombre(request.getParameter("nombre"));
            paciente.setUsuario(request.getParameter("usuario"));
            paciente.setContrasena(request.getParameter("contrasena"));
            paciente.setCorreo(request.getParameter("correo"));
            paciente.setTelefono(request.getParameter("telefono"));
            paciente.setNacimiento(LocalDate.parse(request.getParameter("fecha_nacimiento")));
            paciente.setHis_medico_id(idHistorial);

            try {
                boolean creado = CRUD_Paciente.Create(paciente);
                if (creado) {
                    response.sendRedirect("Paciente/loginPaciente.jsp?registro=exito");
                } else {
                    request.setAttribute("error", "general");
                    request.getRequestDispatcher("Paciente/registryPaciente.jsp").forward(request, response);
                }

            } catch (RuntimeException ex) {
                request.setAttribute("error", ex.getMessage());

                // Reinyectar valores del formulario
                request.setAttribute("nombre", request.getParameter("nombre"));
                request.setAttribute("usuario", request.getParameter("usuario"));
                request.setAttribute("correo", request.getParameter("correo"));
                request.setAttribute("telefono", request.getParameter("telefono"));
                request.setAttribute("fecha_nacimiento", request.getParameter("fecha_nacimiento"));
                request.setAttribute("alergias", request.getParameter("alergias"));
                request.setAttribute("antecedentes", request.getParameter("antecedentes"));

                request.getRequestDispatcher("Paciente/registryPaciente.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("error", "historial_fail");
            request.getRequestDispatcher("Paciente/registryPaciente.jsp").forward(request, response);
        }
    }
}
