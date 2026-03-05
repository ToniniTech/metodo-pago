/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.service;

import com.example.todo_api2.dto.SolicitudDTO;
import com.example.todo_api2.dto.RespuestaDTO;
import com.example.todo_api2.dto.external.BinInfo;
import com.example.todo_api2.model.Tarjeta;
import com.example.todo_api2.exception.ResourceNotFoundException;
import com.example.todo_api2.model.Estado;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import com.example.todo_api2.model.MetodoPago;
import org.springframework.stereotype.Service;
import com.example.todo_api2.repository.MetodoPagoRepositorio;
import com.example.todo_api2.service.external.BinListClient;

/**
 * Capa de  servicio (service) es el corazón del sistema, se encarga de la lógica de
 * negocio para gestionar los métodos pagos e implementa la interfaz definida en el contrato
 * de comportamiento. 
 * 
 * Orquesta la validación de reglas de negocio (dominio), la dependencia de una API externa y 
 * la persistencia de los datos. 
 * 
 * 
 * Se implementan los metodos del contrato con su respectiva lógica.
 * @author Asus
 */

@Service
@RequiredArgsConstructor
public class MetodoPagoServicioImpl implements MetodoPagoServicio {
    
    private final MetodoPagoRepositorio repositorio;
    private final BinListClient binListClient;

   @Override
   
   // Crea y persiste el metodo de pago validando las reglas de negocio
    public RespuestaDTO createMetodoPago(SolicitudDTO request) {
        
       String numeroTarjeta = request.getNumeroTarjeta();
       
       String bin = numeroTarjeta.substring(0, 8);
       
       
       // 🔹 llamada automática a API externa
       BinInfo binInfo = binListClient.obtenerInfoPorBin(bin);
       
       
       
    // 1️⃣ DOMINIO (valida reglas)
        Tarjeta tarjeta = new Tarjeta(
            request.getNumeroTarjeta(),
            request.getTitular(),
            request.getExpiracion(),
            request.getCvc()
    );
        
        
        
        

    // 2️⃣ ENTIDAD JPA (persistencia)
        MetodoPago metodo = MetodoPago.builder()
            .titular(tarjeta.titular())
            .numeroTarjeta(tarjeta.numeroTarjeta())
            .expiracion(tarjeta.expiracion())
            .red(binInfo.getBrand())
            .tipo(binInfo.getType())
            .marca(binInfo.getBrand())
            .banco(binInfo.getBanco().getName())
            .pais(binInfo.getPais().getName())
            .createdAt(LocalDateTime.now())
            .estado(Estado.ACTIVO)
            .build();
        
        // IPersiste el método de pago
        
            MetodoPago guardarMetodoPago = repositorio.save(metodo);
            return mapToResponse(guardarMetodoPago);
    }

    // Obtiene el metodo de pago por el ID
    @Override
    public RespuestaDTO getMetodoPago(Long id) {
        MetodoPago metodoPago = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        return mapToResponse(metodoPago);
    }

    // Actualiza el metodo de pago por el ID
    @Override
    public RespuestaDTO updateMetodoPago(Long id, SolicitudDTO request) {
        MetodoPago metodoPago = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        
                metodoPago.setExpiracion(request.getExpiracion());
                metodoPago.setNumeroTarjeta(request.getNumeroTarjeta());
                metodoPago.setTitular(request.getTitular());
                metodoPago.setUpdatedAt(LocalDateTime.now());
                
                MetodoPago metodoPagoAct = repositorio.save(metodoPago);
                
                return mapToResponse(metodoPagoAct);
                
    }
    
    // Elimina el metodo de pago por ID
    @Override
    public void deleteMetodoPago(Long id) {
        MetodoPago metodoPago = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id "  + id));
                
                repositorio.delete(metodoPago);
    }
    
    // Obtiene todos los metodos de pago
    @Override
    public List<RespuestaDTO> getAllMetodoPago() {
        return repositorio.findAll()
               .stream()
               .map(this::mapToResponse)
               .collect(Collectors.toList());
    }

    
    // Mapea la entidad metodoPago al objeto de respuestaDTO
    private RespuestaDTO mapToResponse(MetodoPago metodoPago){
        return RespuestaDTO.builder()
                .id(metodoPago.getId())
                .titular(metodoPago.getTitular())
                .numeroTarjeta(metodoPago.getNumeroTarjeta())
                .expiracion(metodoPago.getExpiracion())
                .pais(metodoPago.getPais())
                .banco(metodoPago.getBanco())
                .red(metodoPago.getRed())
                .tipo(metodoPago.getTipo())
                .marca(metodoPago.getMarca())
                .createdAt(metodoPago.getCreatedAt())
                .estado(Estado.ACTIVO)
                .build();
    
    }





    
}
