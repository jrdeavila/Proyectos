package Datos;

import java.awt.*;
import java.io.Serializable;

public class Semestre implements Serializable {
    private Pensum pensumSemestre;
    private int posicionSemestral;

    public Semestre(Pensum pensumSemestre, int posicionSemestral) {
        this.pensumSemestre = pensumSemestre;
        this.posicionSemestral = posicionSemestral;
    }

    public Pensum getPensumSemestre() {
        return pensumSemestre;
    }

    public void setPensumSemestre(Pensum pensumSemestre) {
        this.pensumSemestre = pensumSemestre;
    }

    public int getPosicionSemestral() {
        return posicionSemestral;
    }

    public void setPosicionSemestral(int posicionSemestral) {
        this.posicionSemestral = posicionSemestral;
    }
}
