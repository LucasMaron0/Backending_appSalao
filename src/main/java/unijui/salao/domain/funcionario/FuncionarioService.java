package unijui.salao.domain.funcionario;



import unijui.salao.application.funcionario.FuncionarioDto;
import unijui.salao.application.funcionario.FuncionarioForm;

import java.util.List;


public interface FuncionarioService {

    public FuncionarioDto buscarFuncionarioPorId(int id);

    public List<FuncionarioDto> buscarTodosFuncionarios();

    public List<FuncionarioDto> buscarFuncionariosPorSalao(int idSalao);

    public FuncionarioDto cadastrarFuncionario(FuncionarioForm form);
}
