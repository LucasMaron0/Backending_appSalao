package unijui.salao.salao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unijui.salao.clientes.Cliente;
import unijui.salao.clientes.ClienteForm;

import java.util.List;

@RestController
@RequestMapping("/salao")
public class SalaoController {

    @Autowired
    private SalaoService salaoService;

    @GetMapping()
    public List<SalaoDto> buscarAgendamentoPorSalao() {
        return salaoService.buscarTodosSaloes();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Salao> criarCliente(@RequestBody SalaoForm form) {
        Salao novoSalao = salaoService.cadastrarSalao(form);
        return new ResponseEntity<>(novoSalao, HttpStatus.CREATED);
    }
}
