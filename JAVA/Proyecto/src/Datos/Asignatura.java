package Datos;

import java.io.Serializable;
import java.util.List;

public class Asignatura implements Serializable {
    private String nombre;
    private List<String> objetivosGenerales, objetivosEspecificos;
    private int creditos;

    public Asignatura(String nombre, List<String> objetivosGenerales, List<String> objetivosEspecificos, int creditos) {
        this.nombre = nombre;
        this.objetivosGenerales = objetivosGenerales;
        this.objetivosEspecificos = objetivosEspecificos;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
