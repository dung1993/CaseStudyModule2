package src.RawInfo;

public class User {
    private Long idUser;
    private String username;
    private String password;
    private String phoneNumber;
    private String role;


    public User() {
    }

    public User(Long idUser, String username, String password, String phoneNumber, String role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }



    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",idUser,username,password,phoneNumber,role);
    }

    public static User parseUser(String myUser){
        String[] array = myUser.split(",");
        User user = new User();
        user.setIdUser(Long.parseLong(array[0]));
        user.setUsername(array[1]);
        user.setPassword(array[2]);
        user.setPhoneNumber(array[3]);
        user.setRole(array[4]);
        return user;
    }
}
