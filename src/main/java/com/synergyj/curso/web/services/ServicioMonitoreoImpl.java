/**
 * ServicioMonitoreoImpl.java Fecha de creaci�n: 08/03/2012 , 14:03:09
 * 
 */
package com.synergyj.curso.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Esta clase implementa el servicio de monitoreo
 * @author Juan Manuel Reyes Medina @jkingsj (reyesmjm@gmail.com)
 * @version 1.0
 * 
 */
@Service("servicioMonitoreo")
public class ServicioMonitoreoImpl implements ServicioMonitoreo {

    int procesadas;
    int totales = 20000;
    int tiempoProcesamiento;
    int rangoProcesamiento = 1000;
    List<Errores> listaErrores = new ArrayList<Errores>();

    /*
     * La documentacion de este metodo se encuentra en la declaracion de la interface o clase
     * (non-Javadoc)
     * @see com.synergyj.curso.web.services.ServicioMonitoreo#regresaMonitoreo()
     */

    public BeanMonitoreo regresaMonitoreo() {

        generaProcesada();

        BeanMonitoreo bean1 = new BeanMonitoreo();
        bean1.setTotal(totales);
        bean1.setProcesadas(procesadas);
        bean1.setPorProcesar(totales - procesadas);
        bean1.setErrores(listaErrores);

        return bean1;

    }

    /**
     * 
     * Revisa cuantas procesadas hay
     * @author Juan Manuel Reyes Medina @jkingsj (reyesmjm@gmail.com)
     */
    private void generaProcesada() {

        int procesadasTemp = (int) (Math.random() * rangoProcesamiento);

        if ((procesadasTemp + procesadas) >= totales) {

            procesadas = totales;
        } else {
            procesadas += procesadasTemp;
        }

        generaError();
    }

    /**
     * 
     * Genera Errores aleatorios
     * @author Juan Manuel Reyes Medina @jkingsj (reyesmjm@gmail.com)
     */
    private void generaError() {

        int numeroMagico = (int) (Math.random() * 10);

        if (numeroMagico == 4) {
            Errores error = new Errores();
            error.setIdCausaError(5);
            error.setError("Este error fue causado por baja en BD");
            listaErrores.add(error);
        }
    }

    /*
     * La documentacion de este metodo se encuentra en la declaracion de la interface o clase
     * (non-Javadoc)
     * @see com.synergyj.curso.web.services.ServicioMonitoreo#isRunning()
     */
    public boolean isRunning() {

        boolean regreso = false;
        if (totales == procesadas) {
            regreso = true;
        }
        return regreso;
        // TODO Codificar el cuerpo del metodo
    }

    public void setTotales(int totales) {
        this.totales = totales;
    }

    public void setRangoProcesamiento(int rangoProcesamiento) {
        this.rangoProcesamiento = rangoProcesamiento;
    }

}
