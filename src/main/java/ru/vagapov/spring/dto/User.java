package ru.vagapov.spring.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.vagapov.spring.entity.RoleEntity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Модель пользователя, используется для уменьшения запросов к БД у слоя бизнес-логики
 */
public class User implements UserDetails {
    // id
    private Long id;
    // имя пользователя
    private String userName;
    // фамилия пользователя
    private String lastName;
    // электронная почта пользователя
    private String email;
    // пароль пользователя
    private String password;
    //возраст пользователя
    private Integer age;

    private List<Role> roles;

    public User() {
    }

    public User(Long id, String userName, String lastName, String email, String password, Integer age) {
        this.id = id;
        this.userName = userName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<String> roleToString() {
        List<Role> rolestostring = new ArrayList<>();
        for (Role role : roles) {
            role.getName();
            rolestostring.add(role);
        }
        return rolestostring.stream().map(Role::getName).collect(Collectors.toList());

    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    /**
     * @return
     */
    @Override
    public List<ru.vagapov.spring.dto.Role> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    /**
     * @return
     */
    @Override
    public String getUsername() {
        return userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, lastName, email, password, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
