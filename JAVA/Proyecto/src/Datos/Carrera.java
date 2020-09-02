package Datos;
import java.io.Serializable;
import java.util.List;

public class Carrera implements Serializable {
    private String nombre, mision, vision;
    private List<String> objetivosGenerales, objetivosEspecificos;
    private List<Semestre> semestres;

    public Carrera(String nombre, String mision, String vision, List<String> objetivosGenerales, List<String> objetivosEspecificos, List<Semestre> semestres) {
        this.nombre = nombre;
        this.mision = mision;
        this.vision = vision;
        this.objetivosGenerales = objetivosGenerales;
        this.objetivosEspecificos = objetivosEspecificos;
        this.semestres = semestres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public List<String> getObjetivosGenerales() {
        return objetivosGenerales;
    }

    public void setObjetivosGenerales(List<String> objetivosGenerales) {
        this.objetivosGenerales = objetivosGenerales;
    }

    public List<String> getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public void setObjetivosEspecificos(List<String> objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }
}
