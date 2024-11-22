package ru.vagapov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vagapov.spring.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Поиск пользователя по имени
     * @param userName имя пользователя
     * @return пользователя с таким именем
     */
    UserEntity findByUserName(String userName);
    /**
     * Поиск пользователя по фамилии
     * @param lastName фамилия пользователя
     * @return пользователя с такой фамилией
     */
    List<UserEntity> findByLastName(String lastName);
    /**
     * Поиск пользователя по id
     * @param id фамилия пользователя
     * @return пользователя с таким id
     */
    UserEntity findById(long id);
    /**
     * Поиск всех пользователей
     * @return всех пользователей
     */
    List<UserEntity> findAll();

}
