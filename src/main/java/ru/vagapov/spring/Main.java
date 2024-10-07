package ru.vagapov.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vagapov.spring.config.AppConfig;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        //Здесь можете протестировать создание своих пользователей
        userService.createUser(new User(1L,"Isyangulov","ilham","ii@mail", "qwerty",29));
        userService.createUser(new User(2l,"Isyangulov", "Dayan", "di@mail", "qwerty1",28));
        userService.createUser(new User(3L,"Vagapov", "Vadim","vv@mail", "qwerty2",28));
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        ctx.close();
    }
}