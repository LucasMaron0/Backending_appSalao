package unijui.salao.user.application;

import lombok.Data;
import unijui.salao.cliente.domain.Cliente;
import unijui.salao.salao.domain.Salao;
import unijui.salao.user.domain.User;
import unijui.salao.utils.enums.Role;

@Data
public class UserDataDto {
    private int userId;
    private String username;
    private Role role;
    private int idRelacao;

    public UserDataDto(User user, Salao salao) {
        this.userId = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.idRelacao = salao.getId();
    }
    public UserDataDto(User user, Cliente cliente) {
        this.userId = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.idRelacao = cliente.getId();
    }

}
