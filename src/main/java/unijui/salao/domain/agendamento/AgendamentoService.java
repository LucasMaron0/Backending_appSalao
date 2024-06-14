package unijui.salao.domain.agendamento;


import unijui.salao.application.agendamento.AgendamentoDto;
import unijui.salao.application.agendamento.AgendamentoForm;

import java.util.List;

public interface AgendamentoService {

    public List<AgendamentoDto> buscarAgendamentosSalao(int idSalao);


    public List<AgendamentoDto> buscarAgendamentosCliente(int idCliente);

    public List<AgendamentoDto> buscarAgendamentosFuncionario(int idFuncionario);

    public AgendamentoDto cadastrarAgendamento(AgendamentoForm form);
}
