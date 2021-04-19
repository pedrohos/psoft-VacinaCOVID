package Controllers;

import Models.Pessoa;
import Models.RegistroVacinacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroController {
    private Map<Integer, RegistroVacinacao> registros;
    private int minIdadeVacinacao;
    private List<String> comorbidadesHabilitadas;
    private List<String> profissoesHabilitadas;

    public RegistroController() {
        this.registros = new HashMap<>();
        this.minIdadeVacinacao = Integer.MAX_VALUE;
        this.comorbidadesHabilitadas = new ArrayList<>();
        this.profissoesHabilitadas = new ArrayList<>();
    }

    public void inserirRegistro(String nome, int cpf, String endereco, int numeroCartaoSus, String email, String telefone,
                         int idade, String profissao, List<String> comorbidades) {
        if(nome == null || cpf == 0 || endereco == null || numeroCartaoSus == 0 || email == null || telefone == null ||
                profissao == null || comorbidades == null) {
            throw new IllegalArgumentException();
        }

        Pessoa pessoa = new Pessoa(nome, cpf, endereco, numeroCartaoSus, email, telefone, idade, profissao, comorbidades);
        this.registros.put(cpf, new RegistroVacinacao(pessoa));
    }

    public void atualizarPessoa(int cpf, String endereco, String email, String telefone,
                                String profissao, List<String> comorbidades) {
        if(endereco == null || email == null || telefone == null || profissao == null || comorbidades == null ||
            !this.registros.containsKey(cpf)) {
            throw new IllegalArgumentException();
        }

        Pessoa pessoa = this.registros.get(cpf).getPessoa();

        if(!endereco.isEmpty()) {
            pessoa.setEndereco(endereco);
        }

        if(!email.isEmpty()) {
            pessoa.setEmail(email);
        }

        if(!telefone.isEmpty()) {
            pessoa.setTelefone(telefone);
        }

        if(!profissao.isEmpty()) {
            pessoa.setProfissao(profissao);
        }

        if(!comorbidades.isEmpty()) {
            pessoa.setComorbidades(comorbidades);
        }
    }

    public void inserirComorbidade(String comorbidadeHabilitada) {
        if(comorbidadeHabilitada == null || comorbidadeHabilitada.isEmpty()) {
            throw new IllegalArgumentException();
        }

        comorbidadesHabilitadas.add(comorbidadeHabilitada);
        atualizarRegistros();
    }

    public void inserirProfissao(String profissaoHabilitada) {
        if(profissaoHabilitada == null || profissaoHabilitada.isEmpty()) {
            throw new IllegalArgumentException();
        }

        profissoesHabilitadas.add(profissaoHabilitada);
        atualizarRegistros();
    }

    public void atualizarRegistros() {
        for(RegistroVacinacao registro: registros.values()) {
            registro.atualizarEstado(minIdadeVacinacao, profissoesHabilitadas, comorbidadesHabilitadas);
        }
    }

    public void vacina(int cpf) {
        if(!registros.containsKey(cpf)) {
            throw new IllegalArgumentException();
        }

        RegistroVacinacao registro = registros.get(cpf);

        registro.vacina();
        registro.atualizarEstado(minIdadeVacinacao, profissoesHabilitadas, comorbidadesHabilitadas);
    }

    public void setMinIdadeVacinacao(int minIdadeVacinacao) {
        if(minIdadeVacinacao < 0 || minIdadeVacinacao > 150) {
            throw new IllegalArgumentException();
        }

        this.minIdadeVacinacao = minIdadeVacinacao;

        atualizarRegistros();
    }

    public String getStatusPessoa(int cpf) {
        if(!registros.containsKey(cpf)) {
            throw new IllegalArgumentException();
        }

        return registros.get(cpf).toString();
    }

    @Override
    public String toString() {
        return "\nTodos os registros: " +
                "\n[\n" + registros.values() +
                "\n]\n" + "Informações do Sistema: \n" +
                " Idade mínima para vacinação: " + minIdadeVacinacao +
                "\n Comorbidades habilitadas para vacinação: " + comorbidadesHabilitadas +
                "\n Profissões habilitadas para vacinação: " + profissoesHabilitadas + "\n";
    }
}
