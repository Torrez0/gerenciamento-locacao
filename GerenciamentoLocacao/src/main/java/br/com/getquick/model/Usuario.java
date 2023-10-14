package br.com.getquick.model;

public class Usuario {
    private String nome;
    private String email;
    private String genero;
    private String celular;
    private String usuario;
    private String senha;

    public Usuario(String nome, String email, String genero, String celular, String usuario, String senha) {
        this.nome = nome;
        this.email = email;
        this.genero = genero;
        this.celular = celular;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
