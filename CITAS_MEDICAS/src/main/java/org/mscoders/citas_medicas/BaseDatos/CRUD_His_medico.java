package org.mscoders.citas_medicas.BaseDatos;

import org.mscoders.citas_medicas.Conexion;
import org.mscoders.citas_medicas.model.His_Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_His_medico {

    public static int Create(His_Medico historial) {
        String sql = "INSERT INTO his_medico (Alergias, Antecedentes) VALUES (?, ?)";

        try (Connection conn = Conexion.conectarBD();
             PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, historial.getAlergia());
            pst.setString(2, historial.getAntecedente());
            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar historial médico: " + e.getMessage());
            e.printStackTrace();
        }

        return -1;
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
        String sql = "UPDATE his_medico SET alergia = ?, antecedente = ? WHERE id = ? ";

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

    public static His_Medico obtenerPorPacienteId(int pacienteId) {
        His_Medico h = null;
        String sql = "SELECT * FROM his_medico WHERE paciente_id = ?";

        try (Connection conn = Conexion.conectarBD();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, pacienteId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                h = new His_Medico();
                h.setId(rs.getInt("id"));
                h.setAlergia(rs.getString("alergias"));
                h.setAntecedente(rs.getString("antecedentes"));

            } else {
                System.out.println("[INFO] No se encontró historial para paciente_id: " + pacienteId);
            }

        } catch (SQLException e) {
            System.err.println("[ERROR] Fallo al obtener historial médico del paciente_id " + pacienteId);
            e.printStackTrace();
        }

        return h;
    }


}