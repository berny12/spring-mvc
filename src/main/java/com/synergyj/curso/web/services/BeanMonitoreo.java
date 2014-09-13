/**
 * BeanMonitoreo.java Fecha de creación: 08/03/2012 , 13:59:40
 * 
 */
package com.synergyj.curso.web.services;

import java.util.List;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Juan Manuel Reyes Medina @jkingsj (reyesmjm@gmail.com)
 * @version 1.0
 * 
 */
public class BeanMonitoreo {

    private int procesadas;
    private int porProcesar;
    private int total;
    private int porcentaje;


    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    private List<Errores> errores;

    public int getProcesadas() {
        return procesadas;
    }

    public void setProcesadas(int procesadas) {
        this.procesadas = procesadas;
    }

    public int getPorProcesar() {
        return porProcesar;
    }

    public void setPorProcesar(int porProcesar) {
        this.porProcesar = porProcesar;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Errores> getErrores() {
        return errores;
    }

    public void setErrores(List<Errores> errores) {
        this.errores = errores;
    }

}
