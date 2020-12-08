/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.services;

import com.ias.handyman.entity.ReporteHoras;
import com.ias.handyman.entity.Servicios;
import java.util.List;

/**
 *
 * @author Priceleggan
 */
public interface ServiciosService {
    
    public void registrarServicio(Servicios servicios);
    
    public Servicios ConsultarServiciosById(String identificacionServicio);
    
    public List<Object[]> generarReporte(int semana, String identificacionTecnico);
    
}
