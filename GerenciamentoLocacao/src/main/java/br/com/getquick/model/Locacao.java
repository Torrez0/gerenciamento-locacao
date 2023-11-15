package br.com.getquick.model;

public class Locacao {

    private String emailUsuario;

    private String nomeQuadra;

    private String dataLocacao;

    private String horarioLocacao;

    public Locacao(String emailUsuario, String nomeQuadra, String dataLocacao, String horarioLocacao) {
        this.emailUsuario = emailUsuario;
        this.nomeQuadra = nomeQuadra;
        this.dataLocacao = dataLocacao;
        this.horarioLocacao = horarioLocacao;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getNomeQuadra() {
        return nomeQuadra;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public String getHorarioLocacao() {
        return horarioLocacao;
    }
}
