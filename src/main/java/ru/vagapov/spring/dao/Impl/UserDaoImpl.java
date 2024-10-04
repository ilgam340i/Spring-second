package ru.vagapov.spring.dao.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vagapov.spring.dao.UserDao;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Работа с БД
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(UserEntity user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(UserEntity user, Long id) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return entityManager.createQuery("SELECT u from UserEntity u WHERE u.userName = :username", UserEntity.class).
                setParameter("username", username).getSingleResult();
    }

    @Override
    public List findAll() {
        return entityManager.createQuery("from UserEntity ").getResultList();
    }

    @Override
    public List<UserEntity> findUsersByLastName(String lastName) {
        return entityManager.createQuery("from UserEntity where lastName = :lastName").setParameter("lastName", lastName).getResultList();
    }
}
