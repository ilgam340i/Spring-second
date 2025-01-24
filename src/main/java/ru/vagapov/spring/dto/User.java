package ru.vagapov.spring.dto;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Модель пользователя, используется для уменьшения запросов к БД у слоя бизнес-логики
 */
public class User implements UserDetails {
    // идентификатор
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
    //список ролей
    private Set<Role> roles;
    //список ролей в строковом формате
    private List<String> stringRoles;
    //список книг пользователя
    private List<Book> books;

    public User() {
    }

    public User(Long id, String userName, String lastName, String email, String password, Integer age, Set<Role> roles, List<String> stringRoles, List<Book> books) {
        this.id = id;
        this.userName = userName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.roles = roles;
        this.books = books;
        this.stringRoles = stringRoles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<String> getStringRoles() {
        return stringRoles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setStringRoles(List<String> stringRoles) {
        this.stringRoles = stringRoles;
    }

    public String rolesToString() {
        StringBuilder sb = new StringBuilder();
        for (String stringRoles : stringRoles) {
            sb.append(stringRoles.replace("ROLE_", " "));
        }
        return sb.toString();

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

    @Override
    public Set<Role> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }


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
