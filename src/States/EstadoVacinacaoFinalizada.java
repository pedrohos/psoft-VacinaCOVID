package States;

import Models.RegistroVacinacao;

import java.util.List;

public class EstadoVacinacaoFinalizada implements EstadoVacinacao {

    @Override
    public void alterarEstado(RegistroVacinacao registro, int minIdadeVacinacao, List<String> profissoesVacinacao,
                              List<String> comorbidadesVacinacao) {

    }

    @Override
    public String toString() {
        return "Vacinação Finalizada";
    }
}
