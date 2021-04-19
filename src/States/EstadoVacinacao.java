package States;

import Models.RegistroVacinacao;

import java.util.List;

public interface EstadoVacinacao {
    void alterarEstado(RegistroVacinacao registroVacinacao, int minIdadeVacinacao, List<String> profissoesVacinacao,
                       List<String> comorbidadesVacinacao);
}
