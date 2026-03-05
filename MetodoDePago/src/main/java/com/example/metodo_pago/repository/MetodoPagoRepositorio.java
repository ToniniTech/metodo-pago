/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.repository;

import java.util.List;
import com.example.todo_api2.model.Estado;
import com.example.todo_api2.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Define el repositorio donde se gestionan (guardar, consultar, actualizar y eliminar)
 * las entidades MetodoPago en la base de datos. Incluye prefijos válidos para generar los metodos.
 * 
 * findByEstado genera automáticamente una consulta del tipo SELECT * FROM metodo_pago WHERE estado = ?
 * que nos sirve para obtener todos los metodos de pago según su estado (ACTIVO/INACTIVO)
 * @author Asus
 */
public interface MetodoPagoRepositorio extends JpaRepository<MetodoPago, Long>{
    List<MetodoPago> findByEstado(Estado estado);
    
    MetodoPago existsByNumeroTarjeta(long Id);
}
