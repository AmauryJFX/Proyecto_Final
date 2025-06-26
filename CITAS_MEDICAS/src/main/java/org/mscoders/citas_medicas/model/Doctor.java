package org.mscoders.citas_medicas.model;

public class Doctor {

    private Integer id;

    private String correo; // -- Max. 60 -- \\

    private String usuario; // -- Max. 30 -- \\

    private String contrasena; // -- Max. 15 -- \\

    private String nombre; // -- Max. 60 -- \\

    private String especialidad; // -- Max. 45 -- \\

    private String cedula; // -- Max. 8 -- \\

    private String telefono; // -- Max. 10 -- \\

    public Doctor() {
    }

    public Doctor(Integer id, String correo, String usuario, String contrasena, String nombre, String especialidad, String cedula, String telefono) {
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.telefono = telefono;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
