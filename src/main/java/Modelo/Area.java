/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Gustavo
 */
public class Area {
    private Integer id;
    private String nomArea;
    private String telefono;
    
    private HashMap<Integer,Documento> documentos;

    public Area(Integer id, String nomArea, String telefono) {
        this.id = id;
        this.nomArea = nomArea;
        this.telefono = telefono;
        
        this.documentos=new HashMap();
    }
    
    //funcionalidades
    
    public void agregarDocumento(Documento documento) throws Exception{
        if(tieneDocumento(documento)){
            throw new Exception("El documento ID"+documento.getId()+" ya está cargado en el sistema.");
        }
        
        documentos.put(documento.getId(), documento);
    }
    
    public Documento buscarDocumento(Integer idDoc) throws Exception{
        if(!tieneDocumento(id)){
            throw new Exception("El documento ID"+idDoc+" no existe en el sistema.");
        }
        
        return documentos.get(idDoc);
    }
    
    public void quitarDocumento(Documento documento) throws Exception{
        if(!tieneDocumento(documento)){
            throw new Exception("El documento no está cargado en el sistmea.");
        }
        
        documentos.remove(documento.getId());
    }
    
    public boolean tieneDocumentos(){
        return !documentos.isEmpty();
    }
    
    public boolean tieneDocumento(Documento documento){
        if(documentos.isEmpty()){
            return false;
        }
        
        return documentos.containsKey(documento.getId());
    }
    
    public boolean tieneDocumento(Integer idDoc){
        if(documentos.isEmpty()){
            return false;
        }
        
        return documentos.containsKey(idDoc);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nomArea);
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
        final Area other = (Area) obj;
        return Objects.equals(this.nomArea, other.nomArea);
    }
    
    //setters

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //getters

    public Integer getId() {
        return id;
    }

    public String getNomArea() {
        return nomArea;
    }

    public String getTelefono() {
        return telefono;
    }
}
