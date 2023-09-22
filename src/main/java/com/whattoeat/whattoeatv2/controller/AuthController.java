package com.whattoeat.whattoeatv2.controller;

import com.whattoeat.whattoeatv2.dto.UserDto;
import com.whattoeat.whattoeatv2.entity.User;
import com.whattoeat.whattoeatv2.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class AuthController {

    private IUserService userService;

    @GetMapping("/login")
    public String loginForm() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User emailExisting = userService.findByEmail(user.getEmail());
        User usernameExisting = userService.findByUsername(user.getUsername());
        if (emailExisting != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (usernameExisting != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

}
