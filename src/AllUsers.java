package src;

import java.util.ArrayList;
import java.util.List;

public class AllUsers {
    List<User> AllUsers = new ArrayList<>();

    public List<User> getAllUsers() {
        return AllUsers;
    }
    public void setAllUsers(List<User> allUsers) {
        AllUsers = allUsers;
    }
    public AllUsers() {
        AllUsers = new ArrayList<>();
    }
    public AllUsers(List<User> allUsers) {
        AllUsers = allUsers;
    }

    public void addUser(User user) {
        AllUsers.add(user);
    }

    public void removeUser(User user) {
        AllUsers.remove(user);
    }

}
