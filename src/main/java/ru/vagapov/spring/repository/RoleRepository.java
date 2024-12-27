package ru.vagapov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vagapov.spring.entity.RoleEntity;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    /**
     * Поиск роли по имени
     * @param name имя роли
     * @return роль с таким именем
     */
     RoleEntity findByName(String name);

    @Override
    List<RoleEntity> findAll();
}
