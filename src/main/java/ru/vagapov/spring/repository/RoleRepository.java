package ru.vagapov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vagapov.spring.entity.RoleEntity;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    /**
     * Поиск всех ролей
     * @return список ролей
     */

    @Override
    List<RoleEntity> findAll();
    /**
     * Поиск роли по имени
     * @param name имя роли
     * @return роль с таким именем
     */
    Set<RoleEntity> findByName(String name);
}
