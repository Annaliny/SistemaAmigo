package org.example;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.add(novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(emailAmigo)) {
                return amigo;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        MensagemParaTodos mensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        MensagemParaAlguem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem mensagem : mensagens) {
            if (mensagem.ehAnonima()) {
                mensagensAnonimas.add(mensagem);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(mensagens);
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo != null) {
            amigo.setAmigoSorteado(emailAmigoSorteado);
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo != null) {
            return amigo.getEmailAmigoSorteado();
        }
        return null;
    }
}