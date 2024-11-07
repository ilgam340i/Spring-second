package ru.vagapov.spring.service.Impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.RoleEntity;
import ru.vagapov.spring.entity.UserEntity;
import ru.vagapov.spring.mapper.UserMapper;
import ru.vagapov.spring.repository.UserDaoImpl;
import ru.vagapov.spring.service.UserService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDao;
    private final UserMapper userMapper;

    public UserServiceImpl(UserDaoImpl userDao, UserMapper userMapper) {
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

    /**
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserEntity user = userDao.findUserByUserName(username);
       if (user == null) {
           throw new UsernameNotFoundException(username);
       }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roles ) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
