package com.MedCore.mslotes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-insumos", url = "http://localhost:8081/api/v1/insumos")
public interface InsumoClient {

    @GetMapping("/{id}")
    Object buscarInsumoPorId(@PathVariable("id") Long id); 
}