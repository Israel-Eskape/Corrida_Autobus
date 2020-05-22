/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionAsientosAutob;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.ClaseAutobus;
import modelo.Corrida;
import modelo.ModeloTablaCorridas;
import modelo.Poblacion;

/**
 *
 * @author eskape
 */
public class GestionAsientosAutob extends javax.swing.JDialog {
    private ModeloTablaCorridas modeloTC;
    private DefaultTableModel modeloT;
    private ArrayList<Corrida> corridass;
    private Corrida corrida;
    private ArrayList<Integer> asientosOcupados;
    private Poblacion poblaciones[]={
        new Poblacion(1, "Oaxaca", "Oax"), new Poblacion(2, "Jalapa", "Ver"),new Poblacion(2, "CDMX", ""),
        new Poblacion(4, "Puebla", "Pue"), new Poblacion(5, "Nochixtlan", "Oax"), new Poblacion(6, "Cuernavaca", "Mor"),
        new Poblacion(7, "Tehuacan", "Pueb")
    };
    private ClaseAutobus claseAutobus[]={
        new ClaseAutobus(1, "Mini", 24),
        new ClaseAutobus(2, "Primera", 40),
        new ClaseAutobus(3, "Lujo", 36)
    };
    private String cOrigen ="";
    private String cDestino="";
    private int numCorSel;
    private String numCols[]= {"Num.Corr","Origen","Destino","Fecha","Hora","Clase Autobus","Precio","Lugares"};
   
    DateFormat formatoAMD = new SimpleDateFormat("yyyyMMdd");
    DateFormat formatoHM = new SimpleDateFormat("HH:mm");
    
    public GestionAsientosAutob(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        corridass = new ArrayList<Corrida>();
        asientosOcupados = new ArrayList<Integer>();
        formaCorridas();
        modeloTC = new ModeloTablaCorridas(corridass, numCols);
        tCorridas.setModel(modeloTC);
        tCorridas.setSelectionMode(0);//Solo se puede seleccionar un renglon
        origenDestino.setCiudades(ciudades());
    }
        private String[] ciudades(){
        String ciuds[] = new String[poblaciones.length];
        for (int i = 0; i < ciuds.length; i++) 
            ciuds[i]= poblaciones[i].getPoblacion();
        return ciuds;
    }
    private void formaCorridas() {
        Date fecha;
        Calendar calen = Calendar.getInstance();  
  //      fecha = calen.getTime();
        for (int i = 0; i < 50; i++) {
            
            calen.add(Calendar.DAY_OF_MONTH, 1);
            fecha = calen.getTime();
//            calen.set(Calendar.HOUR, i);
            corrida = new Corrida(i+1, poblaciones[i%7], poblaciones[i%3+4], fecha, claseAutobus[i%3], 100+i*50);
            corridass.add(corrida);
        }
    }
    private boolean comparaDMA(Date fechaa,Date fechab){
        String sfechaa;
        String sfechab;
        sfechaa = formatoAMD.format(fechaa);
        sfechab = formatoAMD.format(fechab);
            
        return sfechaa.equals(sfechab);
    }
    private void seleccionCorrida(String cO,String cD,Date fes){
        ArrayList<Corrida> corriSel = new ArrayList<Corrida>();
        if(todasLasCorridas.isSelected())
            corriSel = corridass;
        else
            for (int i = 0; i < corridass.size(); i++) {
                if (corridass.get(i).getOrigen().equalsIgnoreCase(cO) &&
                    corridass.get(i).getDestino().equalsIgnoreCase(cD)&&
                    comparaDMA(corridass.get(i).getFecha(), fes)) {
                    
                    corriSel.add(corridass.get(i));
                }
                modeloTC = new ModeloTablaCorridas(corriSel, numCols);
                tCorridas.setModel(modeloTC);
        }
    }
    private JComboBox crearComboTipo(){
        JComboBox combo = new JComboBox(new String[]{"Adulto","Tercera Edad","Niño"}){
            public void updateUI(){
                super.updateUI();
                setBorder(BorderFactory.createEmptyBorder());
                setUI(new BasicComboBoxUI(){
                    @Override 
                        protected JButton createArrowButton(){
                        JButton button = super.createArrowButton();
                        button.setContentAreaFilled(false);
                        button.setBorder(BorderFactory.createEmptyBorder());
                        return button;
                    }
            });
            }
            
        };
        return combo;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        origenDestino = new Componente_OD.OrigenDestino();
        setFecha = new com.toedter.calendar.JDateChooser();
        todasLasCorridas = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCorridas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        setAsi = new compiresasi.IReservaAsiento();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        nombres = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        boletos = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        origenDestino.setToolTipText("");
        origenDestino.setCiudades(new String[] {});
        origenDestino.setEnabled(false);

        todasLasCorridas.setText("Todas las Corridas");

        jLabel1.setText("Busqueda de Corrida");

        jLabel2.setText("Origen");

        jLabel3.setText("Destino");

        jLabel4.setText("Fecha");

        jButton1.setText("Continuar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(todasLasCorridas)
                .addGap(115, 115, 115))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(origenDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(setFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(origenDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todasLasCorridas)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", jPanel2);

        tCorridas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tCorridas);

        jButton2.setText("Aceptar Seleccion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Corridas", jPanel3);

        setAsi.setDistribucion("Horizontal");
        setAsi.setNumAsientos(36);
        setAsi.setOpaque(false);

        jLabel5.setText("Corridas Disponibles");

        jButton3.setText("Continuar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(setAsi, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setAsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reserva", jPanel4);

        nombres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(nombres);

        jButton4.setText("Imprimir Boletos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jButton4)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(85, 85, 85))
        );

        jTabbedPane1.addTab("AsignarPasaje", jPanel5);

        javax.swing.GroupLayout boletosLayout = new javax.swing.GroupLayout(boletos);
        boletos.setLayout(boletosLayout);
        boletosLayout.setHorizontalGroup(
            boletosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        boletosLayout.setVerticalGroup(
            boletosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Boletos", boletos);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cancelar", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cOrigen  = origenDestino.getOrigen();
        cDestino = origenDestino.getDestino();
        seleccionCorrida(cOrigen, cDestino, setFecha.getDate());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int numCorrida = (Integer) modeloTC.getValueAt(tCorridas.getSelectedRow(), 0);
        for (int c = 0; c < corridass.size(); c++) {
            if((Integer)corridass.get(c).getIdCorrida() == numCorrida)
            {
                numCorSel = c;
                setAsi.setNumAsientos(corridass.get(c).getClaseAutobus().getNumAsientos());
                setAsi.setAsignar(corridass.get(c).getOcupados());
            }
            break;
        }
        corrida = corridass.get(numCorSel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ArrayList<Integer> nasi = setAsi.getSeleccionados();
        int na = nasi.size();
        JComboBox combotipo = crearComboTipo();
        String enca [] = {"Asiento","Nombre Pasajero","Tipo de Pasajero"};
        Object datos[][] = new Object[na][3];
        modeloT = new DefaultTableModel(datos, enca);
        for (int a = 0; a < na; a++) {
            datos[a][0] = nasi.get(a);
            datos[a][1] = new String("");
            datos[a][2] = new String("Adulto");
        }
        modeloT = new DefaultTableModel(datos, enca);
        nombres.setModel(modeloT);
        TableColumn col = nombres.getColumnModel().getColumn(2);
        col.setCellEditor(new DefaultCellEditor(combotipo));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        corrida = corridass.get(numCorSel);
        int nb = modeloT.getRowCount();//numero de boletos
        JTextArea boletoss[] = new JTextArea[nb];
        boletos.setLayout(new GridLayout(0,4));
        if(boletos.getComponentCount()>0)
            boletos.removeAll();
        for (int b = 0; b < nb; b++) {
            boletoss[b] = new JTextArea();
            asientosOcupados.add((Integer)modeloT.getValueAt(b, 0));
            boletoss[b].append("Viaje : "+corrida.getOrigen()+ "\n "+corrida.getDestino()+"\n");
            boletoss[b].append("Fecha : "+formatoAMD.format(corrida.getFecha())+"\n");
            boletoss[b].append("Hora  : "+formatoHM.format(corrida.getFecha())+"\n");
            boletoss[b].append("Asiento  : "+modeloT.getValueAt(b, 0)+"\n");
            boletoss[b].append("Pasajero : "+modeloT.getValueAt(b, 1)+"\n");
            boletoss[b].append("Tipo Pasa:"+modeloT.getValueAt(b, 2)+"\n");
            boletoss[b].append("Precio   :  $ "+corrida.getCosto());
            boletos.add(boletoss[b]);
        }
        setAsi.setReservar();
        corridass.get(numCorSel).setOcupados(setAsi.getReservados());    
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionAsientosAutob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionAsientosAutob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionAsientosAutob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionAsientosAutob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionAsientosAutob dialog = new GestionAsientosAutob(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boletos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable nombres;
    private Componente_OD.OrigenDestino origenDestino;
    private compiresasi.IReservaAsiento setAsi;
    private com.toedter.calendar.JDateChooser setFecha;
    private javax.swing.JTable tCorridas;
    private javax.swing.JCheckBox todasLasCorridas;
    // End of variables declaration//GEN-END:variables
}
