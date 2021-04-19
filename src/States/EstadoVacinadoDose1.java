package States;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import Models.RegistroVacinacao;

public class EstadoVacinadoDose1 implements EstadoVacinacao {
    @Override
    public void alterarEstado(RegistroVacinacao registro, int minIdadeVacinacao, List<String> profissoesVacinacao,
                              List<String> comorbidadesVacinacao) {
        if(registro.getDataVacinacaoDose1() == null) {
            throw new RuntimeException();
        }

        Date dataVacinacaoDose1 = registro.getDataVacinacaoDose1();
        Date dataAtual = new Date();

        long diferencaTempoMs = Math.abs(dataAtual.getTime() - dataVacinacaoDose1.getTime());

        long diferencaTempoDias = TimeUnit.DAYS.convert(diferencaTempoMs, TimeUnit.MILLISECONDS);

        if(diferencaTempoDias >= 20) {
            registro.setEstadoVacinacao(new EstadoHabilitadoDose2());
        }
    }

    @Override
    public String toString() {
        return "Tomou a primeira dose";
    }
}
