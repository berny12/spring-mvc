package com.synergyj.curso.web.services.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.synergyj.curso.web.services.BeanMonitoreo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testApplicationContext.xml")
public class ClienteSpringTest {

	public static Logger logger = LoggerFactory.getLogger(ClienteSpringTest.class);
	
	/*
	 * traemos el restemplate 
	 */
	@Autowired
	RestTemplate resttemplate;
	
	
	@Test
	public void testClienteTest() {
		//par ver si se creo una instancia del resttemplate
		Assert.assertNotNull(resttemplate);
		//consumimos el servicio
		BeanMonitoreo bean = resttemplate.getForObject("http://localhost:8080/spring-mvc/getMonitoreo.do", BeanMonitoreo.class);
		//para ver si hubo respuesta del servicio
		Assert.assertNotNull(bean);
		//imprimios el valor del servicio
		logger.debug("el bean fue {}",bean.getProcesadas());
	}

}
