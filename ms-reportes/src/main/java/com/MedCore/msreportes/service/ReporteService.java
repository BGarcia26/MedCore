package com.MedCore.msreportes.service;

import com.MedCore.msreportes.client.InsumoClient;
import com.MedCore.msreportes.model.Reporte;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    @Autowired
    private InsumoClient insumoClient;

    public byte[] generarPdfInsumos() {
        try {
            // 1. Obtener datos desde ms-insumos vía Feign
            List<Reporte> datos = insumoClient.listarTodos();

            // 2. Localizar el archivo jrxml en resources/reports/
            File file = ResourceUtils.getFile("classpath:reports/insumos.jrxml");
            
            // 3. Compilar el reporte
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

            // 4. Llenar el reporte con los datos de la lista
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(datos);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("empresa", "MedCore - Hospital Curicó");

            // 5. Crear el objeto JasperPrint y exportar a byte[]
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al generar el reporte: " + e.getMessage());
        }
    }
}