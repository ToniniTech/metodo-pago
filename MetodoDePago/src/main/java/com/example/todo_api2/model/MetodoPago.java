/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import java.time.YearMonth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad JPA que representa un metodo persistido en la base de datos.
 * 
 * Fecha de expiración de la tarjeta.
 * Se utiliza YearMonth ya que las tarjetas no manejan día específico.
    
 * Numero de tarjeta y cvc se guardan en la base de datos con fines demostrativos. En entornos
 * reales debería ser tokenizada o manejado bajo estandares PCI DSS. 
 * 
 * @author Asus
 */

@Entity 
@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"numeroTarjeta"})
    }
)
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MetodoPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String titular;
    
    private String numeroTarjeta;

    private YearMonth expiracion;
        
    private String banco;
    
    private String pais;
    
    private String tipo;
   
    private String red;
    
    private String marca;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    private Estado estado;
    
    
}
