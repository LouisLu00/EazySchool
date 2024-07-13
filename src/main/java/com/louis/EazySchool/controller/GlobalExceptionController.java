package com.louis.EazySchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception) {
         ModelAndView errorPage = new ModelAndView();
         errorPage.setViewName("error");
         errorPage.addObject("errormsg",exception.getMessage());
         return errorPage;
    }

}
