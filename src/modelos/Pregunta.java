/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Angel
 */
class Pregunta {

    private String preguntas;
    private ArrayList<String> posiblesRespuestas;
    private String respuesta;

    public Pregunta(String preguntas, ArrayList<String> posiblesRespuestas, String respuesta) {
        this.preguntas = preguntas;
        this.posiblesRespuestas = posiblesRespuestas;
        this.respuesta = respuesta;
    }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public ArrayList<String> getPosiblesRespuestas() {
        return posiblesRespuestas;
    }

    public void setPosiblesRespuestas(ArrayList<String> posiblesRespuestas) {
        this.posiblesRespuestas = posiblesRespuestas;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.preguntas);
        hash = 67 * hash + Objects.hashCode(this.posiblesRespuestas);
        hash = 67 * hash + Objects.hashCode(this.respuesta);
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
        final Pregunta other = (Pregunta) obj;
        if (!Objects.equals(this.preguntas, other.preguntas)) {
            return false;
        }
        if (!Objects.equals(this.respuesta, other.respuesta)) {
            return false;
        }
        return Objects.equals(this.posiblesRespuestas, other.posiblesRespuestas);
    }

    @Override
    public String toString() {
        return "Pregunta{" + "preguntas=" + preguntas + ", posiblesRespuestas=" + posiblesRespuestas + ", respuesta=" + respuesta + '}';
    }

}
