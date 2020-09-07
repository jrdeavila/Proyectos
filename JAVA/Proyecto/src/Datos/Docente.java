package Datos;
import java.util.List;

public class Docente extends Persona{
    private  List<Curso> asignaturasDictadas;

    public Docente(String nombre, String apellido, int edad, long dni, List<Curso> asignaturasDictadas) {
        super(nombre, apellido, edad, dni);
        this.asignaturasDictadas = asignaturasDictadas;
    }

    public List<Curso> getAsignaturasDictadas() {
        return asignaturasDictadas;
    }

    public void setAsignaturasDictadas(List<Curso> asignaturasDictadas) {
        this.asignaturasDictadas = asignaturasDictadas;
    }
}
