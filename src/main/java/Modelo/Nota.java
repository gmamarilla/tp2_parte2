/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Gustavo
 */
public class Nota extends Documento{
    private Integer nro;
    private Integer anio;
    private String asunto;

    public Nota(Integer nro, Integer anio, String asunto, Integer idDoc, LocalDate fechaCreacion) {
        super(idDoc, fechaCreacion);
        this.nro = nro;
        this.anio = anio;
        this.asunto = asunto;
    }
    
    @Override
    public String toString(){
        return super.toString()+", "+nro+", "+anio+", "+asunto;
    }
    
    //setters

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    //getters

    public Integer getNro() {
        return nro;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getAsunto() {
        return asunto;
    }
}
