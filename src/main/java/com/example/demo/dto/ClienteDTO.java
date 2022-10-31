package com.example.demo.dto;

public class ClienteDTO {

    private String endereco;

    public ClienteDTO(String nome, String endereco) {

        this.endereco = endereco;
    }

    public ClienteDTO() {

    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
