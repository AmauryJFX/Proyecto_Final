package org.mscoders.citas_medicas.SvDoctor;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvCerrarSesionDoc", value = "/Cerrar-SesionDoc")
public  class SvCerrarSesion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        req.getSession().invalidate();
        try {
            resp.sendRedirect("Medico/loginDoctor.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
