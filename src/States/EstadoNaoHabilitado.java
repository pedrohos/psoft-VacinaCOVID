package States;

import java.util.List;
import Models.RegistroVacinacao;

public class EstadoNaoHabilitado implements EstadoVacinacao {

    @Override
    public void alterarEstado(RegistroVacinacao registro, int minIdadeVacinacao, List<String> profissoesVacinacao, List<String> comorbidadesVacinacao) {
        boolean alterarEstado = false;

        int idadePessoa = registro.getPessoa().getIdade();
        String profissaoPessoa = registro.getPessoa().getProfissao();
        List<String> comorbidadesPessoa = registro.getPessoa().getComorbidades();

        if(idadePessoa >= minIdadeVacinacao) {
            alterarEstado = true;
        } else {
            alterarEstado = profissaoPessoaEstaHabilitada(profissoesVacinacao, profissaoPessoa);

            if(!alterarEstado) {
                alterarEstado = comorbidadePessoaEstaHabilitada(comorbidadesVacinacao, comorbidadesPessoa);
            }
        }

        if(alterarEstado) {
            registro.setEstadoVacinacao(new EstadoHabilitadoDose1());
        }

    }

    private boolean profissaoPessoaEstaHabilitada(List<String> profissoesVacinacao, String profissaoPessoa) {
        for(String profissaoHabilitada: profissoesVacinacao) {
            if(profissaoPessoa == profissaoHabilitada) {
                return true;
            }
        }
        return false;
    }

    private boolean comorbidadePessoaEstaHabilitada(List<String> comorbidadesVacinacao, List<String> comorbidadesPessoa) {
        for(String comborbidadeHabilitada: comorbidadesVacinacao) {
            for(String comorbidadePessoa: comorbidadesPessoa) {
                if(comorbidadePessoa == comborbidadeHabilitada) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Não habilitado para tomar a vacina";
    }
}
