package org.mscoders.citas_medicas.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private Integer id;

    private String motivo; // -- Max. 60 -- \\

    private LocalDate fecha;

    private LocalTime hora;

    private String estado; // -- Max. 15 -- \\

    private Integer doctor_id;

    private Integer paciente_id;

    public Cita() {
    }

    public Cita(Integer id, String motivo, LocalDate fecha, LocalTime hora, String estado, Integer doctor_id, Integer paciente_id) {
        this.id = id;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.doctor_id = doctor_id;
        this.paciente_id = paciente_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Integer getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Integer paciente_id) {
        this.paciente_id = paciente_id;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", motivo='" + motivo + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", estado='" + estado + '\'' +
                ", doctor_id=" + doctor_id +
                ", paciente_id=" + paciente_id +
                '}';
    }
}
