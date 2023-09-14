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
public class Movimiento {
    private Integer id;
    private LocalDate fechaMov;
    private Area areaOrigen;
    private Area areaDestino;

    public Movimiento(Integer id, LocalDate fechaMov, Area areaOrigen, Area areaDestino) {
        this.id = id;
        this.fechaMov = fechaMov;
        this.areaOrigen = areaOrigen;
        this.areaDestino = areaDestino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.fechaMov);
        hash = 41 * hash + Objects.hashCode(this.areaOrigen);
        hash = 41 * hash + Objects.hashCode(this.areaDestino);
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
        final Movimiento other = (Movimiento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaMov, other.fechaMov)) {
            return false;
        }
        if (!Objects.equals(this.areaOrigen, other.areaOrigen)) {
            return false;
        }
        return Objects.equals(this.areaDestino, other.areaDestino);
    }
    
    //getters & setters

    public Integer getId() {
        return id;
    }

    public LocalDate getFechaMov() {
        return fechaMov;
    }

    public Area getAreaOrigen() {
        return areaOrigen;
    }

    public Area getAreaDestino() {
        return areaDestino;
    }
}
