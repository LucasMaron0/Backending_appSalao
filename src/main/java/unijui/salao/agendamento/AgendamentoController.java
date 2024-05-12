package unijui.salao.agendamento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unijui.salao.clientes.Cliente;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/salao/{idSalao}")
    public List<AgendamentoDto> buscarAgendamentoPorSalao(@PathVariable int idSalao) {
        return agendamentoService.buscarAgendamentosSalao(idSalao);
    }

    @GetMapping("/cliente/{idCliente}")
    public List<AgendamentoDto> buscarAgendamentoPorCliente(@PathVariable int idCliente) {
        return agendamentoService.buscarAgendamentosCliente(idCliente);
    }

    @GetMapping("/funcionario/{idFuncionario}")
    public List<AgendamentoDto> buscarAgendamentoPorFuncionario(@PathVariable int idFuncionario) {
        return agendamentoService.buscarAgendamentosFuncionario(idFuncionario);
    }

    @PostMapping("/cadastrar")
    public AgendamentoDto buscarAgendamentoPorFuncionario(@RequestBody AgendamentoForm form) {
        return agendamentoService.cadastrarAgendamento(form);
    }
}
