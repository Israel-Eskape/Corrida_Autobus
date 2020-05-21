/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author eskape
 */
public class ClaseAutobus {
    private int idClase;
    private String nombre;
    private int numAsientos;

    public ClaseAutobus(int idClase, String nombre, int numAsientos) {
        this.idClase = idClase;
        this.nombre = nombre;
        this.numAsientos = numAsientos;
    }

   
   
    public String getNombre() {
        return nombre;
    }
   
    public int getNumAsientos() {
        return numAsientos;
    }
 
}
