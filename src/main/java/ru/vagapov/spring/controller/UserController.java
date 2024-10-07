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

    @Autowired
    private final UserService userService;
    private final UserMapper userMapper;

    private UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;

    }

    @GetMapping("/")
    public String home(Model model) {
        userService.createUser(null);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping("/new")
    public String newUserForm(Model model) {
        UserMapper user = new UserMapper();
        model.addAttribute("user", user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/id")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/";
    }

    @PutMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable Long id) {
        user.setId(id);
        return "redirect:/edit/" + id;
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("id") User user) {
        user.setId(id);
        userMapper.toEntity(user);
        updateUser(id, user);
        return "redirect:/";
    }


    //добавьте url на удаление = /delete который принимает id пользака, после перебрасывает на основную страницу
    //добавьте url на редактирование = /edit который принимает id пользака и перебрасывает на страницу с редактированием (новая страница)
    //добавьте url на постредактирование = /{id} который принимает id пользака в пути и ДТО отредактированого пользователя, после у нас в программе происходит update и перебрасывает на основную страницу
}
