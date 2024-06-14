package unijui.salao.infrastructure.agendamento;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unijui.salao.application.agendamento.AgendamentoDto;
import unijui.salao.application.agendamento.AgendamentoForm;
import unijui.salao.domain.agendamento.AgendamentoService;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@AllArgsConstructor
public class AgendamentoController {


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
