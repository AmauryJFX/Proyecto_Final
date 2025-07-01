package org.mscoders.citas_medicas.SvPaciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.mscoders.citas_medicas.BaseDatos.CRUD_Doctor;
import org.mscoders.citas_medicas.model.Doctor;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SvCargarDoctores", value = "/Cargar-Doctores")
public class SvCargarDoctores extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Doctor> listaDoctores = CRUD_Doctor.Read();

        HttpSession session = request.getSession();
        session.setAttribute("ListaDoctor", listaDoctores);
        request.getRequestDispatcher("Paciente/citaPaciente.jsp").forward(request, response);
    }
}
