package ru.vagapov.spring.mapper;

import org.springframework.stereotype.Component;
import ru.vagapov.spring.dto.Role;
import ru.vagapov.spring.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RoleMapper {
    public Role toDto(Optional<RoleEntity> roleEntity) {
        Role role = new Role();
        role.setId(roleEntity.get().getId());
        role.setName(roleEntity.get().getName());
        return role;
    }

    public RoleEntity toEntity(Role dto) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(dto.getId());
        roleEntity.setName(dto.getName());
        return roleEntity;
    }

    public List<Role> toDto(List<RoleEntity> roleEntityList) {
        List<Role> roleList = new ArrayList<Role>();
        for (RoleEntity roleEntity : roleEntityList) {
            roleList.add(toDto(Optional.ofNullable(roleEntity)));
        }
        return roleList;
    }

    public List<String> rolesToString (List <RoleEntity> roleList1) {
        List<RoleEntity> roleList = new ArrayList<>();
        for (RoleEntity role : roleList1) {
            role.getName();
            roleList.add(role);}
            return roleList.stream().map(RoleEntity::getName).collect(Collectors.toList());
    }

    public List<RoleEntity> toEntity(List<Role> roleList) {
        List<RoleEntity> roleEntityList = new ArrayList<>();
        for (Role role : roleList) {
            roleEntityList.add(toEntity(role));
        }
        return roleEntityList;
    }
}
