package unijui.salao.funcionario.application;

import lombok.Data;

import java.util.List;

@Data
public class FuncionarioForm {
    private String nome;
    private int idSalao;
    private List<String> servicos;
}
