/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.controller;

import com.example.todo_api2.dto.external.BinInfo;
import com.example.todo_api2.dto.SolicitudDTO;
import com.example.todo_api2.dto.RespuestaDTO;
import com.example.todo_api2.service.external.BinListClient;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.todo_api2.service.MetodoPagoServicio;

/**
 *
 * @author Asus
 */

@RestController
@RequestMapping("/metodo")
@RequiredArgsConstructor
public class MetodoPagoController {
    
    private final MetodoPagoServicio servicio;
    private final BinListClient binClient;

    // El controller se encarga de orquestar el flujo y manejar las solicitudes. 
    
    // Delega la lógica al service actuando como un intermediario entre la petición del cliente y la 
    // lógica de la aplicación
    
    @PostMapping // Mapea la peticion POST HTTP a metodos específicos dentro de un controlador
    public RespuestaDTO createMetodoPago(@RequestBody @Valid SolicitudDTO request){
        return servicio.createMetodoPago(request);
    }
    
    @GetMapping ("/{id}")  // Mapea las solicitudes GET HTTP a metodos específicos dentro de un controlador
    public RespuestaDTO getMetodoPago(@PathVariable Long id){
        return servicio.getMetodoPago(id);
    }
    
    @GetMapping  
    
    public List<RespuestaDTO> getAllMetodoPago(){
        return servicio.getAllMetodoPago();
    }
    
    @PutMapping ("/{id}") // Mapea las solicitdes PUT HTTP a metodos específicos dentro de un controlador
    
    public RespuestaDTO updateMetodoPago(@PathVariable Long id, @Valid @RequestBody SolicitudDTO request){
        return servicio.updateMetodoPago(id, request);
    }
    
    @DeleteMapping ("/{id}") // Mapea las solicitudes DELETE HTTP a métodos específicos dentro de un controlador
    public void deleteMetodoPago(@PathVariable Long id){
        servicio.deleteMetodoPago(id);
    }
    

    @GetMapping("/bin/{bin}")
    
    public BinInfo getBinInfo(@PathVariable String bin){
        return binClient.obtenerInfoPorBin(bin);
    }
    
}
