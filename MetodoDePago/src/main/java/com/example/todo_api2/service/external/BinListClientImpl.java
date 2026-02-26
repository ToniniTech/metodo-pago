/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.service.external;

import com.example.todo_api2.dto.external.BinInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Implementa el contrato de comportamiento BinListClient. Se encarga de consumir 
 * la API externa para obtener información asociada a un número de BIN (bank indentification number) 
 * y mapear su respuesta a un DTO interno.
 * @author Asus
 */


@Service
@RequiredArgsConstructor
public class BinListClientImpl implements BinListClient {

    private final WebClient binListWebClient;

    @Override
    public BinInfo obtenerInfoPorBin(String bin) {
        return binListWebClient.get()
                .uri("/{bin}", bin)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BinInfo.class)
                .block();
    }

}
