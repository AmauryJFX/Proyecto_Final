package org.mscoders.citas_medicas.BaseDatos;

import org.mscoders.citas_medicas.Conexion;
import org.mscoders.citas_medicas.model.Cita;
import org.mscoders.citas_medicas.model.Doctor;
import org.mscoders.citas_medicas.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Doctor {

    public static boolean Create(Doctor doctor) {
        Connection conn = Conexion.conectarBD();

        String sql = "INSERT INTO doctor (correo, usuario, contraseña, nombre, especialidad, cedula, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement pst = conn.prepareStatement( sql );
            pst.setString(1, doctor.getCorreo());
            pst.setString(2, doctor.getUsuario());
            pst.setString(3, doctor.getContrasena());
            pst.setString(4, doctor.getNombre());
            pst.setString(5, doctor.getEspecialidad());
            pst.setString(6, doctor.getCedula());
            pst.setString(7, doctor.getTelefono());

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar el doctor" + e.getMessage());
        }
        return false;
    }

    public static List<Doctor> Read() {
        Connection conn = Conexion.conectarBD();
        String sql = "SELECT * FROM doctor";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( sql );
            List<Doctor> doctores = new ArrayList<Doctor>();
            while (rs.next()) {
                Doctor doctor = new Doctor();

                doctor.setId(rs.getInt("id"));
                doctor.setCorreo(rs.getString("correo"));
                doctor.setUsuario(rs.getString("usuario"));
                doctor.setContrasena(rs.getString("contraseña"));
                doctor.setNombre(rs.getString("nombre"));
                doctor.setEspecialidad(rs.getString("especialidad"));
                doctor.setCedula(rs.getString("cedula"));
                doctor.setTelefono(rs.getString("telefono"));

                doctores.add(doctor);
            }
            return doctores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean Update(Doctor doctor) {

        Connection conn = Conexion.conectarBD();
        String sql = "UPDATE doctor SET correo = ?, usuario = ?, contraseña = ?, nombre = ?, especialidad = ?, cedula = ?, telefono = ?  WHERE id = ? ";

        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, doctor.getCorreo());
            pst.setString(2, doctor.getUsuario());
            pst.setString(3, doctor.getContrasena());
            pst.setString(4, doctor.getNombre());
            pst.setString(5, doctor.getEspecialidad());
            pst.setString(6, doctor.getCedula());
            pst.setString(7, doctor.getTelefono());
            pst.setInt(8, doctor.getId());
            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el doctor");
        }
        return false;

    }

    public static boolean Delete(Doctor doctor) {

        Connection conn = Conexion.conectarBD();
        String sql = "DELETE FROM doctor WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, doctor.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el doctor");
        }
        return false;
    }
    public static Doctor loginDoctor(String usuario, String contrasena) {
        String sql = "SELECT * FROM doctor WHERE usuario = ? AND contraseña = ?";

        try (Connection conn = Conexion.conectarBD();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setString(2, contrasena);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setCorreo(resultSet.getString("correo"));
                doctor.setUsuario(resultSet.getString("usuario"));
                doctor.setContrasena(resultSet.getString("contraseña"));
                doctor.setNombre(resultSet.getString("nombre"));
                doctor.setEspecialidad(resultSet.getString("especialidad"));
                doctor.setCedula(resultSet.getString("cedula"));
                doctor.setTelefono(resultSet.getString("telefono"));

                return doctor;
            }

        } catch (SQLException e) {
            System.out.println("Error al autenticar al doctor: " + e.getMessage());
        }

        return null;
    }

}

