package unijui.salao.domain.salao;

import unijui.salao.application.salao.SalaoDto;
import unijui.salao.application.salao.SalaoForm;

import java.util.List;

public interface SalaoService {

    public List<SalaoDto> buscarTodosSaloes();

    public Salao cadastrarSalao(SalaoForm form);
}
