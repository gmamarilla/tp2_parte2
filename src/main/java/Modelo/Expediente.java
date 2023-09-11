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
