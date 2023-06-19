package com.example.my_stadium.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Playarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playId;
    private String areaSize;
    private String location;

    public int getPlayId() {
        return playId;
    }

    public Playarea() {
    }

    public Playarea(int playId, String areaSize, String location) {
        this.playId = playId;
        this.areaSize = areaSize;
        this.location = location;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }

    public String getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(String areaSize) {
        this.areaSize = areaSize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
