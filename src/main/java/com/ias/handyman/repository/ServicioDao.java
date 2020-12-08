/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.repository;


import com.ias.handyman.entity.ReporteHoras;
import com.ias.handyman.entity.Servicios;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Priceleggan
 */
public interface ServicioDao  extends CrudRepository<Servicios, String>{
    
   @Query(value="SELECT IDENTIFICACION_TECNICO as tecnico, FECHA_INICIO as inicio,  FECHA_FIN as fin, WEEK(FECHA_INICIO) as semana, TIMESTAMPDIFF(hour,FECHA_INICIO,FECHA_FIN) as horasLaboradas , WEEKDAY(FECHA_INICIO)  as dia_semana , HOUR(FECHA_INICIO) as hora  from handyman.servicios where week(FECHA_INICIO) = :semana and IDENTIFICACION_TECNICO = :identificacionTecnico ",nativeQuery = true)
   public List<Object[]> generarReporte(@Param("semana") int semana, @Param("identificacionTecnico") String identificacionTecnico);
   
   @Query(value="Select * from handyman.servicios servicios where servicios.IDENTIFICACION_SERVICIO = :identificacionServicio ",nativeQuery = true)
   public Servicios ConsultarServiciosById(@Param("identificacionServicio") String identificacionServicio);
    
}
