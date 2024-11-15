package ru.vagapov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vagapov.spring.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
    List<UserEntity> findByLastName(String lastName);

    UserEntity findById(long id);

    List<UserEntity> findAll();

}
