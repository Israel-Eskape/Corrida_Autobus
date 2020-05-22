/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eskape
 */
public class ModeloTablaCorridas extends AbstractTableModel{
    private ArrayList <Corrida> datos;
    private String encabezado[];

    public ModeloTablaCorridas(ArrayList<Corrida> corridas, String[] nomColumnas) {
        this.datos = corridas;
        this.encabezado = nomColumnas;
    }
    
    @Override
    public String getColumnName(int i){
        return encabezado[i];
    }
    
    @Override
    public Object getValueAt(int r, int c) {
        switch (c){
            case 0: return datos.get(r).getIdCorrida();
            case 1: return datos.get(r).getOrigen();
            case 2: return datos.get(r).getDestino();
            case 3: DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    return formatoFecha.format(datos.get(r).getFecha());
            case 4: DateFormat formatoHora = new SimpleDateFormat("HH:mm");
                    return formatoHora.format(datos.get(r).getFecha());
            case 5: return datos.get(r).getClaseAutobus().getNombre();
            case 6: return datos.get(r).getCosto();
            default:return datos.get(r).getDisponibles();
        }
    }
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return encabezado.length;
    }

    
    
    
}
