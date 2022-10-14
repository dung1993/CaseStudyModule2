package src.Services;

import src.RawInfo.User;

import java.util.List;

public interface SuperUserService {
    List<User> findAllUsers();

    User loginUser(String username, String password);

    void addUser(User newUser);

    void removeUser(long idUser);

    void editUser(User newUser);

    User findIdUser(long idUser);

    boolean exitsUser(long idUser);

    boolean exitsUserName(String username);

    boolean exitsPhoneNumber(String phoneNumber);
}
