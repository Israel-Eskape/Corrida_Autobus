package Componente_OD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eskape
 */
public class OrigenDestino extends JPanel implements Serializable,ActionListener{
    private DefaultComboBoxModel modelO;
    private DefaultComboBoxModel modelD;
    private String origen;
    private String destino;
    
    public OrigenDestino(){
        modelO = new DefaultComboBoxModel();
        modelD = new DefaultComboBoxModel();
        JComboBox ori = new JComboBox(modelO);
        JComboBox des = new JComboBox(modelD);
        add(ori);
        add(des);
        ori.addActionListener(this);
    }
    
    public void setCiudades(String c[]){
        for (int i = 0; i < c.length; i++) {
            modelO.addElement(c[i]);   
        }
    }
    public String getOrigen(){
        return (String) modelO.getSelectedItem();
    }
    public String getDestino(){
        return (String) modelD.getSelectedItem();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        modelD.removeAllElements();
        for (int i = 0; i < modelO.getSize(); i++) {
            if(!modelO.getElementAt(i).equals(modelD.getSelectedItem()))
                modelD.addElement(modelO.getElementAt(i));
        }
    }
}

