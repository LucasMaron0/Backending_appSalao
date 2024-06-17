package unijui.salao.funcionario.domain;



import unijui.salao.funcionario.application.FuncionarioDto;
import unijui.salao.funcionario.application.FuncionarioForm;

import java.util.List;


public interface FuncionarioService {

    public FuncionarioDto buscarFuncionarioPorId(int id);

    public List<FuncionarioDto> buscarTodosFuncionarios();

    public List<FuncionarioDto> buscarFuncionariosPorSalao(int idSalao);

    public FuncionarioDto cadastrarFuncionario(FuncionarioForm form);
}
