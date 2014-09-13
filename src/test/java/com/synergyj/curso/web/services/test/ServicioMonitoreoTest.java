package com.synergyj.curso.web.services.test;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.synergyj.curso.web.services.BeanMonitoreo;
import com.synergyj.curso.web.services.ServicioMonitoreo;


//para cambiar el motoro de pruebas unitarias
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/webApplicationContext.xml")
public class ServicioMonitoreoTest {

	@Autowired
	ServicioMonitoreo servicioMonitoreo;
	@Test
	public void testServicioMonitoreo() {
		Assert.assertNotNull(servicioMonitoreo);
		BeanMonitoreo bean = servicioMonitoreo.regresaMonitoreo();
		Assert.assertNotNull(bean);
	}

}
