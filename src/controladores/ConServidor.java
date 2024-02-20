/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.Component;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Angel
 */
public class ConServidor implements Runnable {

    private String nombre;
    private Thread hilo;
    private ServerSocket servidor;
    private int puerto;
    private FlujoClienteServidor fcs;

    public ConServidor(String nombre, int puerto) {
        this.puerto = puerto;
        this.nombre = nombre;
        this.hilo = new Thread(this, nombre);
        try {
            //Enciende el servidor
            this.servidor = new ServerSocket(puerto);
            System.out.println("servidor iniciado correctamente");

        } catch (IOException e) {
            System.out.println("no se pudo iniciar el servidor");
            e.printStackTrace();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Thread getHilo() {
        return hilo;
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.hilo);
        hash = 41 * hash + Objects.hashCode(this.servidor);
        hash = 41 * hash + this.puerto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConServidor other = (ConServidor) obj;
        return this.puerto == other.puerto;
    }

    @Override
    public String toString() {
        return "ConServidor{" + "nombre=" + nombre + ", hilo=" + hilo + ", servidor=" + servidor + ", puerto=" + puerto + '}';
    }

    public void notificarInicioJuego(Socket clienteInsertado) throws IOException {
        this.fcs = new FlujoClienteServidor(clienteInsertado);
        this.fcs.enviarMensaje("INICIO_PARTIDA");
    }

    public void notificarRespuestaFinalizada(Socket clienteInsertado) throws IOException {
        FlujoClienteServidor flujo = new FlujoClienteServidor(clienteInsertado);
        flujo.enviarMensaje("FINALIZACION_PARTIDA");
    }
    
    public boolean comprobarRival(Component component) {
        boolean partidaComenzada = false;
        try {
            new Thread(() -> {

                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(component, "Esperando a que el rival conteste");

                });
            }).start();
            String mensaje = this.fcs.recibirMensaje();
            if (mensaje == null) {
                System.out.println("Es nulo");
            }
            if ("FINALIZACION_PARTIDA".equals(mensaje)) {
                partidaComenzada = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return partidaComenzada;
        }
    }
    
}
