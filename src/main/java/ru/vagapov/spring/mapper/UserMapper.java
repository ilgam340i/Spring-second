package ru.vagapov.spring.mapper;

import org.springframework.stereotype.Component;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Преобразование пользователя в модель пользователя, и наоборот.
 */
@Component
public class UserMapper {

    public UserMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public RoleMapper roleMapper;

    public User toDto(Optional<UserEntity> userEntity) {
        User user = new User();
        user.setId(userEntity.get().getId());
        user.setUserName(userEntity.get().getUserName());
        user.setPassword(userEntity.get().getPassword());
        user.setEmail(userEntity.get().getEmail());
        user.setLastName(userEntity.get().getLastName());
        user.setAge(userEntity.get().getAge());
        user.setRoles(roleMapper.toDto(userEntity.get().getRoles()));

        return user;

    }

    public UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setLastName(user.getLastName());
        userEntity.setAge(user.getAge());
        userEntity.setRoles(roleMapper.toEntity(user.getRoles()));
        return userEntity;
    }

    public List<User> toDtoList(List<UserEntity> userEntityList) {
        List<User> userList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            userList.add(toDto(Optional.ofNullable(userEntity)));
        }
        return userList;
    }
}
