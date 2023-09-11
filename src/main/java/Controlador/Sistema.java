/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gustavo
 */
public class Sistema {
    private ArrayList<Movimiento> movimientos;
    private HashMap<Integer,Documento> documentos;
    private ArrayList<Area> areas;

    public Sistema() {
        this.movimientos=new ArrayList();
        this.documentos=new HashMap();
        this.areas=new ArrayList();
    }
    
    //funcionalidades
    
    public void crearMovimiento(Integer id, LocalDate fechaMov, Area areaDestino, Documento documento) throws Exception{
        Movimiento nuevoMovimiento;
        Area areaOrigen=this.areaDelDocumento(documento);
        
        if(areaOrigen==null){
            throw new Exception("El documento no está cargado en el sistema.");
        }
        
        if(!this.areas.contains(areaDestino)){
            throw new Exception("Área de destino no existe.");
        }
        
        if(!this.documentos.containsKey(documento.getId())){
            throw new Exception("El documento no se encuentra en el sistema.");
        }
        
        if(areaOrigen.equals(areaDestino)){
            throw new Exception("El área de destino debe ser distinta del área de origen del documento.");
        }
        
        nuevoMovimiento=new Movimiento(id, fechaMov, areaOrigen, areaDestino);
        
        areaOrigen.quitarDocumento(documento);
        areaDestino.agregarDocumento(documento);
        
        documento.agregarMovimiento(nuevoMovimiento);
        
        movimientos.add(nuevoMovimiento);
    }
    
    public void crearExpediente(Integer nro, String letra, Integer anio, String anexo,
                                Integer idDoc, LocalDate fechaCreacion, Area area) throws Exception{
        
        Expediente nuevoExpediente=new Expediente(nro, letra, anio, anexo, idDoc, fechaCreacion);
        
        if(this.existeDocumento(nuevoExpediente)){
            throw new Exception("Ya existe un documento con el ID #"+nro+" en el sistema.");
        }
        
        if(!this.existeArea(area)){
            throw new Exception("El área "+area.getNomArea()+" no existe.");
        }
        
        area.agregarDocumento(nuevoExpediente);
        
        documentos.put(nuevoExpediente.getId(), nuevoExpediente);
    }
    
    public void crearNota(Integer nro, Integer anio, String asunto,
                            Integer idDoc, LocalDate fechaCreacion, Area area) throws Exception{
        
        Nota nuevaNota=new Nota( nro, anio, asunto, idDoc, fechaCreacion);
        
        if(this.existeDocumento(nuevaNota)){
            throw new Exception("Ya existe un documento con el ID #"+nro+" en el sistema.");
        }
        
        if(!this.existeArea(area)){
            throw new Exception("El área "+area.getNomArea()+" no existe.");
        }
        
        area.agregarDocumento(nuevaNota);
        
        documentos.put(nuevaNota.getId(), nuevaNota);
    }
    
    public void crearCorrespondencia(String remitente, String direccion,
                                    Integer idDoc, LocalDate fechaCreacion, Area area) throws Exception{
        Correspondencia nuevaCorr;
        
        if(this.buscarDocumento(idDoc)!=null){
            throw new Exception("Ya existe un documento con el ID #"+idDoc+" en el sistema.");
        }
        
        if(!areas.contains(area)){
            throw new Exception("El área "+area.getNomArea()+" no existe.");
        }
        
        nuevaCorr=new Correspondencia(remitente, direccion, idDoc,  fechaCreacion);
        
        area.agregarDocumento(nuevaCorr);
        
        documentos.put(nuevaCorr.getId(), nuevaCorr);
    }
    
    public boolean existeDocumento(Documento documento){
        return this.documentos.containsKey(documento.getId());
    }
    
    public Area buscarArea(String nombreArea){
        
        for(Area area:areas){
            if(area.getNomArea().equalsIgnoreCase(nombreArea)){
                return area;
            }
        }
        
        return null;
    }
    
    public Area crearArea(Integer id, String nomArea, String telefono) throws Exception{
        Area nuevaArea=new Area( id,  nomArea,  telefono);
        
        if(this.existeArea(nuevaArea)){
            throw new Exception("El área con el nombre "+nomArea+" ya existe en el sistema.");
        }
        
        areas.add(nuevaArea);
        
        return nuevaArea;
    }
    
    public boolean existeArea(Area area){
        return areas.contains(area);
    }
    
    public Area areaDelDocumento(Documento documento) throws Exception{
        for(Area area:areas){
            if(area.tieneDocumento(documento)){
                return area;
            }
        }
        
        return null;
    }
    
    public Documento buscarDocumento(int idDoc){
        return documentos.get(idDoc);
    }
    
    public ArrayList<Documento> buscarDocumentosPorFecha(LocalDate fecha){
        ArrayList<Documento> busqueda=new ArrayList();
        
        this.documentos.forEach((Integer key,Documento documento)->{
            
            if(documento.getFechaCreacion().equals(fecha)){
                busqueda.add(documento);
            }
        });
        
        return busqueda;
    }
}
