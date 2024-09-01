package org.example;

public class AmigoJaExisteException extends Exception {

    public AmigoJaExisteException() {
        super("Deveria falhar ao tentar cadastrar um amigo que já existe");
    }

    public AmigoJaExisteException(String message) {
        super(message);
    }
}
