/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 *
 * @author Angel
 */
public class ConServidor implements Runnable {

    private String nombre;
    private Thread hilo;
    private ServerSocket servidor;
    private int puerto;
    private Socket cliente;

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
    
    
    public void notificarInicioJuego(Socket cliente){
        
        try {
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            escritor.println("INICIO_PARTIDA"); // Mensaje de señalización
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void notificarFinalJuego(){
        try {
            PrintWriter escritor = new PrintWriter(this.cliente.getOutputStream(), true);
            escritor.println("INICIO_PARTIDA"); // Mensaje de señalización
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

}
