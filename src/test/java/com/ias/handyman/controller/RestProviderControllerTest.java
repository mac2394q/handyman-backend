/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.handyman.controller;

import com.ias.handyman.CalculadoraHorasApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
 
import java.util.Arrays;
 
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
/**
 *
 * @author Priceleggan
 */
@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration
public class RestProviderControllerTest {

    public RestProviderControllerTest() {
    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void tearDown() {
    }

    @org.junit.jupiter.api.Test
    @Rollback(false)
    @Order(4)
    public void testServicioRestVerificacionTecnico() throws Exception {
    //System.out.println("Verificar > 1111797507 ");.mockMvc.perform(get("/api/verificarTecnico/1111797508")).andExpect(status().isOk());
    }

}
