package unijui.salao.user.infra;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unijui.salao.user.application.CreateKeycloakUserForm;
import unijui.salao.user.application.UserDataDto;
import unijui.salao.user.domain.KeycloakService;
import unijui.salao.user.domain.UserDataService;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserDataController {

    private UserDataService userService;

    private KeycloakService keycloakService;


    @GetMapping
    public UserDataDto getData(@RequestHeader("Authorization") String token) {
        return userService.getUserData(token);
    }


    @PostMapping("/create")
    public void criarUser(@RequestHeader("Authorization") String token, @RequestBody CreateKeycloakUserForm form) {
         keycloakService.createUser(form, token);
    }
}
