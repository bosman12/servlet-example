package dataSource;

import entity.User;
import exception.UserNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class UserDaoImpl implements UserDao {
    Map<Integer,User> userList=new HashMap<>();

    @Override
    public void addUser(User user){
        userList.put(user.getId(), user);
    }

    @Override
    public Map<Integer, User> getUserList() {
        //userList.put(3,new User(3,"q","q","q","q",1,"topeze@inbox.ru"));
        System.out.println(userList);
        return userList;
    }

    @Override
    public User findByUserName(String userName) {
        for(Map.Entry<Integer, User> user : userList.entrySet()){
            System.out.println(user.getValue().getUserName());
            if (user.getValue().getUserName().equals(userName)){
                return user.getValue();
            }
        }
        throw  new UserNotFoundException("Пользователь не был найден");
    }



}
