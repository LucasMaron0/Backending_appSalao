package unijui.salao.salao.domain;

import unijui.salao.salao.application.SalaoDto;
import unijui.salao.salao.application.SalaoForm;

import java.util.List;

public interface SalaoService {

    public List<SalaoDto> buscarTodosSaloes();

    public Salao cadastrarSalao(SalaoForm form);

    public Salao buscarSalaoDoUsuario(int userId);
}
