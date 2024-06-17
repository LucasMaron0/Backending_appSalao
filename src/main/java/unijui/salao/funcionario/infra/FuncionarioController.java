package unijui.salao.funcionario.infra;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unijui.salao.funcionario.domain.FuncionarioService;
import unijui.salao.funcionario.application.FuncionarioDto;
import unijui.salao.funcionario.application.FuncionarioForm;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@AllArgsConstructor
public class FuncionarioController {


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
