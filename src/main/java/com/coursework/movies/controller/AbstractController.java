package com.coursework.movies.controller;

import org.springframework.web.servlet.ModelAndView;

public class AbstractController {

    protected ModelAndView getView(String view, ModelAndView modelAndView) {
        modelAndView.setViewName(view);
        return modelAndView;
    }


    protected ModelAndView getView(String view) {
        return this.getView(view, new ModelAndView());
    }

    protected ModelAndView redirect(String redirectRoute) {
        return this.getView("redirect:"+redirectRoute);
    }
}
