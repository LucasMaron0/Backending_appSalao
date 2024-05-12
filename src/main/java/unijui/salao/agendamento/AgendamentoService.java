package unijui.salao.agendamento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unijui.salao.clientes.Cliente;
import unijui.salao.clientes.ClienteRepository;
import unijui.salao.funcionario.*;
import unijui.salao.salao.Salao;
import unijui.salao.salao.SalaoRepository;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepo;

    @Autowired
    private SalaoRepository salaoRepo;

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    @Autowired
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
