package unijui.salao.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import unijui.salao.user.application.CreateKeycloakUserForm;
import unijui.salao.utils.enums.Role;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private Role role;

    public User(CreateKeycloakUserForm form){
        this.username = form.getUsername();
        this.role = form.getRole();
    }
}
