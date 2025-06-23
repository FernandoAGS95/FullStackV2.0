package com.Evaluacion.Client;

import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.Evaluacion.Client.DTO.UsuarioDTO;

//tests
@Component
public class UsuarioClient {

    private final WebClient  webClient;

    public UsuarioClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
            .baseUrl("http://54.163.238.240:8089/api/v1/usuario")
            .build();
    }

    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        try {
            return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(UsuarioDTO.class)
                .block();
        } catch (WebClientResponseException.NotFound ex) {
            return null; // Usuario no encontrado
        }
    }
}