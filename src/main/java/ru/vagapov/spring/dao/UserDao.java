package ru.vagapov.spring.dao;

import ru.vagapov.spring.entity.UserEntity;

import java.util.List;
/**
 * интерфейс для для CRUD-операций с БД
 */
public interface UserDao {

    void createUser(UserEntity user);

    UserEntity findUserById(Long id);

    UserEntity findUserByUsername(String username);

    void updateUser(UserEntity user, Long id);

    void deleteUser(Long id);

    List<UserEntity> findAll();

    List<UserEntity> findUsersByLastName(String lastName);

}
