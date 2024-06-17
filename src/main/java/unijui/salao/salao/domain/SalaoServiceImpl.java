package unijui.salao.salao.domain;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import unijui.salao.salao.application.SalaoDto;
import unijui.salao.salao.application.SalaoForm;
import unijui.salao.salao.infra.SalaoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SalaoServiceImpl implements SalaoService {


    private SalaoRepository salaoRepo;

    @Override
    public List<SalaoDto> buscarTodosSaloes(){
        return SalaoDto.converterLista(salaoRepo.findAll());
    }
    @Override
    public Salao cadastrarSalao(SalaoForm form){
        return salaoRepo.save(new Salao(form));
    }

    @Override
    public Salao buscarSalaoDoUsuario(int userId) {
        return salaoRepo.findByUserId(userId);
    }

}
