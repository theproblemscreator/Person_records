package com.person.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

@Controller
public class CustomErrorController implements ErrorController {

    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(Model model) {
        model.addAttribute("message", "The page you are looking for does not exist.");
        return "404"; // Redirect to custom 404 page
    }
}
