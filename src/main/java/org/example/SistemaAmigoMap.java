package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        if (amigos.containsKey(emailAmigo)) {
            throw new AmigoJaExisteException("O amigo com o email " + emailAmigo + " já está cadastrado.");
        }
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.put(emailAmigo, novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        Amigo amigo = amigos.get(emailAmigo);
        if (amigo == null) {
            throw new AmigoInexistenteException("O amigo com o email " + emailAmigo + " não existe.");
        }
        return amigo;
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

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo == null) {
            throw new AmigoInexistenteException("O amigo com o email " + emailDaPessoa + " não existe.");
        }
        if (amigos.get(emailAmigoSorteado) == null) {
            throw new AmigoInexistenteException("O amigo secreto " + emailAmigoSorteado + " não existe.");
        }
        amigo.setAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        String emailAmigoSorteado = amigo.getEmailAmigoSorteado();
        if (emailAmigoSorteado == null || emailAmigoSorteado.isEmpty()) {
            throw new AmigoNaoSorteadoException("O amigo secreto de " + emailDaPessoa + " ainda não foi sorteado.");
        }
        return emailAmigoSorteado;
    }
}

