package States;

import Models.RegistroVacinacao;

import java.util.Date;
import java.util.List;

public class EstadoHabilitadoDose1 implements EstadoVacinacao {

    @Override
    public void alterarEstado(RegistroVacinacao registro, int minIdadeVacinacao, List<String> profissoesVacinacao,
                              List<String> comorbidadesVacinacao) {
        if(registro.isVacinado()) {
            registro.setEstadoVacinacao(new EstadoVacinadoDose1());
            registro.setDataVacinacaoDose1(new Date());
            registro.setVacinado(false);
        }
    }

    @Override
    public String toString() {
        return "Habilitado para tomar a primeira dose";
    }
}
