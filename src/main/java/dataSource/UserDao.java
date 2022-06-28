package dataSource;

import entity.User;

import java.util.Map;

public interface UserDao {
    void addUser(User user);
    Map<Integer, User> getUserList();
    User findByUserName(String userName);

}
