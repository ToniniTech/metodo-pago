/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.model;

import java.time.Month;
import java.time.YearMonth;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;



/**
 * Se realizan los test de las invariantes de negocio para asegurar el correcto funcionamiento
 * del sistema. Primero testeamos los casos inválidos y luegos los válidos. 
 * 
 * @author Asus
 */
public class TarjetaDomainTest {

    // Nos aseguramos de que lance la excepciones cuando se cumplen las condiciones
    @Test
    void numeroTarjetaLanzaUnaExcepcionTest(){
        assertThrows(IllegalArgumentException.class, () -> {
        new NumeroTarjeta("224235234");
    });


    }
    @Test 
    void titularLanzaUnaExcepcionTest(){
        assertThrows(IllegalArgumentException.class, () -> {
        new Titular("Viveros Antho453554ny");
                });
        
    }
    
    // Garantizamos que el mes siempre lance una excepción con respecto 
    // al calendario actual usando .minusMonths 
    
    @Test        
    void fechaExpiracionLanzaUnaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> {
        new Fecha(YearMonth.now().minusMonths(1));
                });
           
        
    }
    
    @Test
    void cvcLanzaUnaExcepcion(){
       assertThrows(IllegalArgumentException.class, () -> {
       new Cvc("4185");
       });
       
    }
       
    // Casos válidos. Testeamos el dominio completo
    @Test
    void numeroTarjetaCumpleDominio(){

        Tarjeta tarjeta = assertDoesNotThrow(() ->
            new Tarjeta(
                "1234567489123456",
                "Viveros Falcon",
                YearMonth.now().plusMonths(1),
                "123"
            ),
            "La tarjeta válida no debería lanzar excepción"
        );

        assertEquals("123", tarjeta.cvc());
        assertEquals("************3456", tarjeta.numeroTarjeta());
        assertEquals("Viveros Falcon", tarjeta.titular());
    }   
     
}
        
        
        

    

