package validation;

import dataSource.UserDaoImpl;
import entity.User;
import exception.AccessDeniedException;
import exception.EmailAlreadyRegisteredException;
import exception.UserBlocked;
import exception.UserNameAlreadyRegisteredException;

import java.util.Map;


public class UserValidation {
    private UserDaoImpl userDaoImpl;

    private final String USERNAME_ALREADY_REGISTERED_MSG = "Пользователь с таким username уже зарегистрирован !";
    private final String EMAIL_ALREADY_REGISTERED_MSG = "Пользователь с таким email уже зарегистрирован !";
    private final String USER_IS_BLOCKED = "Пользователь был заблокирован";
    private final String AGE_CHECK = "Недопустимый возраст";
    private final String PASSWORD_CHECK = "Пароль должен быть от 6 симоволов";
    public UserValidation(UserDaoImpl dataSource) {
        this.userDaoImpl = dataSource;
    }

    //TODO ПЕРЕДЕЛАТЬ ЭТОТ МЕТОД, ПРОБЕГАЕТ ЛИШНИЙ РАЗ ПО СПИСКУ
    private boolean alreadyUsed(String argument) {
        for (Map.Entry<Integer, User> user : userDaoImpl.getUserList().entrySet()) {
            if (user.getValue().getUserName().equals(argument)) {
                return true;
            }else if(user.getValue().getEmail().equals(argument)){
                return true;
            }
        }
        return false;
    }

    public boolean validateUser(User user) {
        if ((user.getAge() < 18) || (user.getAge()>150)){
            throw new AccessDeniedException(AGE_CHECK);
        } else if (user.getPassword().length()<6) {
            throw new AccessDeniedException(PASSWORD_CHECK);
        }else if (!user.isStatus()) {
            throw new UserBlocked(USER_IS_BLOCKED);
        } else if (alreadyUsed(user.getUserName())) {
            throw new UserNameAlreadyRegisteredException(USERNAME_ALREADY_REGISTERED_MSG);
        }else if ((alreadyUsed(user.getEmail()))){
            throw new EmailAlreadyRegisteredException(EMAIL_ALREADY_REGISTERED_MSG);
        }
        return true;
    }
}
