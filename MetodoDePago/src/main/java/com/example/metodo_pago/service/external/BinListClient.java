/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.service.external;

import com.example.todo_api2.dto.external.BinInfo;

/**
 * Contrato de comportamiento para API externa
 * @author Asus
 */
public interface BinListClient {
    BinInfo obtenerInfoPorBin(String bin);
    
}
