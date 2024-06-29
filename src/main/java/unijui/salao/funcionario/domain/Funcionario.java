package unijui.salao.funcionario.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unijui.salao.funcionario.application.FuncionarioForm;
import unijui.salao.salao.domain.Salao;


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
    @JsonBackReference
    private Salao salao;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "funcionario_servicos", joinColumns = @JoinColumn(name = "funcionario_id"))
    @Column(name = "servico")
    private List<String> servicosPrestados;



    public Funcionario (FuncionarioForm form, Salao salao){
        this.nome = form.getNome();
        this.salao = salao;
        this.servicosPrestados = form.getServicos();
    }
}
