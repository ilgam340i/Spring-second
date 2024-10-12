package ru.vagapov.spring.dao;

import ru.vagapov.spring.entity.UserEntity;

import java.util.List;
/**
 * Слой для CRUD-операций с пользователями из базы данных.
 */
public interface UserDao {
    /*
    * Создание пользователя, принимает пользователя, ничего не возвращает
     */
    void createUser(UserEntity user);
    /*
     * Поиск пользователя по его id, принимает id, возвращает пользователя
     */
    UserEntity findUserById(Long id);
    /*
     * Поиск пользователя по его username, принимает username, возвращает пользователя
     */
    UserEntity findUserByUsername(String username);
    /*
     * Обновление пользователя, принимает пользователя и id, ничего не возвращает
     */
    void updateUser(UserEntity user, Long id);
    /*
     * Удаление пользователя, принимает id, ничего не возвращает
     */
    void deleteUser(Long id);
    /*
     * Список всех пользователей, ничего не принимает, возвращает список всех пользователей
     */
    List<UserEntity> findAll();
    /*
     * Список всех пользователей с определенной lastName, принимает lastName, возвращает список пользователей
     */
    List<UserEntity> findUsersByLastName(String lastName);

}
