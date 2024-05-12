package unijui.salao.funcionario;

import lombok.Data;

import java.util.List;

@Data
public class FuncionarioForm {
    private String nome;
    private int idSalao;
    private List<String> servicos;
}
