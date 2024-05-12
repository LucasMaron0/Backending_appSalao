package unijui.salao.agendamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AgendamentoForm {

    private int idSalao;
    private int idFuncionario;
    private int idCliente;
    private String inicio;
    private String fim;
}
