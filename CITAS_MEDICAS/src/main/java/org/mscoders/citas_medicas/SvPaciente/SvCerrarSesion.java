package org.mscoders.citas_medicas.SvPaciente;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCerrarSesion", value = "/Cerrar-Sesion")
public  class SvCerrarSesion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        req.getSession().invalidate();
        try {
            resp.sendRedirect("Paciente/loginPaciente.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
