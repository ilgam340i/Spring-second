package ru.vagapov.spring.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vagapov.spring.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
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
    public UserEntity findUserByUserName(String username) {
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
    public List findUsersByLastName(String lastName) {
        return entityManager.createQuery("from UserEntity where lastName = :lastName").setParameter("lastName", lastName).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List findUsersByAnyWord(String keyword) {
        List<UserEntity> userEntityList = findAll();
        List<UserEntity> userEntityList2 = new ArrayList<UserEntity>();
        for (UserEntity userEntity : userEntityList) {
            if (userEntity.getUserName().toLowerCase().contains(keyword.toLowerCase())) {
                userEntityList2.add(userEntity);
            }
            if (userEntity.getLastName().toLowerCase().contains(keyword.toLowerCase())) {
                userEntityList2.add(userEntity);
            }
        }
        return userEntityList2;
    }

}

