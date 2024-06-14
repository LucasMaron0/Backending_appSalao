package unijui.salao.domain.agendamento;

import jakarta.persistence.*;
import lombok.*;
import unijui.salao.application.agendamento.AgendamentoForm;
import unijui.salao.domain.cliente.Cliente;
import unijui.salao.domain.funcionario.Funcionario;
import unijui.salao.domain.salao.Salao;
import unijui.salao.domain.utils.DateUtils;

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
