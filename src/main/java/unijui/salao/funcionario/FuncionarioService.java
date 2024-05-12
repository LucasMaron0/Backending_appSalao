package unijui.salao.funcionario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unijui.salao.clientes.Cliente;
import unijui.salao.salao.Salao;
import unijui.salao.salao.SalaoForm;
import unijui.salao.salao.SalaoRepository;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    @Autowired
    private SalaoRepository salaoRepo;


    public FuncionarioDto buscarFuncionarioPorId(int id){
        return new FuncionarioDto(funcionarioRepo.findById(id));
    }

    public List<FuncionarioDto> buscarTodosFuncionarios(){
        return FuncionarioDto.converterLista(funcionarioRepo.findAll());
    }

    public List<FuncionarioDto> buscarFuncionariosPorSalao(int idSalao){
        return FuncionarioDto.converterLista(funcionarioRepo.findAllBySalaoId(idSalao));
    }

    public FuncionarioDto cadastrarFuncionario(FuncionarioForm form){
        Salao salao = salaoRepo.findById(form.getIdSalao());
        return new FuncionarioDto(funcionarioRepo.save(new Funcionario(form, salao)));
    }

}
