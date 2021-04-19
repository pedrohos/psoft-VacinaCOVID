package Models;

import java.util.List;

public class Pessoa {
    private String nome;
    private int cpf;
    private String endereco;
    private int numeroCartaoSus;
    private String email;
    private String telefone;
    private int idade;
    private String profissao;
    private List<String> comorbidades;

    public Pessoa(String nome, int cpf, String endereco, int numeroCartaoSus, String email, String telefone, int idade,
                  String profissao, List<String> comorbidades) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroCartaoSus = numeroCartaoSus;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.idade = idade;
        this.comorbidades = comorbidades;
    }

    public int getIdade() {
        return idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public List<String> getComorbidades() {
        return comorbidades;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setComorbidades(List<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    @Override
    public String toString() {
        return  " - Nome: '" + nome + '\'' + "\n" +
                " - CPF: " + cpf + "\n" +
                " - Endereço: '" + endereco + '\'' + "\n" +
                " - Número Cartão SUS:" + numeroCartaoSus + "\n" +
                " - Email: '" + email+ '\'' + "\n" +
                " - Telefone: '" + telefone + '\'' + "\n" +
                " - Idade: " + idade + "\n" +
                " - Profissão: '" + profissao + '\'' + "\n" +
                " - Comorbidades: " + comorbidades + ".\n";
    }
}
