package org.mscoders.citas_medicas.model;

public class His_Medico {

    private Integer id;

    private String alergia; // -- Max. 150 -- \\

    private String antecedente; // -- Max. 150 -- \\




    public His_Medico() {
    }

    public His_Medico(Integer id, String alergia, String antecedente) {
        this.id = id;
        this.alergia = alergia;
        this.antecedente = antecedente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    @Override
    public String toString() {
        return "His_Medico{" +
                "id=" + id +
                ", alergia='" + alergia + '\'' +
                ", antecedente='" + antecedente + '\'' +
                '}';
    }
}
