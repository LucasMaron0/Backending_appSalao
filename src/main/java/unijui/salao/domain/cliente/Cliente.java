package unijui.salao.domain.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unijui.salao.application.cliente.ClienteForm;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;


    public Cliente (ClienteForm form){
        this.nome = form.getNome();
    }
}
