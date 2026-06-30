package com.MedCore.msreportes.client;

import com.MedCore.msreportes.model.Reporte;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "ms-insumos")
public interface InsumoClient {
    
    @GetMapping
    List<Reporte> listarTodos(); // Trae todos los insumos para el reporte
}