package modelo;

import java.io.Serializable;

public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    // GETTER
    public String getNome() {
        return nome;
    }

    // SETTER
    public void setNome(String nome) {
        this.nome = nome;
    }

    // EXIBIÇÃO
    @Override
    public String toString() {
        return nome;
    }
}