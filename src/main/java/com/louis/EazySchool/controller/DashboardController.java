package com.louis.EazySchool.controller;


import com.louis.EazySchool.Repository.PersonRepository;
import com.louis.EazySchool.model.Person;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
        Person person = personRepository.findByEmail(authentication.getName());

        // Store person information inside a http session
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", person.getRole().toString());

        // get the class name for the person (for students)
        if(null != person.getEazyClass() && null != person.getEazyClass().getName()){
            model.addAttribute("enrolledClass", person.getEazyClass().getName());
        }
        session.setAttribute("loggedInPerson", person);
        return "dashboard.html";
    }
}
