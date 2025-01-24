package ru.vagapov.spring.service;

import ru.vagapov.spring.dto.Role;
import ru.vagapov.spring.entity.RoleEntity;

import java.util.List;
import java.util.Set;

/**
 * Реализация бизнес-логики, помимо методов слоя работы с базами данных, могут быть и свои методы, работа с моделью роли
 */
public interface RoleService {
    /**
     * Поиск всех ролей
     */
    List<Role> findAll();

    /**
     * Преобразование строкового формата ролей в модель роли
     *
     * @param roles список ролей в строковом формате
     */
    Set<RoleEntity> dtoToRoles(List<String> roles);

    /**
     * Преобразование модели роли в строковый формат
     *
     * @param roleEntities список ролей
     */
    List<String> rolesToDto(Set<RoleEntity> roleEntities);

    /**
     * Преобразование сущности роли в модель роли
     *
     * @param roleEntity сущность роли
     */
    Role roleEntityToDto(RoleEntity roleEntity);


    /**
     * Преобразование списка сущностей роли в модель роли
     *
     * @param roleEntity список сущностей роли
     */
    Set<Role> listOfRoleEntityToDto (Set<RoleEntity> roleEntity);


}
