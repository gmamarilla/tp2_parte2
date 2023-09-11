/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Documento {
    private Integer id;
    private LocalDate fechaCreacion;
    
    private ArrayList<Movimiento> movimientos;

    public Documento(Integer idDoc, LocalDate fechaCreacion) {
        this.id = idDoc;
        this.fechaCreacion = fechaCreacion;
        this.movimientos=new ArrayList();
    }
    
    public void agregarMovimiento(Movimiento movimiento){
        this.movimientos.add(movimiento);
    }
    
    @Override
    public String toString(){
        return id+", "+fechaCreacion;
    }
    
    //getters

    public Integer getId() {
        return id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
}
