/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import com.example.todo_api2.model.Estado;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.YearMonth;

/**
 *
 * @author Asus
 */

@Data
@Builder
@JsonPropertyOrder({
    "id",
    "titular",
    "numeroTarjeta",
    "banco",
    "tipo",
    "red",
    "marca",
    "pais",
    "expiracion",
    "estado",
    "createdAt"
        
})

    /**DTO utilizado para devolver una respuesta en formato JSON a la 
     * solicitud SolicitudDTO
     * 
     
     */

public class RespuestaDTO {


    
    private long id;
    
    private String titular;
    
    private String numeroTarjeta;
    
    private String banco;
    
    private String pais;
    
    private String tipo;
   
    private String red;
    
    private String marca;
    
    private YearMonth expiracion;

    // Fecha y hora en que el método de pago fue registrado en el sistema
    private LocalDateTime createdAt; 
    
    // Estado del metodo de pago (REGISTRADO/INACTIVO)
    private Estado estado;
    
}
