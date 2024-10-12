package ru.vagapov.spring.service;

import ru.vagapov.spring.dto.User;

import java.util.List;
/**
 * Реализация бизнес-логики, помимо методов слоя работы с базами данных, могут быть и свои методы, работа с моделью пользователя
 */
public interface UserService {
    /**
     * Создание модели пользователя
     * @param user
     */
    void createUser(User user);
    /**
     * Обновление модели пользователя
     * @param user,id
     */
    void updateUser(User user, Long id);
    /*
     * Удаление модели пользователя, принимает id, ничего не возвращает
     * @param id
     */
    void deleteUser(Long id);
    /*
     * Поиск модели пользователя по его id, принимает id, возвращает модель пользователя
     * @param id
     */
    User findById(Long id);
    /*
     * Поиск модели пользователя по его username, принимает username, возвращает модель пользователя
     * @param userName
     */
    User findUserByUserName(String userName);
    /*
     * Список всех моделей пользователей, ничего не принимает, возвращает список всех моделей пользователей
     */
    List<User> findAll();
    /*
     * Список всех моделей пользователей с определенной lastName, принимает lastName, возвращает список моделей пользователе
     * @param lastName
     */
    List<User> findAllUsersByLastName(String lastName);
}
