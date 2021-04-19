package Models;

import States.EstadoNaoHabilitado;
import States.EstadoVacinacao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistroVacinacao {
    private Pessoa pessoa;
    private boolean vacinado;
    private Date dataVacinacaoDose1;
    private EstadoVacinacao estadoVacinacao;

    public RegistroVacinacao(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.vacinado = false;
        this.dataVacinacaoDose1 = null;
        this.estadoVacinacao = new EstadoNaoHabilitado();
    }

    public void vacina() {
        this.vacinado = true;
    }

    public void atualizarEstado(int minIdadeVacinacao, List<String> profissoesVacinacao, List<String> comorbidadesVacinacao) {
        estadoVacinacao.alterarEstado(this, minIdadeVacinacao, profissoesVacinacao, comorbidadesVacinacao);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public Date getDataVacinacaoDose1() {
        return dataVacinacaoDose1;
    }

    public EstadoVacinacao getEstadoVacinacao() {
        return estadoVacinacao;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    public void setDataVacinacaoDose1(Date dataVacinacaoDose1) {
        this.dataVacinacaoDose1 = dataVacinacaoDose1;
    }

    public void setEstadoVacinacao(EstadoVacinacao estadoVacinacao) {
        this.estadoVacinacao = estadoVacinacao;
    }

    @Override
    public String toString() {
        String infoDataVacinacaoDose1 = "";

        if(dataVacinacaoDose1 != null) {
            infoDataVacinacaoDose1 = String.valueOf(TimeUnit.DAYS.convert(dataVacinacaoDose1.getTime(), TimeUnit.MILLISECONDS)) + "; ";
        }
        return "Informações Pessoais: \n" + pessoa +
                " " + infoDataVacinacaoDose1 +
                "Estado da Vacinacao: " + estadoVacinacao + ".\n";
    }
}
