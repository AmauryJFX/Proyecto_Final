package org.mscoders.citas_medicas.model;

import java.time.LocalDate;

public class Paciente {

    private Integer id;

    private String correo; // -- Max. 60 -- \\

    private String usuario; // -- Max. 30 -- \\

    private String contrasena; // -- Max. 15 -- \\

    private String nombre; // -- Max. 60 -- \\

    private LocalDate nacimiento;

    private String telefono; // -- Max. 10 -- \\

    private Integer his_medico_id;

    public Paciente() {
    }

    public Paciente(Integer id, String correo, String usuario, String contrasena, String nombre, LocalDate nacimiento, String telefono, Integer his_medico_id) {
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.his_medico_id = his_medico_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getHis_medico_id() {
        return his_medico_id;
    }

    public void setHis_medico_id(Integer his_medico_id) {
        this.his_medico_id = his_medico_id;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", telefono='" + telefono + '\'' +
                ", his_medico_id=" + his_medico_id +
                '}';
    }
}
