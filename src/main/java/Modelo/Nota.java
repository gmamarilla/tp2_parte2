/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.Objects;

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
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nro);
        hash = 37 * hash + Objects.hashCode(this.anio);
        hash = 37 * hash + Objects.hashCode(this.asunto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.asunto, other.asunto)) {
            return false;
        }
        if (!Objects.equals(this.nro, other.nro)) {
            return false;
        }
        return Objects.equals(this.anio, other.anio);
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
