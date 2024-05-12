package unijui.salao.clientes;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
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
