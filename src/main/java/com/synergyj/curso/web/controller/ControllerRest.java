package com.synergyj.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.synergyj.curso.web.services.BeanMonitoreo;
import com.synergyj.curso.web.services.ServicioMonitoreo;


/*
 * se anota la clase para decir que es controller en spring 4
 */
//@RestController

/*
 * para spring version 3
 */
@Controller
public class ControllerRest {
	@Autowired
	ServicioMonitoreo servicioMonitoreo;
	
	/*
	 * metodo que regresa un beanmonitoreo
	 * se anota quien resuelve el servico y que metodo
	 */
	@RequestMapping(value="/getMonitoreo", method=RequestMethod.GET)
	
	//para verison 4
	//public  BeanMonitoreo getMonitoreo(){
	//para version 3
	public @ResponseBody BeanMonitoreo getMonitoreo(){
		return servicioMonitoreo.regresaMonitoreo();
	}
}
