package unijui.salao.agendamento.domain;


import unijui.salao.agendamento.application.AgendamentoDto;
import unijui.salao.agendamento.application.AgendamentoForm;

import java.util.List;

public interface AgendamentoService {

    public List<AgendamentoDto> buscarAgendamentosSalao(int idSalao);


    public List<AgendamentoDto> buscarAgendamentosCliente(int idCliente);

    public List<AgendamentoDto> buscarAgendamentosFuncionario(int idFuncionario);

    public AgendamentoDto cadastrarAgendamento(AgendamentoForm form);
}
