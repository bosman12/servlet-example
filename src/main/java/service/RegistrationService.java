package service;

import entity.User;

public class RegistrationService {

    public User registration(final int id, final String userName,final String name,final String surName,
                                  final String password, final int age, final String email) {
        User user = new User(id,userName,name,surName,password,age,email);
        user.setId(id);
        user.setName(userName);
        user.setName(name);
        user.setSurName(surName);
        user.setPassword(password);
        user.setAge(age);
        user.setEmail(email);

        return user;
    }
}
