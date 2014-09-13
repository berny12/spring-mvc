/**
 * ServicioMonitoreo.java
 * Fecha de creación: 08/03/2012 , 12:54:35
 *
 */
package com.synergyj.curso.web.services;

/**
 * Esta interfaz define el monitoreo
 * @author Juan Manuel Reyes Medina @jkingsj (reyesmjm@gmail.com)
 * @version 1.0
 * 
 */
public interface ServicioMonitoreo {

    /**
     * 
     * Esta funcion regresa los valores procesados
     * @author Juan Manuel Reyes Medina @jkingsj (reyesmjm@gmail.com)
     * @return
     */
    BeanMonitoreo regresaMonitoreo();

    /**
     * 
     * Esta funcion indica si el proceso ya termino
     * @author Juan Manuel Reyes Medina @jkingsj (reyesmjm@gmail.com)
     * @return
     */
    boolean isRunning();
}
