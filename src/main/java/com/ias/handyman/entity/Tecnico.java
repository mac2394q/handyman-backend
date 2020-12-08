/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Priceleggan
 */

@Data
@Entity
@Table(name = "handyman.tecnico")
public class Tecnico implements Serializable {
    
    @Id
    @JsonProperty("identificacion_tecnico")
    @Column(name = "IDENTIFICACION_TECNICO")
    private String IdentificacionTecnico;
    
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    
}
