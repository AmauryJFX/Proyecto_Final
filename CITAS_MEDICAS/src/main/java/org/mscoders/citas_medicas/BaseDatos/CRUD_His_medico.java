package org.mscoders.citas_medicas.BaseDatos;

import org.mscoders.citas_medicas.Conexion;
import org.mscoders.citas_medicas.model.His_Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_His_medico {

    public static boolean Create(His_Medico his) {
        Connection conn = Conexion.conectarBD();

        String sql = "INSERT INTO his_medico (alergias, antecedentes) VALUES (?,?)";

        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, his.getAlergia());
            pst.setString(2, his.getAntecedente());
            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al agregar historial medico");
        }
        return false;
    }

    public static List<His_Medico> Read() {
        Connection conn = Conexion.conectarBD();
        String sql = "SELECT * FROM his_medico";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<His_Medico> historiales = new ArrayList<His_Medico>();
            while (rs.next()) {
                His_Medico his = new His_Medico();

                his.setId(rs.getInt("id"));
                his.setAlergia(rs.getString("alergias"));
                his.setAntecedente(rs.getString("antecedentes"));

                historiales.add( his );
            }

            return historiales;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean Update(His_Medico hisMedico) {


        Connection conn = Conexion.conectarBD();
        String sql = "UPDATE his_medico SET alergias = ?, antecedentes = ? WHERE id = ? ";

        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, hisMedico.getAlergia());
            pst.setString(2, hisMedico.getAntecedente());
            pst.setInt(3, hisMedico.getId());
            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el historial medico: " + e.getMessage());
        }
        return false;

    }


    public static boolean Delete(His_Medico hisMedico) {

        Connection conn = Conexion.conectarBD();
        String sql = "DELETE FROM his_medico WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, hisMedico.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la historial medico");
        }
        return false;
    }

}