/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Vista;


import Controlador.Sistema;
import Modelo.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Tp2_parte2 {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Area area1, area2;
        ArrayList<Documento> docsPorFecha;
        LocalDate fecha;
        
        try{
            area1 = sistema.crearArea(1, "Compras", "1234");
            area2 = sistema.crearArea(1, "Ventas", "5678");
            
            sistema.crearExpediente(1, "A", 2020, "Anexo 1", 10, LocalDate.of(2020,1,8), area1);
            sistema.crearExpediente(2, "A", 2021, "Anexo 1", 11, LocalDate.of(2021,1,8), area1);
            
            sistema.crearNota(3, 2020, "Entrega documentos", 30, LocalDate.of(2020,1,8), area2);
            sistema.crearNota(4, 2020, "Entrega documentos", 32, LocalDate.of(2020,1,19), area2);
            
            sistema.crearCorrespondencia("Marcos", "Su casa", 70, LocalDate.of(2020,1,8), area2);
            sistema.crearCorrespondencia("Carla", "La Placita", 73, LocalDate.of(2020,1,8), area2);
            
            fecha=LocalDate.of(2020, 1, 8);
            
            docsPorFecha=sistema.buscarDocumentosPorFecha(fecha);
            
            if(docsPorFecha.isEmpty()){
                System.out.println("No se encontraron documentos para la fecha "+fecha);
            }else{
                for(Documento documento:docsPorFecha){
                    System.out.println(documento);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
