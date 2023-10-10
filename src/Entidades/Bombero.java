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
public class Bombero {
    private int id_bombero;
    private String dni;
    private String nombre_ape;
    private String grupoSangineo;
    private LocalDate fecha_nac;
    private String celular;
    private Brigada brigada;
    
    public Bombero(){
    }

    public Bombero(int id_bombero, String dni, String nombre_ape, String grupoSangineo, LocalDate fecha_nac, String celular, Brigada brigada) {
        this.id_bombero = id_bombero;
        this.dni = dni;
        this.nombre_ape = nombre_ape;
        this.grupoSangineo = grupoSangineo;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.brigada = brigada;
    }

    public Bombero(String dni, String nombre_ape, String grupoSangineo, LocalDate fecha_nac, String celular, Brigada brigada) {
        this.dni = dni;
        this.nombre_ape = nombre_ape;
        this.grupoSangineo = grupoSangineo;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.brigada = brigada;
    }
    
    
    public int getIdBombero() {
        return id_bombero;
    }

    public void setIdBombero(int idBombero) {
        this.id_bombero = id_bombero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombrecompleto() {
        return nombre_ape;
    }

    public void setNombrecompleto(String nombre_ape) {
        this.nombre_ape = nombre_ape;
    }

    public String getGrupoSangineo() {
        return grupoSangineo;
    }

    public void setGrupoSangineo(String grupoSangineo) {
        this.grupoSangineo = grupoSangineo;
    }

    public LocalDate getFechaNac() {
        return fecha_nac;
    }

    public void setFechaNac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }
    
    
}
