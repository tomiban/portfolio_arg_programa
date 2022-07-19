package comportfolioARGPROG.tb.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cursos {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long idCurso;
        private String tituloCurso;
        private int fechaCurso;
        private String descripcionCurso;
        private String imagenCurso;

        private String enlaceCurso;

        public Cursos() {
        }

        public Cursos(Long idCurso, String tituloCurso, int fechaCurso, String descripcionCurso, String imagenCurso, String enlaceCurso) {
            this.idCurso = idCurso;
            this.tituloCurso = tituloCurso;
            this.fechaCurso = fechaCurso;
            this.descripcionCurso = descripcionCurso;
            this.imagenCurso = imagenCurso;
            this.enlaceCurso = enlaceCurso;
        }


    public Long getIdCurso() {
            return idCurso;
        }

        public void setIdCurso(Long idCurso) {
            this.idCurso = idCurso;
        }

        public String getTituloCurso() {
            return tituloCurso;
        }

        public void setTituloCurso(String tituloCurso) {
            this.tituloCurso = tituloCurso;
        }

        public int getFechaCurso() {
            return fechaCurso;
        }

        public void setFechaCurso(int fechaCurso) {
            this.fechaCurso = fechaCurso;
        }

        public String getDescripcionCurso() {
            return descripcionCurso;
        }

        public void setDescripcionCurso(String descripcionCurso) {
            this.descripcionCurso = descripcionCurso;
        }

        public String getImagenCurso() {
            return imagenCurso;
        }

        public void setImagenCurso(String imagenCurso) {
            this.imagenCurso = imagenCurso;
        }

    public String getEnlaceCurso() {
        return enlaceCurso;
    }

    public void setEnlaceCurso(String enlaceCurso) {
        this.enlaceCurso = enlaceCurso;
    }

}
