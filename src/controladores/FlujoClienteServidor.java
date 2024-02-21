/*
 * Controla el flujo de comunicación entre el cliente y el servidor.
 */

package controladores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Controla el flujo de comunicación entre el cliente y el servidor.
 */
public class FlujoClienteServidor {

    // Atributos
    private Socket cliente;
    private BufferedReader inputStream;
    private PrintWriter outputStream;

    // Constructor
    public FlujoClienteServidor(Socket socket) throws IOException {
        this.cliente = socket;
        // Inicializa el lector y escritor para el flujo de entrada/salida del socket
        this.inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.outputStream = new PrintWriter(socket.getOutputStream(), true);
    }

    // Método para recibir un mensaje del otro extremo
    public String recibirMensaje() throws IOException {
        return inputStream.readLine();
    }

    // Método para enviar un mensaje al otro extremo
    public void enviarMensaje(String mensaje) {
        outputStream.println(mensaje);
    }

    // Método para cerrar la conexión y liberar recursos
    public void cerrarConexion() throws IOException {
        inputStream.close();
        outputStream.close();
        cliente.close();
    }
}
