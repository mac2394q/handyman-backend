/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.services;

import com.ias.handyman.entity.Tecnico;
import com.ias.handyman.repository.TecnicoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Priceleggan
 */
@Service
public class TecnicoServiceImpl implements TecnicoService{

    @Autowired
    private TecnicoDao tecnicoDao;
    
    @Override
    public Tecnico verificarTecnico(String identificacionTecnico) {
        return tecnicoDao.findById(identificacionTecnico).orElse(null);
    }
    
}
