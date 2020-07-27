package com.coursework.movies.controller.login;

import com.coursework.movies.controller.AbstractController;
import com.coursework.movies.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends AbstractController {

    @Autowired
    private UserService userService;




    /**
     * GetLoginPage method.
     *
     * @param error - error in the view.
     * @param model - model object for the page.
     * @return ModelAndView - returns the login view.
     */
    @GetMapping("/login")
    public ModelAndView getLoginPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        return this.getView("login");
    }

    /**
     * loginPost method that redirects to user home.
     *
     * @return returns redirected view for user.
     */
    @PostMapping(value = "/loginPost")
    public ModelAndView loginPost() {
        return this.redirect("movie/all");
    }


}
