package unijui.salao.salao.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import unijui.salao.user.application.CreateKeycloakUserForm;
import unijui.salao.user.domain.User;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SalaoForm {

    private String nomeSalao;
    private User user;

}
