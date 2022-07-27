package com.portfolioARGPROG.tb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProyecto;
    private String nombreProyecto;
    private String linkProyecto;
    private String imgProyecto;

    public Proyectos() {
    }

    public Proyectos(Long idProyecto, String nombreProyecto, String linkProyecto, String imgProyecto) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.linkProyecto = linkProyecto;
        this.imgProyecto = imgProyecto;
    }


    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getLinkProyecto() {
        return linkProyecto;
    }

    public void setLinkProyecto(String linkProyecto) {
        this.linkProyecto = linkProyecto;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }
}


