/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.YearMonth;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Asus
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDTO {
    
    /**   
     * DTO utiizado para recibir los datos de un método de pago
     * en solicitudes POST. Incluye validaciones con Jakarta Validation que se encargan de filtrar
     * la información y mantener la integridad de los datos.
     */
    
    
    @NotBlank(message = "titular obligatorio")
    @Pattern(regexp = "^[A-Z][a-zñáéíóúü]+ [A-Z][a-zñáéíóúü]+$", message = "Debe tener apellido y nombre")
    private String titular;
    
    @NotBlank(message = "Numero de tarjeta obligatorio")
    @Pattern(regexp = "\\d{4}(\\d{4}){3}", message = "La tarjeta debe poseer 16 digitos")
    private String numeroTarjeta;
    
    @NotNull(message = "La fecha de expiracion es obligatoria")
    @JsonFormat(pattern = "yyyy-MM") 
    @Future(message = "La tarjeta esta expirada")

    private YearMonth expiracion; // Se usa YearMonth ya que las tarjeta no manejas días en específico
    
    @NotBlank(message = "El codigo de valor es obligatorio")
    private String cvc;
    
}
