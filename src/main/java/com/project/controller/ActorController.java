package com.project.controller;

import com.project.model.Actor;
import com.project.services.ActorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by grgbibek22 on 12/20/2017.
 */
@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorServices actorServices;

    /*  READ HALL BY ID     */
    @RequestMapping("/{actorId}")
    public Actor getHallById(@PathVariable(value = "actorId") int actorId ){
        return actorServices.getActorById(actorId);
    }

    /*  CREATE  */
    @RequestMapping(value = "/add/{Name}/{Role}/{age}/{sex}",method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void saveActor(@PathVariable("Name") String Name,@PathVariable("Role") String Role, @PathVariable("age") int age, @PathVariable("sex") String sex){
        Actor actor = new Actor();
        actor.setName(Name);
        actor.setRole(Role);
        actor.setAge(age);
        actor.setSex(sex);

        actorServices.addActor(actor);
    }

    /*  GET HALL LIST   */
    @RequestMapping(value="/getActorList", method = RequestMethod.GET)
    public List<Actor> getActorList(){
        return actorServices.getActorList();
    }

    @RequestMapping(value = "/update/{Id}/{Name}/{Role}/{age}/{sex}",method = RequestMethod.PUT, headers="Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateActor(@PathVariable("Id") int Id,@PathVariable("Name") String Name,@PathVariable("Role") String Role,@PathVariable("age") int age,@PathVariable("sex") String sex) {
        Actor actor = new Actor();
        actor.setId(Id);
        actor.setName(Name);
        actor.setRole(Role);
        actor.setAge(age);
        actor.setSex(sex);

        actorServices.addActor(actor);
    }

    @RequestMapping(value = "/delete/{actorId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteHall(@PathVariable("actorId") int actorId){
        Actor actor = actorServices.getActorById(actorId);
        actorServices.removeActor(actor);
    }

}
