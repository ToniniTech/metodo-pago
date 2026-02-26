/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.service.external;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Es un adaptador que consume una API externa para obtener información 
 * de tarjetas a partir del BIN y devolverla como un DTO.
 * @author
 */
@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
    
    @Bean
    public WebClient binListWebClient(WebClient.Builder builder){
        return builder
                .baseUrl("https://lookup.binlist.net")
                .defaultHeader("User-Agent", "SpringBoot-App/1.0")
                .build();
    }
    
}
