package unijui.salao.salao.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import unijui.salao.salao.application.SalaoForm;
import unijui.salao.funcionario.domain.Funcionario;
import unijui.salao.user.domain.User;

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
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "salao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Funcionario> funcionarios;

    public Salao (SalaoForm form){
        this.nome = form.getNomeSalao();
        this.user = form.getUser();
    }
}
