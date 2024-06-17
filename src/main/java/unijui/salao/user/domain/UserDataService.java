package unijui.salao.user.domain;


import unijui.salao.user.application.CreateKeycloakUserForm;
import unijui.salao.user.application.UserDataDto;

public interface UserDataService {
  String getDataFromToken(String token);
  User getUserByUsername(String username);
  UserDataDto getUserData(String token);
  User createUser(CreateKeycloakUserForm form);
}
