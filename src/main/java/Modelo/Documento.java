/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

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
    
    //funsionalidades
    
    public void agregarMovimiento(Movimiento movimiento) throws Exception{
        if(tieneMovimiento(movimiento)){
            throw new Exception("El movimiento ID"+movimiento.getId()+" ya está cargado en el sistema.");
        }
        
        this.movimientos.add(movimiento);
    }
    
    public Movimiento buscarMovimiento(Integer idMov) throws Exception{
        Movimiento movimiento=null;
        
        if(movimientos.isEmpty()){
            throw new Exception("Este documento no tiene movimientos cargados.");
        }
        
        for(Movimiento mov:movimientos){
            if(mov.getId().equals(idMov)){
                movimiento = mov;
            }
        }
        
        return movimiento;
    }
    
    public void quitarMovimiento(Movimiento movimiento) throws Exception{
        if(!tieneMovimiento(movimiento)){
            throw new Exception("El documento ID"+this.getId()+" no tiene el movimiento ID"+movimiento.getId());
        }
        
        for(Movimiento mov:movimientos){
            if(mov.equals(movimiento)){
                movimientos.remove(movimiento);
                break;
            }
        }
    }
    
    public boolean tieneMovmientos(){
        return !movimientos.isEmpty();
    }
    
    public boolean tieneMovimiento(Movimiento movimiento){
        if(movimientos.isEmpty()){
            return false;
        }
        
        return movimientos.contains(movimiento);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 19 * hash + Objects.hashCode(this.movimientos);
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
        final Documento other = (Documento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        return Objects.equals(this.movimientos, other.movimientos);
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
