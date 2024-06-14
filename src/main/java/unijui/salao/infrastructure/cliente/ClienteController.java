package unijui.salao.infrastructure.cliente;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unijui.salao.application.cliente.ClienteForm;
import unijui.salao.domain.cliente.Cliente;
import unijui.salao.domain.cliente.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {


    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscarTodosClientes() {
        return clienteService.buscarTodosCLientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable int id) {
        return clienteService.buscarClientePorId(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteForm form) {
        Cliente novoCliente = clienteService.cadastrarCliente(form);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
}
