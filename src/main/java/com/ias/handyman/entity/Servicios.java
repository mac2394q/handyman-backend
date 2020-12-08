/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;


/**
 *
 * @author Priceleggan
 */

@Data
@Entity
@Table(name = "handyman.servicios")
public class Servicios implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "IDENTIFICACION_SERVICIO")
    @JsonProperty("identificacion_servicio")
    private String IdentificacionServicios;
    
    @JsonProperty("identificacion_tecnico")
    @Column(name = "IDENTIFICACION_TECNICO")
    private String IdentificacionTecnico;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("fecha_inicio")
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaInicio;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("fecha_fin")
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaFin;
    
    
    public void calculoHoras(){
        
    }
    
    
}
