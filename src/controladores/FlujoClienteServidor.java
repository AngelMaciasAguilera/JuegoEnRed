/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Angel
 */
public class FlujoClienteServidor {
    private Socket cliente;
    private BufferedReader inputStream;
    private PrintWriter outputStream;

    public FlujoClienteServidor(Socket socket) throws IOException {
        this.cliente = socket;
        this.inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.outputStream = new PrintWriter(socket.getOutputStream(), true);
        
    }
    
    
    public String recibirMensaje() throws IOException {
        return inputStream.readLine();
    }

    public void enviarMensaje(String mensaje) {
        outputStream.println(mensaje);
    }

    public void cerrarConexion() throws IOException {
        inputStream.close();
        outputStream.close();
        cliente.close();
    }
    
    
    
}
