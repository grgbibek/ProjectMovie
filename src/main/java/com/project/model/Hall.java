package com.project.model;

import javax.persistence.*;

/**
 * Created by grgbibek22 on 12/19/2017.
 */
@Entity
@Table(name="hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String hallName;
    private String numberOfScreen;
    private String location;

    public int getHallId() {
        return Id;
    }

    public void setHallId(int Id) {
        this.Id = Id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getNumberOfScreen() {
        return numberOfScreen;
    }

    public void setNumberOfScreen(String numberOfScreen) {
        this.numberOfScreen = numberOfScreen;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
