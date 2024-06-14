package unijui.salao.domain.cliente;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import unijui.salao.application.cliente.ClienteForm;
import unijui.salao.infrastructure.cliente.ClienteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private ClienteRepository clienteRepo;


    public Cliente buscarClientePorId(int id){
        return clienteRepo.findById(id);
    }

    public List<Cliente> buscarTodosCLientes(){
        return clienteRepo.findAll();
    }

    public Cliente cadastrarCliente(ClienteForm form){
        return clienteRepo.save(new Cliente(form));
    }

}
