package org.example;

public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    // Construtor da classe
    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        String textoBase = super.getTextoCompletoAExibir();
        return textoBase + " | Destinatário: " + emailDestinatario;
    }
}

