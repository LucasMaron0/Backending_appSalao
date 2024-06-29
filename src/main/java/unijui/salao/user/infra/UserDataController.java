package unijui.salao.user.infra;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unijui.salao.user.application.CreateKeycloakUserForm;
import unijui.salao.user.application.UserDataDto;
import unijui.salao.user.domain.KeycloakServiceImpl;
import unijui.salao.user.domain.UserDataService;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserDataController {

    private UserDataService userService;

    private KeycloakServiceImpl keycloakService;


    @GetMapping
    public UserDataDto getData(@RequestHeader("Authorization") String token) {
        UserDataDto dataDto =  userService.getUserData(token);
        return dataDto;
    }


    @PostMapping("/create")
    public void criarUser(@RequestHeader("Authorization") String token, @RequestBody CreateKeycloakUserForm form) {
         keycloakService.createUser(form, token);
    }
}
