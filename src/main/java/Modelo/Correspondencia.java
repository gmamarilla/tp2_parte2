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
public class Correspondencia extends Documento{
    private String remitente;
    private String direccion;

    public Correspondencia(String remitente, String direccion, Integer idDoc, LocalDate fechaCreacion) {
        super(idDoc, fechaCreacion);
        this.remitente = remitente;
        this.direccion = direccion;
    }
    
    public String toString(){
        return super.toString()+", "+remitente+", "+direccion;
    }
    
    //setters

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    //getters

    public String getRemitente() {
        return remitente;
    }

    public String getDireccion() {
        return direccion;
    }
}
