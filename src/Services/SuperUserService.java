package src.Services;

import src.RawInfo.User;

import java.util.List;

public interface SuperUserService {
    List<User> findAllUsers();

    User loginUser(String username, String password);

    void addUser(User newUser);

    void removeUser(Long idUser);

    void editUser(User newUser);

    User findIdUser(Long idUser);

    boolean exitsUser(Long idUser);

    boolean exitsUserName(String username);

    boolean exitsPhoneNumber(String phoneNumber);
}
