package unijui.salao.user.application;


import lombok.Data;
import unijui.salao.utils.enums.Role;

@Data
public class CreateKeycloakUserForm {

    private String username;
    private String password;
    private Role role;
    private String nome;

}
