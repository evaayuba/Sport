package com.example.my_stadium.Services;

import com.example.my_stadium.Model.Playarea;
import com.example.my_stadium.Repository.PlayareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayareaServices {

    @Autowired
    private PlayareaRepo playareaRepo;

    public List<Playarea> getAll() {
        return playareaRepo.findAll();
    }

    public Playarea getPlayareaById(int id) {
        return playareaRepo.findById(id).orElse(null);
    }

    public void create(Playarea playarea) {
        playareaRepo.save(playarea);
    }

    public void updatePlayarea(Integer id, Playarea playarea) {
        Playarea existingPlayarea = playareaRepo.findById(id).orElse(null);
        if (existingPlayarea != null) {
//            existingPlayarea.setName(playarea.getName());
            existingPlayarea.setLocation(playarea.getLocation());
            playareaRepo.save(existingPlayarea);
        }
    }

    public void delete(Integer id) {
        playareaRepo.deleteById(id);
    }
}
