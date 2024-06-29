package unijui.salao.funcionario.application;

import lombok.Data;

import java.util.List;

@Data
public class FuncionarioUpdateForm {
    private int idFuncionario;
    private List<String> servicos;
}
