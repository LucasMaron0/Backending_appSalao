package unijui.salao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unijui.salao.agendamento.domain.Agendamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class Periodo {

    private Date dataInicio;
    private Date dataFim;


    public static List<Periodo> buscarPeriodosAgendadosFuncionario(List<Agendamento> agendamentos){
        List<Periodo> periodosAgendados = new ArrayList<>();
        for(Agendamento a:agendamentos){
            periodosAgendados.add(new Periodo(a.getDataInicio(), a.getDataFim()));
        }
        return periodosAgendados;
    }
    public static List<PeriodoDto> filtrarHorariosLivresFuncionario(List<Periodo> horariosBase, List<Periodo> horariosAgendados ){
        List<PeriodoDto> horairosLivres = new ArrayList<>();

        for(Periodo horario: horariosBase){
            boolean deveAdicionar = true;
            for(Periodo agendado: horariosAgendados){
                if (horario.getDataInicio().equals(agendado.getDataInicio())){
                    deveAdicionar = false;
                }
            }
            if(deveAdicionar){
                horairosLivres.add(new PeriodoDto(horario));
            }
        }
        return horairosLivres;
    }
}
