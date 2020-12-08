/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.controller;

import com.ias.handyman.entity.Servicios;
import com.ias.handyman.entity.Tecnico;
import com.ias.handyman.services.ServiciosServiceImpl;
import com.ias.handyman.services.TecnicoServiceImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.validation.Valid;
import com.google.gson.Gson;
import com.ias.handyman.entity.ReporteHoras;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Priceleggan
 */
@RestController
@RequestMapping("/api")
public class RestProviderController {

    @Autowired
    private ServiciosServiceImpl serviceImpl;

    @Autowired
    private TecnicoServiceImpl tecnicoServiceImpl;

    @PostMapping(path = "/registrarServicio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> registrarServicio(@Valid @RequestBody Servicios servicios) {

        try {
            servicios.setIdentificacionServicios(String.valueOf(UUID.randomUUID()));
            serviceImpl.registrarServicio(servicios);

            HashMap<String, String> jsonSuccess = new HashMap<>();

            jsonSuccess.put("data", null);
            jsonSuccess.put("message", "Regsitro realizado satisfactoriamente");
            jsonSuccess.put("error", null);
            jsonSuccess.put("status", "1");
            return jsonSuccess;

        } catch (Exception excepcion) {
            HashMap<String, String> jsonError = new HashMap<>();
            jsonError.put("data", "");
            jsonError.put("message", "El sistema a detectado uin error del sistema.");
            jsonError.put("error", excepcion.getMessage());
            jsonError.put("status", "0");
            return jsonError;
        }

    }

    @PostMapping(path = "/reporteHoras", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> reporteHoras(@Valid @RequestBody ReporteHoras ReporteHoras) {

        try {

            HashMap<String, String> jsonSuccess = new HashMap<>();
            Gson gson = new Gson();

            System.out.println(ReporteHoras.getSemana() + " " + ReporteHoras.getTecnico());
            List<Object[]> listadoReporteHoras = serviceImpl.generarReporte(ReporteHoras.getSemana(), ReporteHoras.getTecnico());

            HashMap<String, String> jsonReport = ReporteHoras.calculadoraHoras(listadoReporteHoras);
            jsonSuccess.put("data", gson.toJson(jsonReport));
            jsonSuccess.put("message", "Reporte de horas laboradas por tecnico");
            jsonSuccess.put("error", null);
            jsonSuccess.put("status", "1");
            return jsonSuccess;

        } catch (Exception excepcion) {

            HashMap<String, String> jsonError = new HashMap<>();
            jsonError.put("data", "");
            jsonError.put("message", "El sistema a detectado un error del sistema.");
            jsonError.put("error", excepcion.getMessage());
            jsonError.put("status", "0");
             excepcion.printStackTrace();
            return jsonError;
        }

    }

    @GetMapping(path = "/verificarTecnico/{identifacion_tecnico}")
    public Map<String, String> verificarTecnico(@PathVariable String identifacion_tecnico) {

        try {

            Tecnico tecnico = tecnicoServiceImpl.verificarTecnico(identifacion_tecnico);
            if (tecnico == null) {

                HashMap<String, String> jsonFailed = new HashMap<>();
                jsonFailed.put("data", "");
                jsonFailed.put("message", "El documento ingresado no corresponde a ningun tecnico registrado en el sistema.");
                jsonFailed.put("error", null);
                jsonFailed.put("status", "0");

                return jsonFailed;
            } else {

                HashMap<String, String> jsonSuccess = new HashMap<>();
                HashMap<String, String> jsonObject = new HashMap<>();

                jsonObject.put("identificacion_tecnico", tecnico.getIdentificacionTecnico());
                jsonObject.put("nombre_completo", tecnico.getNombreCompleto());

                Gson gson = new Gson();

                jsonSuccess.put("data", gson.toJson(jsonObject));
                jsonSuccess.put("message", "Tecnico encontrado.");
                jsonSuccess.put("error", null);
                jsonSuccess.put("status", "1");

                return jsonSuccess;
            }

        } catch (Exception excepcion) {

            HashMap<String, String> jsonError = new HashMap<>();
            jsonError.put("data", "");
            jsonError.put("message", "El sistema a detectado uin error del sistema.");
            jsonError.put("error", excepcion.getMessage());
            jsonError.put("status", "0");
            return jsonError;
        }

    }

}
