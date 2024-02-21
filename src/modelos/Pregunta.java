/*
 * Representa una pregunta con opciones de respuesta.
 */
package modelos;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Representa una pregunta con opciones de respuesta.
 */
public class Pregunta {

    // Atributos
    private String pregunta;
    private ArrayList<String> posiblesRespuestas;
    private String respuesta;

    // Constructor
    public Pregunta(String preguntas, ArrayList<String> posiblesRespuestas, String respuesta) {
        this.pregunta = preguntas;
        this.posiblesRespuestas = posiblesRespuestas;
        this.respuesta = respuesta;
    }

    // Métodos de acceso
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
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

    // Métodos sobreescritos
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.pregunta);
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
        if (!Objects.equals(this.pregunta, other.pregunta)) {
            return false;
        }
        if (!Objects.equals(this.respuesta, other.respuesta)) {
            return false;
        }
        return Objects.equals(this.posiblesRespuestas, other.posiblesRespuestas);
    }

    @Override
    public String toString() {
        return "Pregunta{" + "pregunta=" + pregunta + ", posiblesRespuestas=" + posiblesRespuestas + ", respuesta=" + respuesta + '}';
    }
    
    
}
