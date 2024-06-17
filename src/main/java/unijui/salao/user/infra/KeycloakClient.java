package unijui.salao.user.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import unijui.salao.user.application.KeycloakCreateUserRequest;

@FeignClient(name = "keycloak", url = "${keycloak.auth-server-url}")
public interface KeycloakClient {

    @PostMapping(value = "/admin/realms/${keycloak.realm}/users", consumes = "application/json")
    void createUser(@RequestHeader("Authorization") String authorization, @RequestBody KeycloakCreateUserRequest request);
}