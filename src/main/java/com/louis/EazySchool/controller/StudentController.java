package com.louis.EazySchool.controller;

import com.louis.EazySchool.Repository.CourseRepository;
import com.louis.EazySchool.Repository.EazyClassRepository;
import com.louis.EazySchool.Repository.PersonRepository;
import com.louis.EazySchool.model.Person;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/student")
public class StudentController {
    @Autowired
    EazyClassRepository eazyClassRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model, HttpSession session) {
        Person person = (Person) session.getAttribute("loggedInPerson");
        ModelAndView modelAndView = new ModelAndView("courses_enrolled.html");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
