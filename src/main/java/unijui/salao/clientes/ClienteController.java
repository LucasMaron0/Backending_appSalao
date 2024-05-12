package unijui.salao.clientes;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
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
