package unijui.salao.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import unijui.salao.cliente.application.ClienteForm;
import unijui.salao.cliente.domain.ClienteService;
import unijui.salao.salao.application.SalaoForm;
import unijui.salao.salao.domain.SalaoService;
import unijui.salao.user.application.CreateKeycloakUserForm;
import unijui.salao.user.application.KeycloakCreateUserRequest;
import unijui.salao.user.infra.KeycloakClient;
import unijui.salao.utils.enums.Role;

@Service
public class KeycloakService {

    private KeycloakClient keycloakClient;

    private SalaoService salaoService;

    private ClienteService clienteService;

    private UserDataService userDataService;

    private String clientId;

    private String clientSecret;

    @Autowired
    public KeycloakService(KeycloakClient keycloakClient,
                           SalaoService salaoService,
                           ClienteService clienteService,
                           UserDataService userDataService,
                           @Value("${keycloak.client-id}") String clientId,
                           @Value("${keycloak.client-secret}") String clientSecret) {

        this.keycloakClient = keycloakClient;
        this.salaoService = salaoService;
        this.clienteService = clienteService;
        this.userDataService = userDataService;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }


    public void createUser(CreateKeycloakUserForm form, String token) {

        KeycloakCreateUserRequest request = new KeycloakCreateUserRequest(form);
        keycloakClient.createUser(token, request);

        User user = userDataService.createUser(form);

        if(form.getRole().equals(Role.SALAO)){
            salaoService.cadastrarSalao(new SalaoForm(form.getNome(), user));
        } else {
            clienteService.cadastrarCliente(new ClienteForm(form.getNome(), user));
        }
    }
}
