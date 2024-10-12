package ru.vagapov.spring.mapper;

import org.springframework.stereotype.Component;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Преобразование пользователя в модель пользователя, и наоборот.
 */
@Component
public class UserMapper {

    public User toDto(UserEntity userEntity) {
        User user = new User();
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        user.setEmail(userEntity.getEmail());
        user.setLastName(userEntity.getLastName());
        user.setAge(userEntity.getAge());
        return user;

    }

    public UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setLastName(user.getLastName());
        userEntity.setAge(user.getAge());
        return userEntity;
    }
    public List<User> toDtoList(List<UserEntity> userEntityList) {
        List<User> userList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userList.add(toDto(userEntity));
        }
        return userList;
    }
}
