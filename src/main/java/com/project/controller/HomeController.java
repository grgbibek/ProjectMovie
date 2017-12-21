package com.project.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.model.Hall;

import com.project.services.HallServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @RequestMapping(value = "/hall")
    public String hall(){
        return "hall";
    }

   /* @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/hall/add", method = RequestMethod.POST, headers="Accept=application/json")
    public void saveHall(@RequestBody Hall hall){
        System.out.println("Ayonita Hall");
        System.out.println(hall.getHallName());
        System.out.println(hall.getLocation());
        System.out.println(hall.getNumberOfScreen());

    }*/

    @Autowired
    private HallServices hallServices;

    /*@ResponseBody
    @RequestMapping(value = "/hall/listOfHalls", method = RequestMethod.GET)
    public ResponseEntity<List<Hall>> listAllHalls() {
        List<Hall> halls = hallServices.gethallList();
        if(halls.isEmpty()){
            return new ResponseEntity<List<Hall>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Hall>>(halls, HttpStatus.OK);
    }*/

    @RequestMapping(value = "/hall/createHall", method = RequestMethod.POST)
    public ResponseEntity<Void> createHall(@RequestBody Hall hall,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Hall " + hall.getHallName());


        if (isHallExist(hall)) {
            System.out.println("A Hall with name " + hall.getHallName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        hallServices.addHall(hall);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(hall.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    private List<Hall> halls;

    public Hall findByName(String hallName) {
        for(Hall hall : halls){
            if(hall.getHallName().equalsIgnoreCase(hallName)){
                return hall;
            }
        }
        return null;
    }

    public boolean isHallExist(Hall hall) {
        return findByName(hall.getHallName())!=null;
    }
}
