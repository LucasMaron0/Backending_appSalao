package unijui.salao.domain.salao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import unijui.salao.application.salao.SalaoForm;
import unijui.salao.domain.funcionario.Funcionario;

import java.util.List;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Salao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany(mappedBy = "salao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Funcionario> funcionarios;

    public Salao (SalaoForm form){
        this.nome = form.getNomeSalao();
    }
}
