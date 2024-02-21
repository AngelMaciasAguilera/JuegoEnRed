/*
 * Controlador del Cliente
 * Maneja la conexión y la comunicación del cliente con el servidor.
 */
package controladores;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import vistas.JFCliente;

/**
 * Controlador del Cliente Maneja la conexión y la comunicación del cliente con
 * el servidor.
 */
public class ConCliente {

    // Atributos
    private String nombre;
    private Thread hilo;
    private Socket cliente;
    private int puerto;
    private String direccion_ip;
    private FlujoClienteServidor fcs;

    // Constructor
    public ConCliente(String nombre, int puerto, String direccion_ip) {
        this.nombre = nombre;
        this.puerto = puerto;
        this.direccion_ip = direccion_ip;

        // Establecer la conexión con el servidor
        try {
            cliente = new Socket(this.direccion_ip, this.puerto);
            fcs = new FlujoClienteServidor(cliente);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos Getters
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

    // Sobrescritura de métodos
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

    // Método para confirmar el inicio de la partida
    public boolean confirmarInicioPartida() {
        boolean partidaComenzada = false;
        try {
            // Recibe un mensaje del servidor indicando el inicio de la partida
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

    // Método para comprobar si el rival ha finalizado la partida
    public boolean comprobarRival(Component component) {
        boolean partidaComenzada = false;
        try {
            // Inicia un hilo para mostrar un mensaje de espera mientras se espera la respuesta del rival
            new Thread(() -> {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(component, "Esperando a que el rival conteste");
                });
            }).start();

            // Recibe un mensaje del servidor indicando la finalización de la partida por parte del rival
            String mensaje = this.fcs.recibirMensaje();

            // Comprueba el mensaje recibido
            if (mensaje == null) {
                mensaje = "Nulo";
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

    // Método para notificar al servidor que el cliente ha finalizado su respuesta
    public void notificarRespuestaFinalizada() throws IOException {
        this.fcs.enviarMensaje("FINALIZACION_PARTIDA");
    }

    // Método para notificar al servidor la puntuación del cliente
    public void notificarPuntuacionCliente(int puntuacionCliente) throws IOException {
        System.out.println(puntuacionCliente);
        this.fcs.enviarMensaje(String.valueOf(puntuacionCliente));
    }

    // Método para recibir la puntuación del servidor
    public int recibirPuntuacionServidor() {
        int puntuacionServidor = 0;
        try {
            // Recibe un mensaje del servidor con la puntuación
            String mensaje = this.fcs.recibirMensaje();
            System.out.println(mensaje);
            puntuacionServidor = Integer.parseInt(mensaje);
        } catch (NumberFormatException ex) {
            // Manejo de excepciones si el formato no es el esperado
            puntuacionServidor = -2;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.fcs.cerrarConexion();
            } catch (IOException ex) {
                Logger.getLogger(ConCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return puntuacionServidor;
        }
    }
}
