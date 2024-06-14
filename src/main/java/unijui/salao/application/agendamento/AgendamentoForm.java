package unijui.salao.application.agendamento;

import lombok.Data;

@Data
public class AgendamentoForm {

    private int idSalao;
    private int idFuncionario;
    private int idCliente;
    private String inicio;
    private String fim;
}
