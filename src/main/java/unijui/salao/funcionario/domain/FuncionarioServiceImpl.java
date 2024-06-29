package unijui.salao.funcionario.domain;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unijui.salao.agendamento.domain.AgendamentoService;
import unijui.salao.funcionario.application.FuncionarioUpdateForm;
import unijui.salao.domain.PeriodoDto;
import unijui.salao.funcionario.application.FuncionarioDto;
import unijui.salao.funcionario.application.FuncionarioForm;
import unijui.salao.salao.domain.Salao;
import unijui.salao.funcionario.infra.FuncionarioRepository;
import unijui.salao.salao.infra.SalaoRepository;
import unijui.salao.utils.DateUtils;
import unijui.salao.domain.Periodo;

import java.text.ParseException;
import java.util.List;


@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {


    private FuncionarioRepository funcionarioRepo;
    private SalaoRepository salaoRepo;
    private AgendamentoService agendamentoService;

    @Override
    public FuncionarioDto buscarFuncionarioPorId(int id){
        return new FuncionarioDto(funcionarioRepo.findById(id));
    }

    @Override
    public List<FuncionarioDto> buscarTodosFuncionarios(){
        return FuncionarioDto.converterLista(funcionarioRepo.findAll());
    }
    @Override
    public List<FuncionarioDto> buscarFuncionariosPorSalao(int idSalao){
        return FuncionarioDto.converterLista(funcionarioRepo.findAllBySalaoId(idSalao));
    }
    @Override
    public FuncionarioDto cadastrarFuncionario(FuncionarioForm form){
        Salao salao = salaoRepo.findById(form.getIdSalao());
        return new FuncionarioDto(funcionarioRepo.save(new Funcionario(form, salao)));
    }
    @Override
    public List<PeriodoDto>  buscarPeriodosLivres (int idFuncionario) throws ParseException {
        return Periodo.filtrarHorariosLivresFuncionario(
                DateUtils.getHorarios(),
                agendamentoService.buscarPeriodosAgendadosFuncionario(idFuncionario)
        );
    }
    @Override
    public  ResponseEntity<FuncionarioDto> atualizarServicosFuncionario(FuncionarioUpdateForm form){
        Funcionario funcionario = funcionarioRepo.findById(form.getIdFuncionario());
        funcionario.setServicosPrestados(form.getServicos());
        funcionarioRepo.save(funcionario);
        return ResponseEntity.ok(new FuncionarioDto(funcionario));
    }

    @Override
    public ResponseEntity<Void> deleterFuncionario(int idFuncionario){
        Funcionario funcionario = funcionarioRepo.findById(idFuncionario);
        funcionarioRepo.delete(funcionario);
        return ResponseEntity.noContent().build();
    }

}
