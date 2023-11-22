package br.com.getquick.model;

public class Locacao {

    private String id;
    private String usuario;
    private String nomeQuadra;
    private String dataLocacaoIni;
    private String dataLocacaoFim;

    private String idLocavel;

   // private String horarioLocacao;

    public Locacao(String nomeQuadra, String dataLocacaoIni, String dataLocacaoFim, String usuario, String idLocavel) {
        this.usuario = usuario;
        this.nomeQuadra = nomeQuadra;
        this.dataLocacaoIni = dataLocacaoIni;
        this.dataLocacaoFim = dataLocacaoFim;
        this.idLocavel = idLocavel;
       // this.horarioLocacao = horarioLocacao;
    }
    public Locacao(String id, String nomeQuadra, String dataLocacaoIni, String dataLocacaoFim, String usuario, String idLocavel) {
        this.id = id;
        this.usuario = usuario;
        this.nomeQuadra = nomeQuadra;
        this.dataLocacaoIni = dataLocacaoIni;
        this.dataLocacaoFim = dataLocacaoFim;
        this.idLocavel = idLocavel;
        // this.horarioLocacao = horarioLocacao;
    }

    public Locacao(String id, String nomeQuadra, String dataLocacaoIni, String dataLocacaoFim) {
        this.id = id;
        this.nomeQuadra = nomeQuadra;
        this.dataLocacaoIni = dataLocacaoIni;
        this.dataLocacaoFim = dataLocacaoFim;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeQuadra() {
        return nomeQuadra;
    }

    public String getDataLocacaoIni() {
        return dataLocacaoIni;
    }

    public String getDataLocacaoFim() {return dataLocacaoFim; }

    public String getUsuario() { return usuario; }

    public String getIdLocavel() { return idLocavel; }

    // Não teremos a hora da locação, pq no trigger ele injeta a data automatica na tabela de apoio
    /* public String getHorarioLocacao() {
        return horarioLocacao;
    } */
}
