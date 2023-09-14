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
public class Expediente extends Documento{
    private Integer nro;
    private String letra;
    private Integer anio;
    private String anexo;

    public Expediente(Integer nroExpte, String letra, Integer anio, String anexo, Integer idDoc, LocalDate fechaCreacion) {
        super(idDoc, fechaCreacion);
        this.nro = nroExpte;
        this.letra = letra;
        this.anio = anio;
        this.anexo = anexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nro);
        hash = 47 * hash + Objects.hashCode(this.letra);
        hash = 47 * hash + Objects.hashCode(this.anio);
        hash = 47 * hash + Objects.hashCode(this.anexo);
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
        final Expediente other = (Expediente) obj;
        if (!Objects.equals(this.letra, other.letra)) {
            return false;
        }
        if (!Objects.equals(this.anexo, other.anexo)) {
            return false;
        }
        if (!Objects.equals(this.nro, other.nro)) {
            return false;
        }
        return Objects.equals(this.anio, other.anio);
    }
    
    @Override
    public String toString(){
        return super.toString()+", "+nro+", "+letra+", "+anio+", "+anexo;
    }
    
    //setters

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }
    
    //getters

    public Integer getNro() {
        return nro;
    }

    public String getLetra() {
        return letra;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getAnexo() {
        return anexo;
    }
}
