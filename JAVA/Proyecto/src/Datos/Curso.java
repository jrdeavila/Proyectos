package Datos;

import java.io.Serializable;
import java.util.List;

public class Curso implements Serializable {
    private Asignatura asignatura;
    private List<Calificacion> estudiantesNotas;

    public Curso(Asignatura asignatura, List<Calificacion> estudiantesNotas) {
        this.asignatura = asignatura;
        this.estudiantesNotas = estudiantesNotas;
    }

    public List<Calificacion> getEstudiantesNotas() {
        return estudiantesNotas;
    }

    public void setEstudiantesNotas(List<Calificacion> estudiantesNotas) {
        this.estudiantesNotas = estudiantesNotas;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
