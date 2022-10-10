package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        model.addAttribute("title", "add a new user");
        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, Errors errors, @ModelAttribute User user, String verify) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "add a new user");
            return "user/add";
        }
        return "user/index";
    }
}
