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
import ru.vagapov.spring.mapper.RoleMapper;
import ru.vagapov.spring.mapper.UserMapper;
import ru.vagapov.spring.repository.RoleRepository;
import ru.vagapov.spring.repository.UserRepository;
import ru.vagapov.spring.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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

    /**
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userDao.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
