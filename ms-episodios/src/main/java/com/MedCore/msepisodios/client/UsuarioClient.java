package com.MedCore.msepisodios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-usuarios")
public interface UsuarioClient {
    @GetMapping("/{id}")
    Object buscarPorId(@PathVariable("id") Long id);
}