package ru.vagapov.spring.dao;

import ru.vagapov.spring.entity.UserEntity;

import java.util.List;
/**
 * слой для  CRUD-операций с БД, работа с UserEntity
 */
public interface UserDao {
    /*
    * создание UserEntity, принимает UserEntity, ничего не возвращает
     */
    void createUser(UserEntity user);
    /*
     * поиск UserEntity по его id, принимает id , возвращает UserEntity
     */
    UserEntity findUserById(Long id);
    /*
     * поиск UserEntity по его username, принимает username , возвращает UserEntity
     */
    UserEntity findUserByUsername(String username);
    /*
     * обновление  UserEntity, принимает UserEntity и id, ничего не возвращает
     */
    void updateUser(UserEntity user, Long id);
    /*
     * удаление UserEntity, принимает id, ничего не возвращает
     */
    void deleteUser(Long id);
    /*
     * список всех UserEntity, ничего не принимает, возвращает список всех UserEntity
     */
    List<UserEntity> findAll();
    /*
     * список всех UserEntity с определенной lastName, принимает lastName, возвращает список  UserEntity
     */
    List<UserEntity> findUsersByLastName(String lastName);

}
