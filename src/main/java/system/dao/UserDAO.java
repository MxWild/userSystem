package system.dao;


import org.springframework.stereotype.Repository;
import system.model.User;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDAO {

    private final List<User> users = Arrays.asList(new User("Admin", "admin"),
            new User("User1", "user1"));

    public List<User> getAllUsers() {
        return users;
    }

}
