/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ConServidor;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelos.*;

/**
 *
 * @author Angel
 */
public class JFServidor extends javax.swing.JFrame {

    private ConServidor cs;
    private boolean haContestado = false;
    private boolean haFinalizado = false;
    private Juego juego;
    private int puerto = 6010;
    private String nombre = "Servidor";

    /**
     * Creates new form JFPrincipal
     */
    public JFServidor() {
        initComponents();
        cs = new ConServidor(nombre, puerto);
        juego = new Juego();
        modificarEstado(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preguntaServidor = new javax.swing.JLabel();
        opcion1Servidor = new javax.swing.JButton();
        opcion2Servidor = new javax.swing.JButton();
        opcion3Servidor = new javax.swing.JButton();
        opcion4Servidor = new javax.swing.JButton();
        btEmpezarJuego = new javax.swing.JButton();
        Spuntos = new javax.swing.JLabel();
        puntosServidor = new javax.swing.JLabel();
        JLestadoServidor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        preguntaServidor.setText("Pregunta");

        opcion1Servidor.setText("jButton1");

        opcion2Servidor.setText("jButton2");

        opcion3Servidor.setText("jButton3");

        opcion4Servidor.setText("jButton4");

        btEmpezarJuego.setText("Empezar partida");
        btEmpezarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpezarJuegoActionPerformed(evt);
            }
        });

        Spuntos.setText("Puntos:");

        puntosServidor.setText("0");

        JLestadoServidor.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(Spuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntosServidor)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(preguntaServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcion1Servidor, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(opcion2Servidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcion3Servidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcion4Servidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btEmpezarJuego)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLestadoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btEmpezarJuego)
                        .addGap(18, 18, 18)
                        .addComponent(JLestadoServidor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Spuntos)
                                .addComponent(puntosServidor))
                            .addComponent(preguntaServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addComponent(opcion1Servidor)
                .addGap(35, 35, 35)
                .addComponent(opcion2Servidor)
                .addGap(43, 43, 43)
                .addComponent(opcion3Servidor)
                .addGap(32, 32, 32)
                .addComponent(opcion4Servidor)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEmpezarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpezarJuegoActionPerformed
        try {
            this.JLestadoServidor.setText("Esperando al cliente...");
            modificarEstado(true);
            Socket cliente = cs.getServidor().accept();
            System.out.println(cliente);
        } catch (IOException ex) {
            Logger.getLogger(JFServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modificarEstado(false);
        
    }//GEN-LAST:event_btEmpezarJuegoActionPerformed

    //Metodos auxiliares 
    private void modificarPregunta() {
        Pregunta pregunta = juego.obtenerPreguntaAleatoria();
        this.preguntaServidor.setText(pregunta.getPregunta());
        this.opcion1Servidor.setText(pregunta.getPosiblesRespuestas().get(1));
        this.opcion2Servidor.setText(pregunta.getPosiblesRespuestas().get(2));
        this.opcion3Servidor.setText(pregunta.getPosiblesRespuestas().get(3));
        this.opcion4Servidor.setText(pregunta.getPosiblesRespuestas().get(4));
    }
    
    private void modificarEstado(boolean estado){
        this.JLestadoServidor.setVisible(estado);
    }

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
            java.util.logging.Logger.getLogger(JFServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLestadoServidor;
    private javax.swing.JLabel Spuntos;
    private javax.swing.JButton btEmpezarJuego;
    private javax.swing.JButton opcion1Servidor;
    private javax.swing.JButton opcion2Servidor;
    private javax.swing.JButton opcion3Servidor;
    private javax.swing.JButton opcion4Servidor;
    private javax.swing.JLabel preguntaServidor;
    private javax.swing.JLabel puntosServidor;
    // End of variables declaration//GEN-END:variables
}
