package unijui.salao.cliente.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import unijui.salao.user.application.CreateKeycloakUserForm;
import unijui.salao.user.domain.User;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ClienteForm {

    private String nome;
    private User user;

}
