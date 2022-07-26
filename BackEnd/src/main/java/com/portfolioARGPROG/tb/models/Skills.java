package com.portfolioARGPROG.tb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSkill;
    private String nombreSkill;
    private String fotoSkill;
    private int porcentaje;
    private String colorExterno;
    private String colorInterno;


    public Skills() {
    }

    public Skills(Long idSkill, String nombreSkill, String fotoSkill, int porcentaje, String colorExterno, String colorInterno) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.fotoSkill = fotoSkill;
        this.porcentaje = porcentaje;
        this.colorExterno = colorExterno;
        this.colorInterno = colorInterno;
    }

    public Long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getFotoSkill() {
        return fotoSkill;
    }

    public void setFotoSkill(String fotoSkill) {
        this.fotoSkill = fotoSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getColorExterno() {
        return colorExterno;
    }

    public void setColorExterno(String colorExterno) {
        this.colorExterno = colorExterno;
    }

    public String getColorInterno() {
        return colorInterno;
    }

    public void setColorInterno(String colorInterno) {
        this.colorInterno = colorInterno;
    }
}
