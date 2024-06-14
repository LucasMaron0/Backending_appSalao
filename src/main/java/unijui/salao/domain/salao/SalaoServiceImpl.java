package unijui.salao.domain.salao;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import unijui.salao.application.salao.SalaoDto;
import unijui.salao.application.salao.SalaoForm;
import unijui.salao.infrastructure.salao.SalaoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SalaoServiceImpl implements SalaoService {


    private SalaoRepository salaoRepo;

    public List<SalaoDto> buscarTodosSaloes(){
        return SalaoDto.converterLista(salaoRepo.findAll());
    }
    public Salao cadastrarSalao(SalaoForm form){
        return salaoRepo.save(new Salao(form));
    }

}
