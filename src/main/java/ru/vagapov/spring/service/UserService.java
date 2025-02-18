package ru.vagapov.spring.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.vagapov.spring.dto.User;
import java.util.List;

/**
 * Реализация бизнес-логики, помимо методов слоя работы с базами данных, могут быть и свои методы, работа с моделью пользователя
 */
public interface UserService extends UserDetailsService {
    /**
     * Создание модели пользователя
     *
     * @param user
     */
    void createUser(User user);

    /**
     * Обновление пользователя
     * @param user пользователь
     */
    void updateUser(User user);

    /**
     * Удаление пользователя
     * @param id идентификатор пользователя
     */
    void deleteUser(Long id);

    /**
     * Поиск пользователя по его id
     * @param id идентификатор пользователя
     * @return пользователя с идентификатором id
     */
    User findById(Long id);

    /**
     * Поиск пользователя по его username
     * @param userName имя пользователя
     * @return пользователя с именем username
     */
    User findUserByUserName(String userName);

    /**
     * Список всех пользователей
     * @return List<UserEntity> список пользователей
     */
    List<User> findAll();

    /**
     * Список всех пользователей с определенной lastName
     * @param lastName фамилия
     * @return List<UserEntity> список пользователей c фамилией lastname
     */
    List<User> findAllUsersByLastName(String lastName);
    /**
     * Список всех пользователей, содержащих заданное слово в имени или фамилии
     * @return List<User> список пользователей
     */
    List<User> findUsersByAnyWord( String keyWord);
}
