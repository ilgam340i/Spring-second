package ru.vagapov.spring.service.Impl;

import org.springframework.stereotype.Service;

import ru.vagapov.spring.dao.UserDao;
import ru.vagapov.spring.dao.UserDaoImpl;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;
import ru.vagapov.spring.mapper.UserMapper;
import ru.vagapov.spring.repository.UserDaoJPA;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;

    public UserService(UserDaoImpl userDao, UserMapper userMapper) {
        this.userDao=userDao;
        this.userMapper = userMapper;
    }


    public void createUser(User user) {
        userDao.createUser(userMapper.toEntity(user));
    }


    public void updateUser(User user, Long id) {
        userDao.updateUser(userMapper.toEntity(user), id);
    }


    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }


    public User findById(Long id) {
        return userMapper.toDto(userDao.findUserById(id));
    }


    public User findUserByUserName(String userName) {
        return userMapper.toDto(userDao.findUserByUserName(userName));
    }


    public List<User> findAll() {
        List<UserEntity> userEntityList = userDao.findAll();
        return userMapper.toDtoList(userEntityList);
    }


    public List<User> findAllUsersByLastName(String lastName) {
        List<UserEntity> userEntityList = userDao.findUsersByLastName(lastName);
        return userMapper.toDtoList(userEntityList);
    }


    public List<User> findUsersByAnyWord(String keyWord) {
        List<UserEntity> userEntityList = userDao.findUsersByAnyWord(keyWord);
        return userMapper.toDtoList(userEntityList);
    }
}
