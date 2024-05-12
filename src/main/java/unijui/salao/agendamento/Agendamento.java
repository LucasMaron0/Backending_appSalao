package unijui.salao.agendamento;

import jakarta.persistence.*;
import lombok.*;
import unijui.salao.clientes.Cliente;
import unijui.salao.funcionario.Funcionario;
import unijui.salao.salao.Salao;
import unijui.salao.utils.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "salao_id")
    private Salao salao;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    private Date dataInicio;
    private Date dataFim;
    private String servico;

    public Agendamento (AgendamentoForm form, Salao salao, Funcionario funcionario, Cliente cliente){
        this.cliente = cliente;
        this.salao = salao;
        this.funcionario = funcionario;
        this.dataInicio = DateUtils.stringParaData(form.getInicio());
        this.dataFim = DateUtils.stringParaData(form.getFim());
    }

}
