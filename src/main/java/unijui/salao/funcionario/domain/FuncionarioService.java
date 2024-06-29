package unijui.salao.funcionario.domain;



import org.springframework.http.ResponseEntity;
import unijui.salao.funcionario.application.FuncionarioUpdateForm;
import unijui.salao.domain.PeriodoDto;
import unijui.salao.funcionario.application.FuncionarioDto;
import unijui.salao.funcionario.application.FuncionarioForm;

import java.text.ParseException;
import java.util.List;


public interface FuncionarioService {

    FuncionarioDto buscarFuncionarioPorId(int id);

    List<FuncionarioDto> buscarTodosFuncionarios();

    List<FuncionarioDto> buscarFuncionariosPorSalao(int idSalao);

    FuncionarioDto cadastrarFuncionario(FuncionarioForm form);

    List<PeriodoDto>  buscarPeriodosLivres (int idFuncionario) throws ParseException;
    ResponseEntity<Void> deleterFuncionario(int idFuncionario);

    ResponseEntity<FuncionarioDto> atualizarServicosFuncionario(FuncionarioUpdateForm form);
}
