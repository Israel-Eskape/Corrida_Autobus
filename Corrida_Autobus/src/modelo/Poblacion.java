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
public class Poblacion {
    private int idPoblacion;
    private String nombre;
    private String estado;

    public Poblacion(int idPoblacion, String nombre, String estado) {
        this.idPoblacion = idPoblacion;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getPoblacion() {
        return nombre;
    }
}
