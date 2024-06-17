package unijui.salao.cliente.domain;



import unijui.salao.cliente.application.ClienteForm;

import java.util.List;

public interface ClienteService {

    public Cliente buscarClientePorId(int id);

    public List<Cliente> buscarTodosCLientes();

    public Cliente cadastrarCliente(ClienteForm form);
}
