package unijui.salao.user.domain;

import unijui.salao.user.application.CreateKeycloakUserForm;

public interface KeyckloakService {

    void createUser(CreateKeycloakUserForm form, String token);
}
