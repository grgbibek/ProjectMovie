package com.project.controller;

import com.project.model.Hall;

import com.project.services.HallServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by grgbibek22 on 12/19/2017.
 */
@Controller
@ResponseBody
@RequestMapping("/hall")
public class HallController {
    @Autowired
    HallServices hallServices;

            /*  READ HALL BY ID     */
    @RequestMapping("/{hallId}")
    public Hall getHallById(@PathVariable(value = "hallId") int hallId ){
        return hallServices.getHallById(hallId);
    }

        /*  CREATE  */
    @RequestMapping(value = "/add/{hallName}/{numberOfScreen}/{location}",method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void saveHall(@PathVariable("hallName") String hallName,@PathVariable("numberOfScreen") String numberOfScreen,@PathVariable("location") String location){
        Hall hall = new Hall();
        hall.setHallName(hallName);
        hall.setNumberOfScreen(numberOfScreen);
        hall.setLocation(location);

        hallServices.addHall(hall);
    }

        /*  GET HALL LIST   */
    @RequestMapping(value="/getHallList", method = RequestMethod.GET)
    public List<Hall> getHallList(){
       return hallServices.gethallList();
    }

    @RequestMapping(value = "/update/{Id}/{hallName}/{numberOfScreen}/{location}",method = RequestMethod.PUT, headers="Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateHall(@PathVariable("Id") int Id,@PathVariable("hallName") String hallName,@PathVariable("numberOfScreen") String numberOfScreen,@PathVariable("location") String location){
        Hall hall = new Hall();
        hall.setId(Id);
        hall.setHallName(hallName);
        hall.setNumberOfScreen(numberOfScreen);
        hall.setLocation(location);

        hallServices.updateHall(hall);
    }

    @RequestMapping(value = "/delete/{hallId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteHall(@PathVariable("hallId") int hallId){
        Hall hall = hallServices.getHallById(hallId);
        hallServices.removeHall(hall);
    }




}
