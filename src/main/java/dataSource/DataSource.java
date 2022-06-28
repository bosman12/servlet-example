package dataSource;

import entity.User;


import java.util.HashMap;
import java.util.Map;

public class DataSource {
    Map<Integer,User> userList=new HashMap<>();
//    userList.(1,new User(1,"t","3","5","r",3,"e"));

    public void addUsersList(User user){
        System.out.println("добавлен юзер" );
        userList.put(user.getId(), user);
    }

    public Map<Integer, User> getUserList() {
        System.out.println(userList);
        return userList;
    }
}
