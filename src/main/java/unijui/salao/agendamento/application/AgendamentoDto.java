package unijui.salao.agendamento.application;

import lombok.Data;
import unijui.salao.agendamento.domain.Agendamento;
import unijui.salao.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;


@Data
public class AgendamentoDto {

    private int idAgendamento;
    private String nomeSalao;
    private String nomeCliente;
    private String nomeFuncionario;
    private String inicio;
    private String fim;


    public AgendamentoDto(Agendamento agendamento){
        this.idAgendamento = agendamento.getId();
        this.nomeSalao = agendamento.getSalao().getNome();
        this.nomeCliente = agendamento.getCliente().getNome();
        this.nomeFuncionario = agendamento.getFuncionario().getNome();
        this.inicio = DateUtils.dataParaString(agendamento.getDataInicio());
        this.fim = DateUtils.dataParaString(agendamento.getDataFim());
    }

    public static List<AgendamentoDto> converterLista(List<Agendamento> agendamentos){
        ArrayList<AgendamentoDto> agendamentosDto = new ArrayList<>();
        for(Agendamento a:agendamentos){
            agendamentosDto.add(new AgendamentoDto(a));
        }
        return agendamentosDto;
    }

}
