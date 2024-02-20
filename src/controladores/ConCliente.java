/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import javax.naming.Context;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Angel
 */
public class ConCliente implements Runnable {

    private String nombre;
    private Thread hilo;
    private Socket cliente;
    private int puerto;
    private String direccion_ip;
    private FlujoClienteServidor fcs;

    public ConCliente(String nombre, int puerto, String direccion_ip) {
        this.nombre = nombre;
        this.puerto = puerto;
        this.direccion_ip = direccion_ip;
        this.hilo = new Thread(this, nombre);
        try {
            cliente = new Socket(this.direccion_ip, this.puerto);
            fcs = new FlujoClienteServidor(cliente);
            String texto = "conexion establecida correctamente";

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String getNombre() {
        return nombre;
    }

    public Thread getHilo() {
        return hilo;
    }

    public Socket getCliente() {
        return cliente;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getDireccion_ip() {
        return direccion_ip;
    }

    @Override
    public String toString() {
        return "ConCliente{" + "nombre=" + nombre + ", hilo=" + hilo + ", cliente=" + cliente + ", puerto=" + puerto + ", direccion_ip=" + direccion_ip + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.cliente);
        hash = 47 * hash + this.puerto;
        hash = 47 * hash + Objects.hashCode(this.direccion_ip);
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
        final ConCliente other = (ConCliente) obj;
        if (this.puerto != other.puerto) {
            return false;
        }
        if (!Objects.equals(this.direccion_ip, other.direccion_ip)) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean confirmarInicioPartida() {
        boolean partidaComenzada = false;
        try {
            String mensaje = this.fcs.recibirMensaje();
            if ("INICIO_PARTIDA".equals(mensaje)) {
                partidaComenzada = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return partidaComenzada;
        }
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
    
    
     public void notificarRespuestaFinalizada() throws IOException {
       this.fcs.enviarMensaje("FINALIZACION_PARTIDA");
    }
}
