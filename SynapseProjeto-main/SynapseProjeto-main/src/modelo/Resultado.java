package modelo;

import java.io.Serializable;

public class Resultado implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeParticipante;
    private long tempo;

    public Resultado(String nomeParticipante, long tempo) {

        this.nomeParticipante = nomeParticipante;
        this.tempo = tempo;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public long getTempo() {
        return tempo;
    }
}