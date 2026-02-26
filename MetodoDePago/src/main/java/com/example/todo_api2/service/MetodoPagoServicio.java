/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.service;

import com.example.todo_api2.dto.SolicitudDTO;
import com.example.todo_api2.dto.RespuestaDTO;
import java.util.List;

/**
 * Interfaz de servicio que define los metodos de comportamiento para la gestion
 * de metodos de pago.
 * 
 * Define las operaciones CRUD (create, read, update and delete) que deben ser 
 * implementadas por la capa de servicio.
 * 
 * @author Asus
 */
public interface MetodoPagoServicio {
    
    // Crea el metodo de pago
    RespuestaDTO createMetodoPago(SolicitudDTO request);
    
    // Obtiene todos los metodos de pago
    List<RespuestaDTO> getAllMetodoPago();
    
    // Obtiene el metodo de pago por ID
    RespuestaDTO getMetodoPago(Long id);
    
    // Actualiza el metodo de pago por ID
    RespuestaDTO updateMetodoPago(Long id, SolicitudDTO request);
    
    // Borra el metodo de pago por ID
    void deleteMetodoPago(Long id);

}
