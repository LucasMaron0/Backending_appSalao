package unijui.salao.agendamento.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import unijui.salao.agendamento.application.AgendamentoForm;
import unijui.salao.cliente.domain.Cliente;
import unijui.salao.funcionario.domain.Funcionario;
import unijui.salao.salao.domain.Salao;
import unijui.salao.utils.DateUtils;

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

    @ManyToOne()
    @JoinColumn(name = "funcionario_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Funcionario funcionario;

    private Date dataInicio;
    private Date dataFim;
    private String servico;

    public Agendamento (AgendamentoForm form, Salao salao, Funcionario funcionario, Cliente cliente){
        this.cliente = cliente;
        this.servico = form.getServico();
        this.salao = salao;
        this.funcionario = funcionario;
        this.dataInicio = DateUtils.stringParaData(form.getInicio());
        this.dataFim = DateUtils.stringParaData(form.getFim());
    }

}
