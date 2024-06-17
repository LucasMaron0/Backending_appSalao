package unijui.salao.salao.infra;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unijui.salao.salao.domain.Salao;
import unijui.salao.salao.domain.SalaoService;
import unijui.salao.salao.application.SalaoDto;
import unijui.salao.salao.application.SalaoForm;

import java.util.List;

@RestController
@RequestMapping("/salao")
@AllArgsConstructor
public class SalaoController {

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
