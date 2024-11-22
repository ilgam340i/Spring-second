package ru.vagapov.spring.dto;

import org.springframework.security.core.GrantedAuthority;

/**
 * Модель роли пользователя, используется для уменьшения запросов к БД у слоя бизнес-логики
 */
public class Role implements GrantedAuthority {
    // id
    private Long id;
    // имя роли
    private String name;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return список ролей
     */
    @Override
    public String getAuthority() {
        return getName();
    }
}
