package unijui.salao.domain.agendamento;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import unijui.salao.domain.cliente.Cliente;
import unijui.salao.domain.funcionario.Funcionario;
import unijui.salao.domain.salao.Salao;
import unijui.salao.infrastructure.agendamento.AgendamentoRepository;
import unijui.salao.application.agendamento.AgendamentoDto;
import unijui.salao.application.agendamento.AgendamentoForm;
import unijui.salao.infrastructure.cliente.ClienteRepository;
import unijui.salao.infrastructure.funcionario.FuncionarioRepository;
import unijui.salao.infrastructure.salao.SalaoRepository;

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

}
