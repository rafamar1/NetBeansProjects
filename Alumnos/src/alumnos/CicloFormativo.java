/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.util.ArrayList;

/**
 *
 * @author RafaMar
 */
public class CicloFormativo {

    private String nombreCiclo;

    private ArrayList<String> listaModulos;

    private int años;

    private int maximoAlumnos;

    private ArrayList<Alumno> listaAlumnos;

    public CicloFormativo(String nombreCiclo, int años, int maximoAlumnos) {
        this.nombreCiclo = nombreCiclo;
        this.años = años;
        this.maximoAlumnos = maximoAlumnos;
        listaModulos = new ArrayList();
        listaAlumnos = new ArrayList();
    }

    public CicloFormativo(String nombreCiclo, int años, int maximoAlumnos, ArrayList<String> listaModulos) {
        this(nombreCiclo, años, maximoAlumnos);
        this.listaModulos = listaModulos;
    }

    public CicloFormativo(String nombreCiclo, ArrayList<String> listaModulos, int años, int maximoAlumnos, ArrayList<Alumno> listaAlumnos) {
        this(nombreCiclo, años, maximoAlumnos, listaModulos);
        this.listaAlumnos = listaAlumnos;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public ArrayList<String> getListaModulos() {
        return listaModulos;
    }

    public String listadoCiclo() {
        return "-Nombre del Ciclo: " + nombreCiclo + "\n-Duración: " + años + " años"
                + "\n-Máximo de Alumnos" + maximoAlumnos + "\n" + listarModulos();
    }

    public void setListaModulos(ArrayList<String> listaModulos) {
        this.listaModulos = listaModulos;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public int getMaximoAlumnos() {
        return maximoAlumnos;
    }

    public void setMaximoAlumnos(int maximoAlumnos) {
        this.maximoAlumnos = maximoAlumnos;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public boolean compruebaMaximo() {
        return listaAlumnos.size() != this.maximoAlumnos;
        
    }

    public void matriculaAlumno(Alumno alumno) {
        this.listaAlumnos.add(alumno);
     }

    public String listarAlumnos() {
        String salida = "";
        for (Alumno alumno : listaAlumnos) {
            salida += alumno.toString();
        }
        return salida;
    }

    private String listarModulos() {
        String salida = "\t-Modulo(s) que lo componen";
        int contador = 1;
        for (String modulo : listaModulos) {
            salida += "\n\t" + contador + "-." + modulo;
            contador++;
        }
        return salida;
    }
}
