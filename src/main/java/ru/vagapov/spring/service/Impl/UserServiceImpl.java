package ru.vagapov.spring.service.Impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;
import ru.vagapov.spring.mapper.UserMapper;
import ru.vagapov.spring.repository.UserRepository;
import ru.vagapov.spring.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userDao;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public void createUser(User user) {
        userDao.save(userMapper.toEntity(user));
    }

    public void updateUser(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        userDao.save(userEntity);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    public User findById(Long id) {
        return userMapper.toDto(userDao.findById(id));
    }

    public User findUserByUserName(String userName) {
        return userMapper.toDto(Optional.ofNullable((userDao.findByUserName(userName))));
    }

    public List<User> findAll() {
        List<UserEntity> userEntityList = userDao.findAll();
        return userMapper.toDtoList(userEntityList);
    }

    public List<User> findAllUsersByLastName(String lastName) {
        List<UserEntity> userEntityList = userDao.findByLastName(lastName);
        return userMapper.toDtoList(userEntityList);
    }

    public List<User> findUsersByAnyWord(String keyword) {
        List<UserEntity> userEntityList = userDao.findAll();
        List<UserEntity> userEntityList2 = new ArrayList<UserEntity>();
        for (UserEntity userEntity : userEntityList) {
            if (userEntity.getUserName().toLowerCase().contains(keyword.toLowerCase())) {
                userEntityList2.add(userEntity);
            }
            if (userEntity.getLastName().toLowerCase().contains(keyword.toLowerCase())) {
                userEntityList2.add(userEntity);
            }
        }


        return userMapper.toDtoList(userEntityList2);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return  user;
    }
}
