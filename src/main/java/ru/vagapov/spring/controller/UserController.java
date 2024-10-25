package ru.vagapov.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.entity.UserEntity;
import ru.vagapov.spring.mapper.UserMapper;
import ru.vagapov.spring.service.UserService;

import java.util.List;

/**
 * Отправка и прием HTTP-запросов, использует DTO
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";

    }

    @PostMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}/edituser", method = RequestMethod.GET)
    public String editUser(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user, id);
        return "redirect:/";
    }

    //добавьте url на удаление = /delete который принимает id пользака, после перебрасывает на основную страницу
    //добавьте url на редактирование = /edit который принимает id пользака и перебрасывает на страницу с редактированием (новая страница)
    //добавьте url на постредактирование = /{id} который принимает id пользака в пути и ДТО отредактированого пользователя, после у нас в программе происходит update и перебрасывает на основную страницу
}
