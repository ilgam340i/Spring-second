package ru.vagapov.spring.dto;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private Long id;
    private String name;
    public Role() {};
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    /**
     * @return
     */
    @Override
    public String getAuthority() {
        return getName();
    }
}
