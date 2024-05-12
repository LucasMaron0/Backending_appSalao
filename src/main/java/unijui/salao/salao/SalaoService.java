package unijui.salao.salao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unijui.salao.clientes.Cliente;
import unijui.salao.clientes.ClienteForm;

import java.util.List;

@Service
public class SalaoService {

    @Autowired
    private SalaoRepository salaoRepo;

    public List<SalaoDto> buscarTodosSaloes(){
        return SalaoDto.converterLista(salaoRepo.findAll());
    }
    public Salao cadastrarSalao(SalaoForm form){
        return salaoRepo.save(new Salao(form));
    }

}
