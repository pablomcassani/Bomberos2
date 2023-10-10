/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author nacho
 */
public class Brigada {
    private int codBrigada;
    private String nombreBr;
    private String especialidad;
    private boolean libre;
    private Cuartel cuartel;
    
    public Brigada(){
    }

    public Brigada(int codBrigada, String nombreBr, String especialidad, boolean libre, Cuartel cuartel) {
        this.codBrigada = codBrigada;
        this.nombreBr = nombreBr;
        this.especialidad = especialidad;
        this.libre = libre;
        this.cuartel = cuartel;
    }

    public Brigada(String nombreBr, String especialidad, boolean libre, Cuartel cuartel) {
        this.nombreBr = nombreBr;
        this.especialidad = especialidad;
        this.libre = libre;
        this.cuartel = cuartel;
    }
    
    
    public int getcodBrigada() {
        return codBrigada;
    }

    public void setcodBrigada(int codBrigada) {
        this.codBrigada = codBrigada;
    }

    public String getNombreBr() {
        return nombreBr;
    }

    public void setNombreBr(String nombreBr) {
        this.nombreBr = nombreBr;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public Cuartel getCuartel() {
        return cuartel;
    }

    public void setCuartel(Cuartel cuartel) {
        this.cuartel = cuartel;
    }
    
}
