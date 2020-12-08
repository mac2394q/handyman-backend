/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.services;

import com.ias.handyman.entity.Tecnico;

/**
 *
 * @author Priceleggan
 */
public interface TecnicoService {
    
    public Tecnico  verificarTecnico(String  identificaciontecnico);
    
}
