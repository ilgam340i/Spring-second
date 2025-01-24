package ru.vagapov.spring.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vagapov.spring.dto.Role;
import ru.vagapov.spring.entity.RoleEntity;
import ru.vagapov.spring.repository.RoleRepository;
import ru.vagapov.spring.service.RoleService;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final String Role_admin = "ROLE_ADMIN";
    private final String Role_user = "ROLE_USER";

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
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

    @Override
    public Set<RoleEntity> dtoToRoles(List<String> roles) {
        Set<RoleEntity> roleEntities = new HashSet<>();
        for (String role : roles) {
            if (role.equals(Role_admin)) {
                roleEntities = roleRepository.findByName(role);
            } else {
                roleEntities = roleRepository.findByName(role);

            }
        }
        return roleEntities;
    }

    @Override
    public List<String> rolesToDto(Set<RoleEntity> roleEntities) {
        List<String> roles = new ArrayList();
        for (RoleEntity roleEntity : roleEntities) {
            if (roleEntity.getName().equals(Role_admin)) {
                roles.add(roleEntity.getName());
            } else {
                roles.add(roleEntity.getName());
            }
        }
        return roles;
    }

    @Override
    public Role roleEntityToDto(RoleEntity roleEntity) {
        Role role = new Role();
        role.setId(roleEntity.getId());
        role.setName(roleEntity.getName());
        return role;
    }

    @Override
    public Set<Role> listOfRoleEntityToDto(Set<RoleEntity> roleEntityList) {
        Set<Role> roleList = new HashSet<>();
        for (RoleEntity roleEntity : roleEntityList) {
            roleList.add(roleEntityToDto((roleEntity)));
        }
        return roleList;
    }
}
