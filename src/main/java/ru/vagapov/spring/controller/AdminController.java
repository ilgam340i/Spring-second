package ru.vagapov.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vagapov.spring.dto.Role;
import ru.vagapov.spring.dto.User;
import ru.vagapov.spring.service.UserService;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String home(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "keyWord") String keyWord, Model model) {
        List<User> users = userService.findUsersByAnyWord(keyWord);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/admin";

    }

    @DeleteMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/{id}/edituser", method = RequestMethod.GET)
    public String editUser( Model model, @PathVariable Long id) {
        List<String> rOles = new ArrayList<String>();
        List < Role> rOleList = userService.findById(id).getRoles();
        for (Role role : rOleList) {
            rOles.add(role.getName());
        }
        model.addAttribute("user",rOles);
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PatchMapping(value = "/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return "redirect:/admin";
    }
}