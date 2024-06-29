package unijui.salao.agendamento.domain;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import unijui.salao.cliente.domain.Cliente;
import unijui.salao.funcionario.domain.Funcionario;
import unijui.salao.salao.domain.Salao;
import unijui.salao.agendamento.infra.AgendamentoRepository;
import unijui.salao.agendamento.application.AgendamentoDto;
import unijui.salao.agendamento.application.AgendamentoForm;
import unijui.salao.cliente.infra.ClienteRepository;
import unijui.salao.funcionario.infra.FuncionarioRepository;
import unijui.salao.salao.infra.SalaoRepository;
import unijui.salao.domain.Periodo;

import java.util.List;

@Service
@AllArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService {


    private AgendamentoRepository agendamentoRepo;
    private SalaoRepository salaoRepo;
    private FuncionarioRepository funcionarioRepo;
    private ClienteRepository clienteRepo;


    public List<AgendamentoDto> buscarAgendamentosSalao(int idSalao){
        return AgendamentoDto.converterLista(agendamentoRepo.findAllBySalaoId(idSalao));
    }

    public List<AgendamentoDto> buscarAgendamentosCliente(int idCliente){
        return AgendamentoDto.converterLista(agendamentoRepo.findAllByClienteId(idCliente));
    }

    public List<AgendamentoDto> buscarAgendamentosFuncionario(int idFuncionario){
        return AgendamentoDto.converterLista(agendamentoRepo.findAllByFuncionarioId(idFuncionario));
    }

    public AgendamentoDto cadastrarAgendamento(AgendamentoForm form){
        Salao salao = salaoRepo.findById(form.getIdSalao());
        Funcionario funcionario = funcionarioRepo.findById(form.getIdFuncionario());
        Cliente cliente = clienteRepo.findById(form.getIdCliente());

        return new AgendamentoDto(agendamentoRepo.save(new Agendamento(form, salao, funcionario, cliente)));
    }

    @Override
    public List<Periodo> buscarPeriodosAgendadosFuncionario(int idFuncionario) {
        return Periodo.buscarPeriodosAgendadosFuncionario(agendamentoRepo.findAllByFuncionarioId(idFuncionario));
    }
}
