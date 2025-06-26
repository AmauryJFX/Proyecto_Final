package org.mscoders.citas_medicas.BaseDatos;

import org.mscoders.citas_medicas.Conexion;
import org.mscoders.citas_medicas.model.Cita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Cita {

    public static boolean Create(Cita cita) {
        Connection conn = Conexion.conectarBD();

        String sql = "INSERT INTO cita (motivo, fecha, hora, estado, doctor_id, paciente_id) VALUES ( ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cita.getMotivo());
            pst.setDate(2, Date.valueOf(cita.getFecha()));
            pst.setTime(3, java.sql.Time.valueOf(cita.getHora()));
            pst.setString(4, cita.getEstado());
            pst.setInt(5, cita.getDoctor_id());
            pst.setInt(6, cita.getPaciente_id());
            pst.executeUpdate();

            return true;



        } catch (SQLException e) {
            System.out.println("Error al solicitar una cita");
        }
        return false;
    }

    public static List<Cita> Read() {
        Connection conn = Conexion.conectarBD();
        String sql = "SELECT * FROM cita";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Cita> citas = new ArrayList<Cita>();
            while (rs.next()) {
                Cita cita = new Cita();

                cita.setId(rs.getInt("id"));
                cita.setMotivo( rs.getString("motivo") );
                cita.setFecha(rs.getDate("fecha").toLocalDate() );
                cita.setHora( rs.getTime("hora").toLocalTime() );
                cita.setEstado( rs.getString("estado") );
                cita.setDoctor_id( rs.getInt("doctor_id") );
                cita.setPaciente_id( rs.getInt("paciente_id") );

                citas.add(cita);
            }
            return citas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean Update(Cita cita) {


        Connection conn = Conexion.conectarBD();
        String sql = "UPDATE cita SET motivo = ?, fecha = ?, hora = ?, estado = ?, doctor_id = ?, paciente_id = ? WHERE id = ? ";

        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cita.getMotivo());
            pst.setDate(2, Date.valueOf(cita.getFecha()));
            pst.setTime(3, Time.valueOf(cita.getHora()));
            pst.setString(4, cita.getEstado());
            pst.setInt(5, cita.getDoctor_id());
            pst.setInt(6, cita.getPaciente_id());
            pst.setInt(7, cita.getId());
            pst.executeUpdate();

            return  true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar la cita");
        }
        return false;
    }


    public static boolean Delete(Cita cita) {

        Connection conn = Conexion.conectarBD();
        String sql = "DELETE FROM cita WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, cita.getId());
            pst.executeUpdate();
            return  true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar la cita");
        }
        return false;
    }

    public static boolean actualizarEstado(Cita cita) {
        String sql = "UPDATE cita SET estado = ? WHERE id = ?";

        try (Connection conn = Conexion.conectarBD();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, cita.getEstado());
            pst.setInt(2, cita.getId());
            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar solo el estado: " + e.getMessage());
        }

        return false;
    }



    public static List<Cita> obtenerCitasPorDoctor(int doctorId) {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM cita WHERE doctor_id = ? ORDER BY fecha, hora";

        try (Connection conn = Conexion.conectarBD();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, doctorId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setId(rs.getInt("id"));
                cita.setMotivo(rs.getString("motivo"));
                cita.setFecha(rs.getDate("fecha").toLocalDate());
                cita.setHora(rs.getTime("hora").toLocalTime());
                cita.setEstado(rs.getString("estado"));
                cita.setDoctor_id(rs.getInt("doctor_id"));
                cita.setPaciente_id(rs.getInt("paciente_id"));
                citas.add(cita);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener citas del doctor: " + e.getMessage());
        }

        return citas;
    }


    public static List<Cita> obtCompletado(int docId) {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM cita WHERE doctor_id = ? AND estado = 'completada' ORDER BY fecha DESC, hora";

        try(Connection conn = Conexion.conectarBD();
            PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, docId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setId(rs.getInt("id"));
                cita.setMotivo(rs.getString("motivo"));
                cita.setFecha(rs.getDate("fecha").toLocalDate());
                cita.setHora(rs.getTime("hora").toLocalTime());
                cita.setEstado(rs.getString("estado"));
                cita.setDoctor_id(rs.getInt("doctor_id"));
                cita.setPaciente_id(rs.getInt("paciente_id"));
                citas.add(cita);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener citas completadas: " + e.getMessage());
        }

        return citas;

    }


}