/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author nacho
 */
public class Siniestro {
    private int idSiniestro;
    private String tipo;
    private LocalDate fechaSiniestro;
    private int coordX;
    private int coordY;
    private String detalles;
    private LocalDate fechaResol;
    private int puntuacion;
    private Brigada brigada;
    
    public Siniestro(){
    }

    public Siniestro(int idSiniestro, String tipo, LocalDate fechaSiniestro, int coordX, int coordY, String detalles, LocalDate fechaResol, int puntuacion, Brigada brigada) {
        this.idSiniestro = idSiniestro;
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResol = fechaResol;
        this.puntuacion = puntuacion;
        this.brigada = brigada;
    }

    public Siniestro(String tipo, LocalDate fechaSiniestro, int coordX, int coordY, String detalles, LocalDate fechaResol, int puntuacion, Brigada brigada) {
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResol = fechaResol;
        this.puntuacion = puntuacion;
        this.brigada = brigada;
    }
    
    
    public int getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(int idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(LocalDate fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

   
    public LocalDate getFechaResol() {
        return fechaResol;
    }

    public void setFechaResol(LocalDate fechaResol) {
        this.fechaResol = fechaResol;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }
    
    
}
