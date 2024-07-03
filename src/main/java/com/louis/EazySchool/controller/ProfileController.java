package com.louis.EazySchool.controller;

import com.louis.EazySchool.Repository.PersonRepository;
import com.louis.EazySchool.model.Address;
import com.louis.EazySchool.model.Person;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.eazybytes.eazyschool.model.Profile;

@Controller
@Slf4j
public class ProfileController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/displayProfile")
    public ModelAndView displayProfile(Model model, HttpSession session) {
        Person person = (Person) session.getAttribute("person");
        Profile profile = new Profile();
        profile.setName(person.getName());
        profile.setEmail(person.getEmail());
        profile.setMobileNumber(person.getMobileNumber());

        if(person.getAddress() !=null && person.getAddress().getAddressId()>0){
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setCity(person.getAddress().getCity());
            profile.setState(person.getAddress().getState());
            profile.setZipCode(person.getAddress().getZipCode());
        }

        ModelAndView modelAndView = new ModelAndView("profile.html");
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }

    @RequestMapping(name = "/updateProfile",method = RequestMethod.POST)
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors errors, HttpSession session) {
        if(errors.hasErrors()){
            return "profile.html";
        }

        Person person = (Person) session.getAttribute("person");
        person.setName(profile.getName());
        person.setEmail(profile.getEmail());
        person.setMobileNumber(profile.getMobileNumber());
        if(person.getAddress() !=null && person.getAddress().getAddressId()>0){
            person.setAddress(new Address());
        }
        person.getAddress().setAddress1(profile.getAddress1());
        person.getAddress().setAddress2(profile.getAddress2());
        person.getAddress().setCity(profile.getCity());
        person.getAddress().setState(profile.getState());
        person.getAddress().setZipCode(profile.getZipCode());
        personRepository.save(person);
        session.setAttribute("loggedInPerson", person);
        return "redirect:/displayProfile";
    }


}
