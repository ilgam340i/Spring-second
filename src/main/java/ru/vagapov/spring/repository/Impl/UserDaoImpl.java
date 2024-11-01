//package ru.vagapov.spring.dao.Impl;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import ru.vagapov.spring.dao.UserDao;
//import ru.vagapov.spring.entity.UserEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class UserDaoImpl implements UserDao {
//    /**
//     * @param user пользователь
//     */
//    @Override
//    public void createUser(UserEntity user) {
//
//    }
//
//    /**
//     * @param id идентификатор пользователя
//     * @return
//     */
//    @Override
//    public UserEntity findUserById(Long id) {
//        return null;
//    }
//
//    /**
//     * @param username имя пользователя
//     * @return
//     */
//    @Override
//    public UserEntity findUserByUserName(String username) {
//        return null;
//    }
//
//    /**
//     * @param user пользователь
//     * @param id   идентификатор пользователя
//     */
//    @Override
//    public void updateUser(UserEntity user, Long id) {
//
//    }
//
//    /**
//     * @param id идентификатор пользователя
//     */
//    @Override
//    public void deleteUser(Long id) {
//
//    }
//
//    /**
//     * @return
//     */
//    @Override
//    public List<UserEntity> findAll() {
//        return List.of();
//    }
//
//    /**
//     * @param lastName фамилия
//     * @return
//     */
//    @Override
//    public List<UserEntity> findUsersByLastName(String lastName) {
//        return List.of();
//    }
//
//    /**
//     * @param keyword
//     * @return
//     */
//    @Override
//    public List<UserEntity> findUsersByAnyWord(String keyword) {
//        return List.of();
//    }
//}
//
