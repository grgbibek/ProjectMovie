package com.project.controller;

import com.project.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by grgbibek22 on 11/25/2017.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/hallList")
    public String halls(){
        return "hallList";
    }

    @RequestMapping(value = "/addMovie", method= RequestMethod.GET)
    public String addMovie(Model model){
        model.addAttribute("hall", new Movie());
        return "hall";
    }

}
