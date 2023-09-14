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
public class Correspondencia extends Documento{
    private String remitente;
    private String direccion;

    public Correspondencia(String remitente, String direccion, Integer idDoc, LocalDate fechaCreacion) {
        super(idDoc, fechaCreacion);
        this.remitente = remitente;
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.remitente);
        hash = 83 * hash + Objects.hashCode(this.direccion);
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
        final Correspondencia other = (Correspondencia) obj;
        if (!Objects.equals(this.remitente, other.remitente)) {
            return false;
        }
        return Objects.equals(this.direccion, other.direccion);
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
