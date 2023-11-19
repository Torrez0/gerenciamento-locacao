package br.com.getquick.model;

public class Locacao {

    private String usuario;
    private String nomeQuadra;
    private String dataLocacaoIni;
    private String dataLocacaoFim;

    private int idLocavel;

   // private String horarioLocacao;

    public Locacao(String nomeQuadra, String dataLocacaoIni, String dataLocacaoFim, String usuario, int idLocavel) {
        this.usuario = usuario;
        this.nomeQuadra = nomeQuadra;
        this.dataLocacaoIni = dataLocacaoIni;
        this.dataLocacaoFim = dataLocacaoFim;
        this.idLocavel = idLocavel;
       // this.horarioLocacao = horarioLocacao;
    }

    public String getNomeQuadra() {
        return nomeQuadra;
    }

    public String getDataLocacaoIni() {
        return dataLocacaoIni;
    }

    public String getDataLocacaoFim() {return dataLocacaoFim; }

    public String getUsuario() { return usuario; }

    public int getIdLocavel() { return idLocavel; }

    // Não teremos a hora da locação, pq no trigger ele injeta a data automatica na tabela de apoio
    /* public String getHorarioLocacao() {
        return horarioLocacao;
    } */
}
