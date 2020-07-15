package com.coursework.movies.controller.home;

import com.coursework.movies.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends AbstractController {


    @GetMapping("")
    public ModelAndView getHomePage() {

        return this.getView("index.html");
    }



}
