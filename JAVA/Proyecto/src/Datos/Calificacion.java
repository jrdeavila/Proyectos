package Datos;
import java.io.Serializable;
import java.util.List;
public class Calificacion implements Serializable {
    private List<Double> notas;
    private Estudiante estudiante;

    public Calificacion(List<Double> notas, Estudiante estudiante) {
        this.notas = notas;
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }


}
