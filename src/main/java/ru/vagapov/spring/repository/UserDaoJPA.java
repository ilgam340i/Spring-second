package ru.vagapov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vagapov.spring.entity.UserEntity;

import java.util.List;

/**
 * Слой для CRUD-операций с пользователями из базы данных.
 */
@Repository
public interface UserDaoJPA extends JpaRepository<UserEntity, Long> {
    UserEntity findUserByUserName(String username);

    UserEntity createUser(UserEntity user);

    UserEntity updateUser(UserEntity user, Long id);

    UserEntity deleteUser(Long id);

    List<UserEntity> findAll();

    List<UserEntity> findUserByLastName(String lastName);

    UserEntity findUserById(Long id);

    List<UserEntity> findUserByAnyKeyWord(String anyKeyWord);

}