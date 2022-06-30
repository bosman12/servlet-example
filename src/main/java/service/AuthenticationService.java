package service;

import dataSource.UserDaoImpl;
import entity.User;


public class AuthenticationService {
    private UserDaoImpl userDaoImpl;


    public AuthenticationService(UserDaoImpl userDaoImpl) {
        this.userDaoImpl =userDaoImpl  ;
    }

    public boolean isAuthenticate(String userName, String password){
        User user = userDaoImpl.findByUserName(userName);

        return user.getUserName().equals(userName) && (user.getPassword().equals(password));
    }
}
