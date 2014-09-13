package com.synergyj.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
	
	/*
	 * hacemos una manejador para monitoreo
	 */
	@RequestMapping("/monitoreo")
	public String monitoreo(@RequestParam("tiempo") int tiempo, Model model){
		
		//agregamo la variables a la vista por medio del modelo
		model.addAttribute("tiempo",tiempo);
		return "monitoreo";
	}
}
