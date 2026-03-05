/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DTO externo de la API utilizado para mapear la respuesta
 * de un servicio externo hacia los DTOs internos del sistema.
 * 
 * Dto que representa la respuesta de una API externa de información BIN (número de identificación bancaria).
 * Se utiliza como objeto intermedio para desacoplar el modelo interno del contrato externo
 * del servicio.
 * 
 * Contiene dos objetos anidados (banco, país)  que representan estructuras compuestas
 * de la respuesta JSON de la API externa
 *
 * @author Asus
 */



@Data
public class BinInfo {
    
    private String scheme;
    
    private String brand;
    
    private String type;
    
    @JsonProperty("bank")
    private Banco banco;
    
    @JsonProperty("country")
    private Pais pais; 
            
    
}
