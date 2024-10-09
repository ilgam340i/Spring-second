package ru.vagapov.spring.service;

import ru.vagapov.spring.dto.User;

import java.util.List;
/**
 * Реализация бизнес-логики, помимо методов DAO, могут быть и свои методы, работа с DTO
 */
public interface UserService {
    // создание User, принимает User, ничего не возвращает
    void createUser(User user);
    //обновление  User, принимает User и id, ничего не возвращает
    void updateUser(User user, Long id);
    //удаление User, принимает id, ничего не возвращает
    void deleteUser(Long id);
    //поиск User по его id, принимает id , возвращает User
    User findById(Long id);
    //поиск User по его username, принимает username , возвращает User
    User findUserByUserName(String userName);
    //список всех User, ничего не принимает, возвращает список всех User
    List<User> findAll();
    //список всех User с определенной lastName, принимает lastName, возвращает список  User
    List<User> findAllUsersByLastName(String lastName);
}
