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
    public Actor getActorById(@PathVariable(value = "actorId") int actorId ){
        return actorServices.getActorById(actorId);
    }

    /*  CREATE  */
    @RequestMapping(value = "/add",method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void saveActor(@RequestBody Actor actor){
        actorServices.addActor(actor);
    }

    /*  GET HALL LIST   */
    @RequestMapping(value="/getActorList", method = RequestMethod.GET)
    public List<Actor> getActorList(){
        return actorServices.getActorList();
    }

    /*      Update Actor  */
    @RequestMapping(value = "/update",method = RequestMethod.PUT, headers="Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateActor(@RequestBody Actor actor){

        actorServices.updateActor(actor);
    }

    @RequestMapping(value = "/delete/{actorId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteActor(@PathVariable("actorId") int actorId){
        Actor actor = actorServices.getActorById(actorId);
        actorServices.removeActor(actor);
    }

}
