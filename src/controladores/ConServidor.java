/*
 * Controlador del Servidor
 * Maneja la conexión y la comunicación del servidor con los clientes.
 */
package controladores;

import java.awt.Component;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Controlador del servidor que maneja la conexión y la comunicación del servidor
 * con los clientes.
 */
public class ConServidor {

    // Atributos
    private String nombre;
    private ServerSocket servidor;
    private int puerto;
    private FlujoClienteServidor fcs;

    // Constructor
    public ConServidor(String nombre, int puerto) {
        this.puerto = puerto;
        this.nombre = nombre;

        try {
            // Inicia el servidor en el puerto especificado
            this.servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado correctamente");

        } catch (IOException e) {
            // Manejo de excepciones en caso de error al iniciar el servidor
            System.out.println("No se pudo iniciar el servidor");
            e.printStackTrace();
        }
    }

    // Métodos Getters y Setters
    public String getNombre() {
        return nombre;
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

    // Sobrescritura de métodos
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nombre);
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
        return "ConServidor{" + "nombre=" + nombre + ", " + ", servidor=" + servidor + ", puerto=" + puerto + '}';
    }

    // Método para notificar el inicio del juego al cliente
    public void notificarInicioJuego(Socket clienteInsertado) throws IOException {
        this.fcs = new FlujoClienteServidor(clienteInsertado);
        this.fcs.enviarMensaje("INICIO_PARTIDA");
    }

    // Método para notificar al cliente que el servidor ha finalizado su respuesta
    public void notificarRespuestaFinalizada(Socket clienteInsertado) throws IOException {
        FlujoClienteServidor flujo = new FlujoClienteServidor(clienteInsertado);
        flujo.enviarMensaje("FINALIZACION_PARTIDA");
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

            // Recibe un mensaje del cliente indicando la finalización de la partida por parte del rival
            String mensaje = this.fcs.recibirMensaje();

            // Comprueba el mensaje recibido
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

    // Método para notificar al cliente la puntuación del servidor
    public void notificarPuntuacionServidor(int puntuacionServidor, Socket clienteInsertado) throws IOException {
        System.out.println(puntuacionServidor);
        FlujoClienteServidor flujo = new FlujoClienteServidor(clienteInsertado);
        flujo.enviarMensaje(String.valueOf(puntuacionServidor));
    }

    // Método para recibir la puntuación del cliente
    public int recibirPuntuacionCliente() {
        int puntuacionCliente = 0;
        try {
            // Recibe un mensaje del cliente con la puntuación
            String mensaje = this.fcs.recibirMensaje();
            System.out.println(mensaje);
            puntuacionCliente = Integer.parseInt(mensaje);
        } catch (NumberFormatException ex) {
            // Manejo de excepciones si el formato no es el esperado
            puntuacionCliente = -2;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.fcs.cerrarConexion();
            } catch (IOException ex) {
                Logger.getLogger(ConServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return puntuacionCliente;
        }
    }
}

