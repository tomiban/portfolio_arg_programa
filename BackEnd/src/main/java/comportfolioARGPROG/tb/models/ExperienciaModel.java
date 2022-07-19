package comportfolioARGPROG.tb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ExperienciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExp;
    private String tituloExp;
    private int fechaExp;
    private String descripcionExp;

    public ExperienciaModel() {
    }

    public ExperienciaModel(Long idExp, String tituloExp, int fechaExp, String descripcionExp) {
        this.idExp = idExp;
        this.tituloExp = tituloExp;
        this.fechaExp = fechaExp;
        this.descripcionExp = descripcionExp;
    }

    public Long getIdExp() {
        return idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
    }

    public String getTituloExp() {
        return tituloExp;
    }

    public void setTituloExp(String tituloExp) {
        this.tituloExp = tituloExp;
    }

    public int getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(int fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

}
