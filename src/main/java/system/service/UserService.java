package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.DAO.UserDAO;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    public List getAllUsers() {
        return userDao.getAllUsers();
    }
}
