package org.example;

public class AmigoNaoSorteadoException extends Exception {

    public AmigoNaoSorteadoException() {
        super("O amigo secreto ainda não foi sorteado.");
    }

    public AmigoNaoSorteadoException(String message) {
        super(message);
    }
}

