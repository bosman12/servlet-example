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
        System.out.println(userList);
        return userList;
    }

    @Override
    public User findByUserName(String userName) {
        for(Map.Entry<Integer, User> user : userList.entrySet()){
            if (user.getValue().getUserName().equals(userName)){
                return user.getValue();
            }
        }
        throw  new UserNotFoundException("Пользователь не был найден");
    }

//    @Override
//    public boolean IsEmailOrUserNameAlreadyRegistered(String userName, String email) {
//        for(Map.Entry<Integer, User> user : getUserList().entrySet()){
//            if (user.getValue().getUserName().equals(email)){
//                throw new UserNameAlreadyRegisteredException(USERNAME_ALREADY_REGISTERED_MSG);
//            }else if (user.getValue().getUserName().equals(userName)){
//                throw new UserNameAlreadyRegisteredException(EMAIL_ALREADY_REGISTERED_MSG);
//            }
//        }
//        return true;
//    }



}
