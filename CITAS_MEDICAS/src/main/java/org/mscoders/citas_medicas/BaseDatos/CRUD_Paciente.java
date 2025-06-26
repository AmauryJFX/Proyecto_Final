package org.mscoders.citas_medicas.BaseDatos;

import org.mscoders.citas_medicas.Conexion;
import org.mscoders.citas_medicas.model.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Paciente {

    public static boolean Create(Paciente paciente) {
        Connection conn = Conexion.conectarBD();

        String sql = "INSERT INTO paciente (correo, usuario, contrasena, nombre, nacimiento, telefono, his_medico_id) VALUES (?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = conn.prepareStatement( sql );
            pst.setString(1, paciente.getCorreo());
            pst.setString(2, paciente.getUsuario());
            pst.setString(3, paciente.getContrasena());
            pst.setString(4, paciente.getNombre());
            pst.setDate(5, java.sql.Date.valueOf(paciente.getNacimiento()));
            pst.setString(6, paciente.getTelefono());
            pst.setInt(7, paciente.getHis_medico_id());

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar el paciente");
        }
        return false;
    }

    public static List<Paciente> Read() {
        Connection conn = Conexion.conectarBD();
        String sql = "SELECT * FROM paciente";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery( sql );
            List<Paciente> pacientes = new ArrayList<Paciente>();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setCorreo(rs.getString("correo"));
                paciente.setUsuario(rs.getString("usuario"));
                paciente.setContrasena(rs.getString("contrasena"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setHis_medico_id(rs.getInt("his_medico_id"));

                pacientes.add(paciente);
            }
            return pacientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean Update(Paciente paciente) {
        Connection conn = Conexion.conectarBD();
        String sql = "UPDATE paciente SET correo = ?, usuario = ?, contrasena = ?, nombre = ?, nacimiento = ?, telefono = ?, his_medico_id = ? WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, paciente.getCorreo());
            pst.setString(2, paciente.getUsuario());
            pst.setString(3, paciente.getContrasena());
            pst.setString(4, paciente.getNombre());
            pst.setDate(5, java.sql.Date.valueOf(paciente.getNacimiento()));
            pst.setString(6, paciente.getTelefono());
            pst.setInt(7, paciente.getHis_medico_id());
            pst.setInt(8, paciente.getId());

            pst.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el paciente");
        }
        return false;
    }


    public static boolean Delete(Paciente paciente) {
        Connection conn = Conexion.conectarBD();
        String sql = "DELETE FROM paciente WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, paciente.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el paciente");
        }
        return false;
    }

    public static Paciente loginPaciente(String usuario, String contrasena) {
        String sql = "SELECT * FROM paciente WHERE usuario = ? AND contrasena = ?";

        try (Connection conn = Conexion.conectarBD();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, usuario);
            pst.setString(2, contrasena);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(resultSet.getInt("id"));
                paciente.setCorreo(resultSet.getString("correo"));
                paciente.setUsuario(resultSet.getString("usuario"));
                paciente.setContrasena(resultSet.getString("contrasena"));
                paciente.setNombre(resultSet.getString("nombre"));
                paciente.setNacimiento(resultSet.getDate("nacimiento").toLocalDate());
                paciente.setTelefono(resultSet.getString("telefono"));
                paciente.setHis_medico_id(resultSet.getInt("his_medico_id"));

                return paciente;
            }

        } catch (SQLException e) {
            System.out.println("Error al autenticar al paciente");
            e.printStackTrace();
        }

        return null;
    }
}