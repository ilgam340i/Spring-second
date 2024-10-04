package ru.vagapov.spring.mapper;

import org.springframework.stereotype.Component;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;
/**
 * Преобразование Entity в User, и наоборот.
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
}
