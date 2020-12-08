/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.Entity;

/**
 *
 * @author Priceleggan
 */
@Data

public class ReporteHoras {
    
    private static final long serialVersionUID = 1L;
    
    
    @JsonProperty("identificacionTecnico")
    @Column(name = "tecnico")
    private String tecnico;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("inicio")
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaInicio;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("fin")
    @Column(name = "fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaFin;
    
    @JsonProperty("semana")
    @Column(name = "semana")
    private int semana;
    
    @JsonProperty("horas")
    @Column(name = "horas")
    private int horas;
    
    @JsonProperty("dia_semana")
    @Column(name = "dia_semana")
    private String dia_semana;
    
    public HashMap<String, String> calculadoraHoras(List<Object[]> listadoReporteHoras) {
        
        int horaDiurna = 0;
        int horaNocturna = 0;
        int horaDiurnaExtra  = 0;
        int horaNocturnaExtra = 0;
        int horaDominical = 0;
        int horaDominicalExtra = 0;
        int horasLaboradasLey = 48;
        
        int horaLaboradasSemana = 0;
        HashMap<String, String> jsonReporte = new HashMap<>();

        for (Object[] obj : listadoReporteHoras) {
                BigInteger horaInicio = (BigInteger) obj[6];
                BigInteger diaSemana = (BigInteger)obj[5];
                BigInteger horasLaboradas = (BigInteger) obj[4];
                System.out.println("Tecnico "+obj[0]+
                        " Fecha inicial "+obj[1]+
                        " fecha final "+obj[2]+
                        " Semana "+obj[3]+
                        "  hora "+obj[4]+
                        " dia "+obj[5]+
                        " hora inicio "+obj[6]+" "
                );
                
            int [] calculoHoras = diferenciaHoras(horaLaboradasSemana, (int)horasLaboradas.intValueExact(), horasLaboradasLey);    
            if( horaInicio.intValueExact() > 6 &&  horaInicio.intValueExact() < 21 && diaSemana.intValueExact() != 6){
                horaLaboradasSemana += calculoHoras[0];
                horaDiurna += calculoHoras[1];
                horaDiurnaExtra += calculoHoras[2];              
            }else if ( (horaInicio.intValueExact() > 19 &&  horaInicio.intValueExact() <= 23) || (horaInicio.intValueExact() > 0 &&  horaInicio.intValueExact() < 8) && diaSemana.intValueExact() != 6 ){
                horaLaboradasSemana += calculoHoras[0];
                horaNocturna  += calculoHoras[1];
                horaNocturnaExtra += calculoHoras[2];
            }else if (  diaSemana.intValueExact() == 6 ){
                horaLaboradasSemana += calculoHoras[0];
                horaDominicalExtra += calculoHoras[1];
                horaDominical += calculoHoras[2];
            }
        }
        
        jsonReporte.put("horaDiurna", ""+horaDiurna);
        jsonReporte.put("horaNocturna", ""+horaNocturna);
        jsonReporte.put("horaDiurnaExtra", ""+horaDiurnaExtra);
        jsonReporte.put("horaNocturnaExtra", ""+horaNocturnaExtra);
        jsonReporte.put("horaDominical", ""+horaDominical);
        jsonReporte.put("horaDominicalExtra", ""+horaDominicalExtra);
        return jsonReporte;
    }
    
    
    public int []  diferenciaHoras(int horaLaboradasSemana, int horasLaboradas, int horasLaboradasLey){
        int [] validacionHoras = new int[3];
        
        int diferenciaHoras = 0;
        int diferenciaExtra = 0;
        int totalHoras = 0;
        horaLaboradasSemana += horasLaboradas;
       
        if(horaLaboradasSemana <=  horasLaboradasLey){
            validacionHoras[0] = horaLaboradasSemana;
            validacionHoras[1] = horasLaboradas;
            validacionHoras[2] = 0;
        }else{
            diferenciaHoras = horaLaboradasSemana -  horasLaboradasLey;
            validacionHoras[0] = 48;
            validacionHoras[1] = 0;
            validacionHoras[2] = diferenciaHoras;
        }
       
        return validacionHoras;
    }
    
}
