package unijui.salao.cliente.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unijui.salao.cliente.application.ClienteForm;
import unijui.salao.user.domain.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Cliente (ClienteForm form){
        this.nome = form.getNome();
        this.user = form.getUser();
    }
}
