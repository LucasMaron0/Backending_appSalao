package unijui.salao.user.domain;


import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.SignedJWT;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import unijui.salao.cliente.domain.Cliente;
import unijui.salao.salao.domain.Salao;
import unijui.salao.user.application.CreateKeycloakUserForm;
import unijui.salao.user.infra.UserRepository;
import unijui.salao.user.application.UserDataDto;
import unijui.salao.utils.enums.Role;
import unijui.salao.cliente.infra.ClienteRepository;
import unijui.salao.salao.infra.SalaoRepository;

import java.text.ParseException;

@Service
@AllArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    UserRepository userRepo;
    ClienteRepository clienteRepo;
    SalaoRepository salaoRepo;

    @Override
    public String getDataFromToken(String token) {
        try {
            token = token.replace("Bearer ", "");
            JWT jwt = JWTParser.parse(token);
            if (jwt instanceof SignedJWT) {
                SignedJWT signedJWT = (SignedJWT) jwt;
                return signedJWT.getJWTClaimsSet().getStringClaim("preferred_username");
            } else {
                throw new IllegalArgumentException("Token is not signed");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse token", e);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDataDto getUserData(String token) {

        String username = getDataFromToken(token);
        User user = getUserByUsername(username);

        if(user.getRole().equals(Role.SALAO)){
            Salao salao = salaoRepo.findByUserId(user.getId());
            return new UserDataDto(user, salao);
        } else {
            Cliente cliente = clienteRepo.findByUserId(user.getId());
            return new UserDataDto(user, cliente);
        }
    }

    @Override
    public User createUser(CreateKeycloakUserForm form) {
        User user = new User(form);
        return userRepo.save(user);
    }
}
