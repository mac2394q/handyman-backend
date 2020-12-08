/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.services;

import com.ias.handyman.entity.Servicios;
import com.ias.handyman.entity.Tecnico;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Priceleggan
 */

@RunWith(SpringRunner.class)

@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ServiciosServiceImplTest {
    
    @Autowired
    private TecnicoServiceImpl tecnicoServiceImpl;
    
    @Autowired
    private ServiciosServiceImpl serviceImpl;
    
   
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registrarServicio method, of class ServiciosServiceImpl.
     */
    @Test
    @Rollback(false)
    @Order(1)
    public void testRegistrarServicio() {
        System.out.println("Proceso -> Registrar Nuevo  Servicio");  
        /* Datos de prueba  para un caso aceptable*/   
        
        try {
        Servicios servicios = new Servicios();
        Servicios serviciosPrueba = new Servicios();
        
        DateFormat fechaInicio= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat fechaFin= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        servicios.setIdentificacionServicios("0f342ffc-0c6a-11eb-adc1-0242ac120002");
        servicios.setIdentificacionTecnico("1111797508");
       
        servicios.setFechaInicio( fechaInicio.parse("2020-10-12 04:05:00") );
        
        servicios.setFechaFin( fechaFin.parse("2020-10-12 06:48:00"));
        
        serviceImpl.registrarServicio(servicios);
        serviciosPrueba = serviceImpl.ConsultarServiciosById(servicios.getIdentificacionServicios());
       
        assertEquals(serviciosPrueba.getIdentificacionServicios(), servicios.getIdentificacionServicios());
        } catch (ParseException ex) {
            Logger.getLogger(ServiciosServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Test
    @Rollback(false)
    @Order(2)
    public void testVerificarTecnicoExistente() {
        System.out.println("Verificacion -> 1111797508 - Tecnico Existente");
        String identificacionTecnico = "1111797508";
        Tecnico tecnico = tecnicoServiceImpl.verificarTecnico(identificacionTecnico);
        assertEquals(identificacionTecnico, tecnico.getIdentificacionTecnico());
         
    }
    
    
    @Test
    @Rollback(false)
    @Order(3)
    public void testVerificarTecnicoNoExistente() {
        System.out.println("Verificar > 1111797507 Tecnico No Existente");
        String identificacionTecnico = "1111797507";
        Tecnico tecnico = tecnicoServiceImpl.verificarTecnico(identificacionTecnico);
        assertNull(tecnico);  
    }
    
    
    
    
}
