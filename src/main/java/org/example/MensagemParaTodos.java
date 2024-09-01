package org.example;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        String textoBase = super.getTextoCompletoAExibir();
        return textoBase + " | Esta mensagem é para todos.";
    }
}

