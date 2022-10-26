package com.example.demo;

public class ClienteDTO {
    private String nome;
    private String endereco;

    public ClienteDTO(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public ClienteDTO() {


    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
