package ru.vagapov.spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.service.UserService;

/**
 * Отправка и прием HTTP-запросов, использует DTO
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String info( Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.findUserByUserName(name);
        model.addAttribute("user", user);
        return "user";}


    //добавьте url на удаление = /delete который принимает id пользака, после перебрасывает на основную страницу
    //добавьте url на редактирование = /edit который принимает id пользака и перебрасывает на страницу с редактированием (новая страница)
    //добавьте url на постредактирование = /{id} который принимает id пользака в пути и ДТО отредактированого пользователя, после у нас в программе происходит update и перебрасывает на основную страницу
}
