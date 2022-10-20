package src.Services;

import src.RawInfo.User;
import src.Utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class UserService implements SuperUserService{
    private final static String Path = "D:\\CaseStudyModule2\\data\\Users.csv";
    public static UserService instanceUser;

    public static UserService instanceUser(){
        if (instanceUser == null){
            instanceUser = new UserService();
        }
        return instanceUser;
    }
    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtil.read(Path);
        for (String record: records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    @Override
    public User loginUser(String username, String password) {
        List<User> users = findAllUsers();
        for (User user: users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    @Override
    public void addUser(User newUser) {
        List<User> users = findAllUsers();
        users.add(newUser);
        CSVUtil.write(Path,users);
    }

    @Override
    public void removeUser(Long idUser) {
        List<User> users = findAllUsers();
        users.removeIf(id -> id.getIdUser().equals(idUser));
        CSVUtil.write(Path,users);
    }

    @Override
    public void editUser(User newUser) {
        List<User> users = findAllUsers();
        for (User oldUser: users) {
            if (oldUser.getIdUser() == newUser.getIdUser()){
                String phoneNumber = newUser.getPhoneNumber();
                if (phoneNumber != null && !phoneNumber.isEmpty()){
                    oldUser.setPhoneNumber(phoneNumber);
                }
                String role = newUser.getRole();
                if (role !=null && !role.isEmpty()){
                    oldUser.setRole(role);
                }
                CSVUtil.write(Path,users);
                break;
            }
        }

    }

    @Override
    public User findIdUser(Long idUser) {
        List<User> users = findAllUsers();
        for (User user: users) {
            if (user.getIdUser().equals(idUser) ){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean exitsUser(Long idUser) {
        return findIdUser(idUser) != null;
    }

    @Override
    public boolean exitsUserName(String username) {
        List<User> users = findAllUsers();
        for (User user: users) {
            if (user.getUsername() == username){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean exitsPhoneNumber(String phoneNumber) {
        List<User> users = findAllUsers();
        for (User user: users ) {
            if (user.getPhoneNumber() == phoneNumber){
                return true;
            }
        }
        return false;
    }
}
