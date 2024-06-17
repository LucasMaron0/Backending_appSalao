package unijui.salao.funcionario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unijui.salao.funcionario.application.FuncionarioForm;
import unijui.salao.salao.domain.Salao;
import unijui.salao.utils.enums.Servicos;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "salao_residente_id")
    private Salao salao;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Servicos.class)
    @CollectionTable(name = "funcionario_servicos", joinColumns = @JoinColumn(name = "funcionario_id"))
    @Column(name = "servico")
    private List<Servicos> servicosPrestados;



    public Funcionario (FuncionarioForm form, Salao salao){
        this.nome = form.getNome();
        this.salao = salao;
        this.servicosPrestados = Servicos.converterParaEnum(form.getServicos());
    }
}
