package States;

import Models.RegistroVacinacao;

import java.util.List;

public class EstadoHabilitadoDose2 implements EstadoVacinacao{
    @Override
    public void alterarEstado(RegistroVacinacao registro, int minIdadeVacinacao, List<String> profissoesVacinacao,
                              List<String> comorbidadesVacinacao) {
        if(registro.isVacinado()) {
            registro.setEstadoVacinacao(new EstadoVacinacaoFinalizada());
        }
    }

    @Override
    public String toString() {
        return "Habilitado para tomar a segunda dose";
    }
}
