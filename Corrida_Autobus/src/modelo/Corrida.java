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

    public Corrida(int idCorrida, Poblacion origen, Poblacion destino, Date fecha_hr, ClaseAutobus claseA, int costo, ArrayList<Integer> ocupados) {
        this.idCorrida = idCorrida;
        this.origen = origen;
        this.destino = destino;
        this.fecha_hr = fecha_hr;
        this.claseA = claseA;
        this.costo = costo;
        this.ocupados = ocupados;
    }

    public int getIdCorrida() {
        return idCorrida;
    }

    public void setIdCorrida(int idCorrida) {
        this.idCorrida = idCorrida;
    }

    public Poblacion getOrigen() {
        return origen;
    }

    public void setOrigen(Poblacion origen) {
        this.origen = origen;
    }

    public Poblacion getDestino() {
        return destino;
    }

    public void setDestino(Poblacion destino) {
        this.destino = destino;
    }

    public Date getFecha_hr() {
        return fecha_hr;
    }

    public void setFecha_hr(Date fecha_hr) {
        this.fecha_hr = fecha_hr;
    }

    public ClaseAutobus getClaseA() {
        return claseA;
    }

    public void setClaseA(ClaseAutobus claseA) {
        this.claseA = claseA;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public ArrayList<Integer> getOcupados() {
        return ocupados;
    }

    public void setOcupados(ArrayList<Integer> ocupados) {
        this.ocupados = ocupados;
    }
    
    
}
