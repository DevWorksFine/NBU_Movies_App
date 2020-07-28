package com.coursework.movies.controller.home;

import com.coursework.movies.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController extends AbstractController {


    @GetMapping("")
    public ModelAndView getHomePage(Principal principal, ModelAndView modelAndView) {
//        modelAndView.addObject("user",principal.getName());

        return this.getView("index.html",modelAndView);
    }



}
