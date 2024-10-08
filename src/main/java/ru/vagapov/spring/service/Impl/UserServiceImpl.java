package ru.vagapov.spring.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vagapov.spring.dao.UserDao;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;
import ru.vagapov.spring.mapper.UserMapper;
import ru.vagapov.spring.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;
    public UserServiceImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(userMapper.toEntity(user));
    }

    @Override
    public void updateUser(User user, Long id) {
        userDao.updateUser(userMapper.toEntity(user), id);
    }

    @Override
    public void deleteUser(Long id) {
         userDao.deleteUser(id);
    }

    @Override
    public User findById(Long id) {
        return userMapper.toDto(userDao.findUserById(id)) ;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.toDto(userDao.findUserByUsername(userName));
    }

    @Override
    public List<User> findAll() {
        List <UserEntity> userEntityList = userDao.findAll();
        return userMapper.toDtoList(userEntityList);
    }

    @Override
    public List<User> findAllUsersByLastName(String lastName) {
        List<UserEntity> userEntityList= userDao.findUsersByLastName(lastName);
        return userMapper.toDtoList(userEntityList);
    }
}
