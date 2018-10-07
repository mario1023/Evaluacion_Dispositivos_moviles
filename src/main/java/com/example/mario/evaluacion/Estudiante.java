package com.example.mario.evaluacion;

import java.io.Serializable;

public class Estudiante implements Serializable {
    public String nombre;
    public String codigo;
    public String materia;
    public double parcial1;
    public double parcial2;
    public double parcial3;
    public double promedio;


    public Estudiante(String nombre, String codigo, String materia, double parcial1, double parcial2, double parcial3, double promedio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.materia = materia;
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.parcial3 = parcial3;
        this.promedio = promedio;
    }
}
