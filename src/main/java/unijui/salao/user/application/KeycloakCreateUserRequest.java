package unijui.salao.user.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeycloakCreateUserRequest {
    private List<Credential> credentials;
    private String username;
    private boolean emailVerified;
    private boolean enabled;

    public KeycloakCreateUserRequest(CreateKeycloakUserForm form) {
        KeycloakCreateUserRequest.Credential credential = new KeycloakCreateUserRequest.Credential(
                false,
                "password",
                form.getPassword());
        this.credentials =  Collections.singletonList(credential);
        this.username = form.getUsername();
        this.emailVerified = false;
        this.enabled = true;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Credential {
        private boolean temporary;
        private String type;
        private String value;
    }
}