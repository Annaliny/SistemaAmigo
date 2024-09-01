package org.example;

public class AmigoInexistenteException extends Exception {

    public AmigoInexistenteException() {
        super("Deveria falhar pois o amigo não existe ainda");
    }

    public AmigoInexistenteException(String message) {
        super(message);
    }
}

