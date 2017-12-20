package com.project.controller;

import com.project.model.Hall;
import com.project.services.HallServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by grgbibek22 on 12/19/2017.
 */
@Controller
@RequestMapping("/hall")
public class HallController {
    @Autowired
    HallServices hallServices;


    @RequestMapping("")
    public String halls(){
        return "hallList";
    }

    @RequestMapping(value = "/addHall", method= RequestMethod.GET)
    public String addHall(Model model){
        model.addAttribute("hall", new Hall());
        return "hall";
    }

    @RequestMapping("/{hallId}")
    public @ResponseBody Hall getHallById(@PathVariable(value = "hallId") int hallId ){
        return hallServices.getHallById(hallId);
    }

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void saveHall(@ModelAttribute("Hall") Hall hall){
        hallServices.addHall(hall);
    }


}
