/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.repository;

import com.ias.handyman.entity.Tecnico;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Priceleggan
 */
public interface TecnicoDao extends CrudRepository<Tecnico, String> {
    
}
