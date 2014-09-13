package com.synergyj.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * se agrega la anotacion para que pueda ser mapeada por metodos http
 */
@Controller
public class ControllerHola {

	/*
	 * para decir que la url hola sera manejada por la vista
	 */
	@RequestMapping("/hola")
	public String hola(){
		return "hola";
	}
	
}
