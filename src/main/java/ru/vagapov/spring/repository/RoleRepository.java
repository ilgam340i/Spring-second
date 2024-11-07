package ru.vagapov.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vagapov.spring.entity.RoleEntity;

import javax.management.relation.Role;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
