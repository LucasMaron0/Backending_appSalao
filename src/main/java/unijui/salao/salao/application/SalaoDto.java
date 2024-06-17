package unijui.salao.salao.application;

import lombok.Data;
import unijui.salao.funcionario.domain.Funcionario;
import unijui.salao.salao.domain.Salao;

import java.util.ArrayList;
import java.util.List;


@Data
public class SalaoDto {

    private int idSalao;
    private String nomeSalao;
    private  List<String> funcionarios;


    public SalaoDto(Salao salao){
        this.idSalao = salao.getId();
        this.nomeSalao = salao.getNome();
        this.funcionarios = getNomeFuncionariosSalao(salao.getFuncionarios());

    }

    private List<String> getNomeFuncionariosSalao(List<Funcionario> funcionarios){
        ArrayList<String> nomes = new ArrayList<>();
        for(Funcionario f: funcionarios){
            nomes.add(f.getNome());
        }
        return nomes;
    }

    public static List<SalaoDto> converterLista(List<Salao> saloes){
        ArrayList<SalaoDto> saloesDto = new ArrayList<>();
        for(Salao s:saloes){
            saloesDto.add(new SalaoDto(s));
        }
        return saloesDto;
    }

}
