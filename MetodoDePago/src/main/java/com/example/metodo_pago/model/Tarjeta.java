/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.model;

/**
 * 
 * Dominio que representa las reglas de negocio de una tarjeta de pago.
 * 
 * Diseñado mediante Value Objects inmutables por naturaleza para garantizar
 * que se cumplan las invariantes críticas de negocio y se evite el abuso de tipos de datos.

 * Este modelo se valida antes de cualquier operación de persistencia.
 */

import java.time.YearMonth;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
// La identidad de la tarjeta se basa exclusivamente en el número, ya que es el identificador
// natural dentro del dominio.
@EqualsAndHashCode(of = "numeroTarjeta")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Tarjeta {
     @NonNull
     private NumeroTarjeta numeroTarjeta;
     
     @NonNull 
     private Titular titular;
     

     @NonNull
     private Fecha expiracion;
             
     @NonNull 
     public Cvc cvc;
     
     
     
     public Tarjeta(String numeroTarjeta, String titular, YearMonth expiracion, String cvc){
         
         
         this(new NumeroTarjeta(numeroTarjeta), 
                 new Titular(titular), 
                 new Fecha(expiracion), 
                 new Cvc(cvc)
                 
                 
                 
         );
         
     }
     
     

    public String numeroTarjeta() {
        return "************" + numeroTarjeta.getNumeroTarjeta().substring(12);
    }

    public String titular() {
        return titular.getTitular();
    }

    public YearMonth expiracion() {
        return expiracion.getExpiracion();
    }


    
    public String cvc() {
        return cvc.getCvc();
    }
     
}   

/** Se usa la anotación @Value de lombok para generar automaticamente clases inmutables*/ 

@Value 
class NumeroTarjeta{
    @NonNull String numeroTarjeta;
            
    NumeroTarjeta(String numeroTarjeta){        
            if (!numeroTarjeta.matches("^\\d{4}(\\d{4}){3}$")){
                throw new IllegalArgumentException("Numero de tarjeta no valido.");
        }
            
        this.numeroTarjeta = numeroTarjeta;
    }
 
}
 
@Value
class Titular{
    @NonNull String titular;
    
    Titular(String titular){
        if (!titular.matches("^[A-Z][a-zñáéíóúü]+ [A-Z][a-zñáéíóúü]+$")){
            throw new IllegalArgumentException("Titular debe tener apellido y nombre.");
        }
        
        this.titular = titular;
            
    }
 }        



@Value
class Fecha{
    @NonNull YearMonth expiracion;
    
    
    Fecha(YearMonth fechaExpiracion){
        if(fechaExpiracion.isBefore(YearMonth.now())){
            throw new IllegalArgumentException("La tarjeta debe estar vigente.");
        }
        
        this.expiracion = fechaExpiracion;
    
    }
    
}

@Value
class Cvc {

    @NonNull String cvc;

    public Cvc(String cvc) {
        if (!cvc.matches("^\\d{3}$")) {
            throw new IllegalArgumentException("CVC inválido. Debe poseer solo 3 digitos.");
        }
        this.cvc = cvc;
    }
    

  
  
    

}
           

