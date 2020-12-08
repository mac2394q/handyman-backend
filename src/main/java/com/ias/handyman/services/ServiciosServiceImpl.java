/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.services;

import com.ias.handyman.entity.ReporteHoras;
import com.ias.handyman.entity.Servicios;
import com.ias.handyman.repository.ServicioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Priceleggan
 */

@Service
public class ServiciosServiceImpl implements ServiciosService{

    @Autowired
    private ServicioDao serviciosDao;
    
    @Override
    @Transactional
    public void registrarServicio(Servicios servicios) {
        serviciosDao.save(servicios);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Servicios ConsultarServiciosById(String identificacionServicio) {
        return serviciosDao.ConsultarServiciosById(identificacionServicio);
    }

    @Override
    public List<Object[]> generarReporte(int semana, String identificacionTecnico) {
        return ( List<Object[]> ) serviciosDao.generarReporte(semana, identificacionTecnico);
    }

   
   


    
    
    
    
}
