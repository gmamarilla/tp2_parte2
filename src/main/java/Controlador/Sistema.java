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
    
    //ABM DOCUMENTO
    
    public void crearMovimiento(Integer id, LocalDate fechaMov, Area areaDestino, Documento documento) throws Exception{
        Movimiento nuevoMovimiento;
        Area areaOrigen=this.areaDelDocumento(documento);
        
        if(!areas.contains(areaOrigen)){
            throw new Exception("Área de origen no existe.");
        }
        
        if(!areas.contains(areaDestino)){
            throw new Exception("Área de destino no existe.");
        }
        
        if(!existeDocumento(documento)){
            throw new Exception("El documento ID"+documento.getId()+" no se encuentra en el sistema.");
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
        
        if(existeDocumento(nuevoExpediente)){
            throw new Exception("Ya existe un documento con el ID #"+nro+" en el sistema.");
        }
        
        if(!existeArea(area)){
            throw new Exception("El área "+area.getNomArea()+" no existe.");
        }
        
        area.agregarDocumento(nuevoExpediente);
        
        documentos.put(nuevoExpediente.getId(), nuevoExpediente);
    }
    
    public void crearNota(Integer nro, Integer anio, String asunto,
                            Integer idDoc, LocalDate fechaCreacion, Area area) throws Exception{
        
        Nota nuevaNota=new Nota( nro, anio, asunto, idDoc, fechaCreacion);
        
        if(existeDocumento(nuevaNota)){
            throw new Exception("Ya existe un documento con el ID #"+nro+" en el sistema.");
        }
        
        if(!existeArea(area)){
            throw new Exception("El área "+area.getNomArea()+" no existe.");
        }
        
        area.agregarDocumento(nuevaNota);
        
        documentos.put(nuevaNota.getId(), nuevaNota);
    }
    
    public void crearCorrespondencia(String remitente, String direccion,
                                    Integer idDoc, LocalDate fechaCreacion, Area area) throws Exception{
        Correspondencia nuevaCorr;
        nuevaCorr=new Correspondencia(remitente, direccion, idDoc,  fechaCreacion);
        
        if(existeDocumento(nuevaCorr)){
            throw new Exception("Ya existe un documento con el ID #"+idDoc+" en el sistema.");
        }
        
        if(!existeArea(area)){
            throw new Exception("El área "+area.getNomArea()+" no existe.");
        }
        
        area.agregarDocumento(nuevaCorr);
        
        documentos.put(nuevaCorr.getId(), nuevaCorr);
    }
    
    public Documento buscarDocumento(int idDoc) throws Exception{
        if(!documentos.containsKey(idDoc)){
            throw new Exception("El documento ID"+idDoc+" no está cargado en el sistema.");
        }
        
        return documentos.get(idDoc);
    }
    
    public void borrarDocumento(Integer idDoc) throws Exception{
        Documento documento = documentos.get(idDoc);
        
        if(documento.tieneMovmientos()){
            throw new Exception("No se puede borrar un documento que tiene movimientos.");
        }
        
        documentos.remove(idDoc);
    }
    
    public boolean existeDocumento(Documento documento){
        if(documentos.isEmpty()){
            return false;
        }
        
        return documentos.containsKey(documento.getId());
    }
    
    //ABM AREA
    
    public Area crearArea(Integer id, String nomArea, String telefono) throws Exception{
        Area nuevaArea=new Area( id,  nomArea,  telefono);
        
        if(this.existeArea(nuevaArea)){
            throw new Exception("El área con el nombre "+nomArea+" ya existe en el sistema.");
        }
        
        areas.add(nuevaArea);
        
        return nuevaArea;
    }
    
    public Area buscarArea(String nombreArea) throws Exception{
        if(areas.isEmpty()){
            throw new Exception("El sistema no tiene áreas cargasdas.");
        }
        
        for(Area area:areas){
            if(area.getNomArea().equalsIgnoreCase(nombreArea)){
                return area;
            }
        }
        
        return null;
    }
    
    public void editarArea(Area area, String nomArea, String telefono) throws Exception{
        if(existeArea(area)){
            throw new Exception("El área "+area.getNomArea()+" no está cargada en el sistema.");
        }
        
        area.setNomArea(nomArea);
        area.setTelefono(telefono);
    }
    
    public void borrarArea(Area area) throws Exception{
        if(area.tieneDocumentos()){
            throw new Exception("No se puede borrar un área que tiene documentos cargados.");
        }
        
        areas.remove(area);
    }
    
    public boolean existeArea(Area area){
        if(areas.isEmpty()){
            return false;
        }
        
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
    
    public ArrayList<Documento> buscarDocumentosPorFecha(LocalDate fecha) throws Exception{
        ArrayList<Documento> busqueda=new ArrayList();
        
        if(documentos.isEmpty()){
            throw new Exception("El sistema no tiene documentos cargados.");
        }
        
        this.documentos.forEach((Integer key,Documento documento)->{
            
            if(documento.getFechaCreacion().equals(fecha)){
                busqueda.add(documento);
            }
        });
        
        return busqueda;
    }
}
