package com.example.reservation.controller;
import com.example.reservation.entity.User;
import com.example.reservation.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class AuthController {
    @Autowired private UserService userService;
    @GetMapping("/login") public String loginPage() { return "login"; }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, Model model) {
        User user = userService.login(username, password);
        if (user != null) { session.setAttribute("user", user); return "redirect:/reserve"; }
        model.addAttribute("error","Invalid credentials"); return "login";
    }
    @GetMapping("/register") public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register"; }
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        if (userService.register(user)) return "redirect:/login";
        model.addAttribute("error","Username already exists!"); return "register";
    }
    @GetMapping("/logout") public String logout(HttpSession session){session.invalidate();return "redirect:/login";}
}
