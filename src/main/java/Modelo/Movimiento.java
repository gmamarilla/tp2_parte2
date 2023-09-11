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
