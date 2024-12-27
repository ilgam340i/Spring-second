package ru.vagapov.spring.service.Impl;

import org.springframework.stereotype.Service;
import ru.vagapov.spring.dto.Role;
import ru.vagapov.spring.entity.RoleEntity;
import ru.vagapov.spring.repository.RoleRepository;
import ru.vagapov.spring.service.RoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Реализация бизнес-логики, помимо методов слоя работы с базами данных, могут быть и свои методы, работа с моделью роли
 */

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final String ROLE_ADMIN = "ROLE_ADMIN";
    private final String ROLE_USER = "ROLE_USER";
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        List<RoleEntity> roles = roleRepository.findAll();
        List<Role> roleList = new ArrayList<>();
        for (RoleEntity role : roles) {
            Role Userrole = new Role();
            Userrole.setId(role.getId());
            Userrole.setName(role.getName());
            roleList.add(Userrole);
        }
        return roleList;
    }

    public List<RoleEntity> dtoToRoles(List<String> roles) {
        List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();
        for (String role : roles) {
            if (role.equals(ROLE_ADMIN)) {
                RoleEntity roleEntity = roleRepository.findByName(role);
                roleEntities.add(roleEntity);
            } else if (role.equals(ROLE_USER)) {
                RoleEntity roleEntity = roleRepository.findByName(role);
                roleEntities.add(roleEntity);
            }
        }
        return roleEntities;
    }

    public List<String> rolesToDto(List<RoleEntity> roleEntities) {
        List<String> roles = new ArrayList();
        for (RoleEntity roleEntity : roleEntities) {
            if (roleEntity.getName().equals(ROLE_ADMIN)) {
                roles.add(roleEntity.getName());
            } else if (roleEntity.getName().equals(ROLE_USER)) {
                roles.add(roleEntity.getName());
            }
        }
        return roles;
    }

    public Role toDto(Optional<RoleEntity> roleEntity) {
        Role role = new Role();
        role.setId(roleEntity.get().getId());
        role.setName(roleEntity.get().getName());
        return role;
    }

    public List<Role> toDto(List<RoleEntity> roleEntityList) {
        List<Role> roleList = new ArrayList<Role>();
        for (RoleEntity roleEntity : roleEntityList) {
            roleList.add(toDto(Optional.ofNullable(roleEntity)));
        }
        return roleList;
    }
}
