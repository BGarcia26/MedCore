package com.MedCore.msmovimientos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "ms-insumos", url = "http://localhost:8081/api/v1/insumos")
public interface InsumoClient {

    @GetMapping("/{id}")
    Object buscarInsumoPorId(@PathVariable("id") Long id); 

    @PostMapping("/{id}/actualizar-stock")
    void actualizarStock(@PathVariable("id") Long id, @RequestBody Integer cantidad);
}