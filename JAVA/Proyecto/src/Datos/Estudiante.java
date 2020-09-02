package Datos;

public class Estudiante extends Persona{
    private Carrera carreraEstudiante;

    public Estudiante(String nombre, String apellido, int edad, long dni, Carrera carreraEstudiante) {
        super(nombre, apellido, edad, dni);
        this.carreraEstudiante = carreraEstudiante;
    }

    public Carrera getCarreraEstudiante() {
        return carreraEstudiante;
    }

    public void setCarreraEstudiante(Carrera carreraEstudiante) {
        this.carreraEstudiante = carreraEstudiante;
    }
}
