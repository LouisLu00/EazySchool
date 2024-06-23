package com.louis.EazySchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping(value ="/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
                                   @RequestParam(value = "logout", required = false) String logout,
                                   Model model) {
        String errorMsg = null;
        if (error != null) {
            errorMsg = "Invalid username or password!";
        }
        if (logout != null) {
            errorMsg = "You have been logged out successfully!";
        }

        model.addAttribute("errorMessge", errorMsg);
        return "login.html";
    }
}
