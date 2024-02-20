/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ConCliente;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelos.Juego;
import modelos.Pregunta;

/**
 *
 * @author Angel
 */
public class JFCliente extends javax.swing.JFrame {

    private ConCliente cc;
    private boolean haContestado = false;
    private boolean haFinalizado = false;
    private Juego juego;
    private int puerto = 6010;
    private String ipCliente = "192.168.0.18";
    private String nombre = "Angel";
    private String respuestaCorrecta = "";
    private String respuestaElegida = "";

    /**
     * Creates new form JFCliente
     */
    public JFCliente() {
        initComponents();
        juego = new Juego();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puntosCliente = new javax.swing.JLabel();
        opcion1Cliente = new javax.swing.JButton();
        opcion2Cliente = new javax.swing.JButton();
        opcion3Cliente = new javax.swing.JButton();
        opcion4Cliente = new javax.swing.JButton();
        btUnirseAPartidaCliente = new javax.swing.JButton();
        Cpuntos = new javax.swing.JLabel();
        preguntaCliente = new javax.swing.JLabel();
        limiteRondas = new javax.swing.JLabel();
        numeroRondas = new javax.swing.JLabel();
        indicadorRondaCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        puntosCliente.setText("0");

        opcion1Cliente.setText("jButton1");
        opcion1Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ClienteActionPerformed(evt);
            }
        });

        opcion2Cliente.setText("jButton2");
        opcion2Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2ClienteActionPerformed(evt);
            }
        });

        opcion3Cliente.setText("jButton3");
        opcion3Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3ClienteActionPerformed(evt);
            }
        });

        opcion4Cliente.setText("jButton4");
        opcion4Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion4ClienteActionPerformed(evt);
            }
        });

        btUnirseAPartidaCliente.setText("Unirse a una partida");
        btUnirseAPartidaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUnirseAPartidaClienteActionPerformed(evt);
            }
        });

        Cpuntos.setText("Puntos:");

        preguntaCliente.setText("Pregunta");

        limiteRondas.setText("/15");

        numeroRondas.setText("Ronda:");

        indicadorRondaCliente.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(Cpuntos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puntosCliente)
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(opcion1Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(opcion2Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opcion3Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opcion4Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preguntaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numeroRondas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(indicadorRondaCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limiteRondas)
                        .addGap(183, 183, 183)))
                .addComponent(btUnirseAPartidaCliente)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btUnirseAPartidaCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cpuntos)
                                    .addComponent(puntosCliente))))
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numeroRondas)
                            .addComponent(indicadorRondaCliente)
                            .addComponent(limiteRondas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preguntaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addComponent(opcion1Cliente)
                .addGap(35, 35, 35)
                .addComponent(opcion2Cliente)
                .addGap(43, 43, 43)
                .addComponent(opcion3Cliente)
                .addGap(32, 32, 32)
                .addComponent(opcion4Cliente)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btUnirseAPartidaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUnirseAPartidaClienteActionPerformed
        cc = new ConCliente(nombre, puerto, ipCliente);
        if (cc.confirmarInicioPartida() == true) {
            JOptionPane.showMessageDialog(this, "El juego va a comenzar");
            fJuego();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrio un fallo al recibir informacion del servidor, por favor, reinicie la aplicacion");
        }
    }//GEN-LAST:event_btUnirseAPartidaClienteActionPerformed

    private void opcion1ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ClienteActionPerformed
        this.haContestado = true;
        this.respuestaElegida = opcion1Cliente.getText();
    }//GEN-LAST:event_opcion1ClienteActionPerformed

    private void opcion2ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2ClienteActionPerformed
        this.haContestado = true;
        this.respuestaElegida = opcion2Cliente.getText();
    }//GEN-LAST:event_opcion2ClienteActionPerformed

    private void opcion3ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3ClienteActionPerformed
        this.haContestado = true;
        this.respuestaElegida = opcion3Cliente.getText();
    }//GEN-LAST:event_opcion3ClienteActionPerformed

    private void opcion4ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4ClienteActionPerformed
        this.haContestado = true;
        this.respuestaElegida = opcion4Cliente.getText();
    }//GEN-LAST:event_opcion4ClienteActionPerformed

    //Metodos auxiliares 
    private void modificarPregunta() {
        Pregunta pregunta = juego.obtenerPreguntaAleatoria();

        // Verifica si la pregunta obtenida es nula
        if (pregunta == null) {
            System.out.println("Pregunta invalida.");
            return;
        }

        this.preguntaCliente.setText(pregunta.getPregunta());
        List<String> posiblesRespuestas = pregunta.getPosiblesRespuestas();

        // Verifica si hay al menos 4 posibles respuestas
        if (posiblesRespuestas.size() < 4) {
            System.out.println("La pregunta no tiene suficientes respuestas.");
            haFinalizado = true;
            return;
        }

        this.opcion1Cliente.setText(posiblesRespuestas.get(0));
        this.opcion2Cliente.setText(posiblesRespuestas.get(1));
        this.opcion3Cliente.setText(posiblesRespuestas.get(2));
        this.opcion4Cliente.setText(posiblesRespuestas.get(3));
        this.respuestaCorrecta = pregunta.getRespuesta();
    }

    private void modificarEstado(boolean estado) {
        this.opcion1Cliente.setEnabled(estado);
        this.opcion2Cliente.setEnabled(estado);
        this.opcion3Cliente.setEnabled(estado);
        this.opcion4Cliente.setEnabled(estado);
    }

    private void fJuego() {

        Thread juegoThread = new Thread(() -> {
            int puntos = 0;
            for (int i = 1; i < 16; i++) {
                this.indicadorRondaCliente.setText(String.valueOf(i));
                SwingUtilities.invokeLater(() -> {
                    modificarPregunta();
                    modificarEstado(true); // Habilitar botones
                });

                // Esperar hasta que el usuario haya contestado
                while (!haContestado) {
                    try {
                        Thread.sleep(100); // Puedes ajustar el tiempo de espera según tus necesidades
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (this.respuestaElegida.equals(this.respuestaCorrecta)) {
                    this.juego.setPuntos(60);
                    this.puntosCliente.setText(String.valueOf(this.juego.getPuntos()));
                }

                // Una vez que el usuario ha contestado, modificar la pregunta nuevamente
                SwingUtilities.invokeLater(() -> {
                    modificarPregunta();
                });

                haContestado = false; // Reiniciar la bandera después de la respuesta
                if (i == 15) {
                    modificarEstado(false);
                    this.preguntaCliente.setText("El juego ha finalizado si quiere puede jugar otra ronda");
                    this.opcion1Cliente.setText("Finalizado");
                    this.opcion2Cliente.setText("Finalizado");
                    this.opcion3Cliente.setText("Finalizado");
                    this.opcion4Cliente.setText("Finalizado");
                }
            }
        });

        juegoThread.start();

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
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cpuntos;
    private javax.swing.JButton btUnirseAPartidaCliente;
    private javax.swing.JLabel indicadorRondaCliente;
    private javax.swing.JLabel limiteRondas;
    private javax.swing.JLabel numeroRondas;
    private javax.swing.JButton opcion1Cliente;
    private javax.swing.JButton opcion2Cliente;
    private javax.swing.JButton opcion3Cliente;
    private javax.swing.JButton opcion4Cliente;
    private javax.swing.JLabel preguntaCliente;
    private javax.swing.JLabel puntosCliente;
    // End of variables declaration//GEN-END:variables
}
