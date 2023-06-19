package com.example.my_stadium.Services;

import com.example.my_stadium.Model.Sport;
import com.example.my_stadium.Repository.SportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportServices {

    @Autowired
    private SportRepo sportRepo;

    public List<Sport> getAll() {
        return sportRepo.findAll();
    }

    public Sport getSportById(int id) {
        return sportRepo.findById(id).orElse(null);
    }

    public void create(Sport sport) {
        sportRepo.save(sport);
    }

    public void updateSport(Integer id, Sport sport) {
        Sport existingSport = sportRepo.findById(id).orElse(null);
        if (existingSport != null) {
            existingSport.setType(sport.getType());
            existingSport.setDate(sport.getDate());
            sportRepo.save(existingSport);
        }
    }

    public void delete(Integer id) {
        sportRepo.deleteById(id);
    }
}
