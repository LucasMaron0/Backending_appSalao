package unijui.salao.domain.funcionario;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import unijui.salao.application.funcionario.FuncionarioDto;
import unijui.salao.application.funcionario.FuncionarioForm;
import unijui.salao.domain.salao.Salao;
import unijui.salao.infrastructure.funcionario.FuncionarioRepository;
import unijui.salao.infrastructure.salao.SalaoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {


    private FuncionarioRepository funcionarioRepo;
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
