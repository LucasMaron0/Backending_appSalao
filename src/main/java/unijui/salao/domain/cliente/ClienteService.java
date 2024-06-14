package unijui.salao.domain.cliente;



import unijui.salao.application.cliente.ClienteForm;

import java.util.List;

public interface ClienteService {

    public Cliente buscarClientePorId(int id);

    public List<Cliente> buscarTodosCLientes();

    public Cliente cadastrarCliente(ClienteForm form);
}
