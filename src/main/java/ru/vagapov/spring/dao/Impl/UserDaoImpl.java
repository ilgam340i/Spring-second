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
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(UserEntity user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
    }

    @Override
    public void updateUser(UserEntity user, Long id) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public UserEntity findUserById(Long id) {
        entityManager.getTransaction().begin();
        return entityManager.find(UserEntity.class, id);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        entityManager.getTransaction().begin();
        return entityManager.createQuery("SELECT u from UserEntity u WHERE u.userName = :username", UserEntity.class).
                setParameter("username", username).getSingleResult();
    }

    @Override
    public List findAll() {
        entityManager.getTransaction().begin();
        return entityManager.createQuery("from UserEntity ").getResultList();
    }

    @Override
    public List<UserEntity> findUsersByLastName(String lastName) {
        entityManager.getTransaction().begin();
        return entityManager.createQuery("from UserEntity where lastName = :lastName").setParameter("lastName", lastName).getResultList();
    }
}
