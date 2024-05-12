package unijui.salao.funcionario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unijui.salao.agendamento.AgendamentoDto;
import unijui.salao.clientes.Cliente;
import unijui.salao.salao.Salao;
import unijui.salao.salao.SalaoForm;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDto> buscartodosFuncionarios() {
        return funcionarioService.buscarTodosFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionarioDto buscarFuncionarioPorId(@PathVariable int id) {
        return funcionarioService.buscarFuncionarioPorId(id);
    }

    @GetMapping("/salao/{idSalao}")
    public List<FuncionarioDto> buscarAgendamentoPorCliente(@PathVariable int idSalao) {
        return funcionarioService.buscarFuncionariosPorSalao(idSalao);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<FuncionarioDto> criarCliente(@RequestBody FuncionarioForm form) {
        FuncionarioDto novoFuncionario = funcionarioService.cadastrarFuncionario(form);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

}
