package ru.vagapov.spring.dao;

import org.springframework.transaction.annotation.Transactional;
import ru.vagapov.spring.entity.UserEntity;

import java.util.List;

/**
 * Слой для CRUD-операций с пользователями из базы данных.
 */
public interface UserDao {
    /**
     * Создание пользователя
     * @param user пользователь
     */
    void createUser(UserEntity user);

    /**
     * Поиск пользователя по его id
     * @param id идентификатор пользователя
     * @return пользователя с идентификатором id
     */
    UserEntity findUserById(Long id);

    /**
     * Поиск пользователя по его username
     * @param username имя пользователя
     * @return пользователя с именем username
     */
    UserEntity findUserByUsername(String username);

    /**
     * Обновление пользователя,
     * @param id идентификатор пользователя
     * @param user пользователь
     */
    void updateUser(UserEntity user, Long id);

    /**
     * Удаление пользователя
     * @param id идентификатор пользователя
     */
    void deleteUser(Long id);

    /**
     * Список всех пользователей
     * @return List<UserEntity> список пользователей
     */
    List<UserEntity> findAll();

    /**
     * Список всех пользователей с определенной lastName
     * @param lastName фамилия
     * @return List<UserEntity> список пользователей c фамилией lastname
     */
    List<UserEntity> findUsersByLastName(String lastName);
    /**
     * Список всех пользователей с заданным полем
     * @return List<UserEntity> список пользователей c заданным полем
     */
    List<UserEntity> findUsersByAnyWord(String keyword);
}
