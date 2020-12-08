package com.ias.handyman;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication

public class CalculadoraHorasApplication  {

        private static final Logger LOG = LoggerFactory.getLogger(CalculadoraHorasApplication.class);
        
	public static void main(String[] args) {
            LOG.info("BACKEND HandyMan WS : Lanzamiento.");
	    SpringApplication.run(CalculadoraHorasApplication.class, args);
            LOG.info("BACKEND HandyManWS : Lanzamiento Terminado.");
	}

    
}
