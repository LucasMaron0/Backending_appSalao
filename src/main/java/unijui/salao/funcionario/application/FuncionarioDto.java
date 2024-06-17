package unijui.salao.funcionario.application;

import lombok.Data;
import unijui.salao.funcionario.domain.Funcionario;
import unijui.salao.utils.enums.Servicos;

import java.util.ArrayList;
import java.util.List;

@Data
public class FuncionarioDto {

    private String nomeFuncionario;
    private String nomeSalao;
    private List<Servicos> servicosPrestados;


    public FuncionarioDto (Funcionario funcionario){
        this.nomeFuncionario = funcionario.getNome();
        this.nomeSalao = funcionario.getSalao().getNome();
        this.servicosPrestados = funcionario.getServicosPrestados();
    }

    public static List<FuncionarioDto> converterLista(List<Funcionario> funcionarios){
        ArrayList<FuncionarioDto> funcionariosDto = new ArrayList<>();
        for(Funcionario f:funcionarios){
            funcionariosDto.add(new FuncionarioDto(f));
        }
        return funcionariosDto;
    }

}