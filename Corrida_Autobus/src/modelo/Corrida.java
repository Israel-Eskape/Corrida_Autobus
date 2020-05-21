/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author eskape
 */
public class Corrida {
    private int idCorrida;
    private Poblacion origen;
    private Poblacion destino;
    private Date fecha_hr;
    private ClaseAutobus claseA;
    private int costo;
    private ArrayList<Integer> ocupados;

    public Corrida(int idCorrida, Poblacion origen, Poblacion destino, Date fecha_hr, ClaseAutobus claseA, int costo) {
        this.idCorrida = idCorrida;
        this.origen = origen;
        this.destino = destino;
        this.fecha_hr = fecha_hr;
        this.claseA = claseA;
        this.costo = costo;
        this.ocupados = new ArrayList<Integer>();
    }

    public void setOcupados(ArrayList<Integer> ocup){
        ocupados = ocup;
    }
    public ArrayList<Integer> getOcupados(){
        return ocupados;
    }
    public int getIdCorrida(){
        return idCorrida;
    }
    public String getOrigen(){
        return origen.getPoblacion();
    }
    public String getDestino(){
        return destino.getPoblacion();
    }
    public Date getFecha(){
        return fecha_hr;
    }
    public ClaseAutobus getClaseAutobus(){
        return claseA;
    }
    public int getCosto(){
        return costo;
    }
    public int getDisponible(){
        return claseA.getNumAsientos()-ocupados.size();
    }
}
