package ru.vagapov.spring.dao.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vagapov.spring.dao.UserDao;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createUser(UserEntity user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(UserEntity user, Long id) {
        entityManager.find(UserEntity.class, id);
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setAge(user.getAge());
        user.setLastName(user.getLastName());
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        UserEntity user = entityManager.find(UserEntity.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserEntity findUserById(Long id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserEntity findUserByUsername(String username) {
        return entityManager.createQuery("SELECT u from UserEntity u WHERE u.userName = :username", UserEntity.class).
                setParameter("username", username).getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return entityManager.createQuery("from UserEntity ").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findUsersByLastName(String lastName) {
        return entityManager.createQuery("from UserEntity where lastName = :lastName").setParameter("lastName", lastName).getResultList();
    }
}
