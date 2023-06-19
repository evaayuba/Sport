package com.example.my_stadium.Controller;

import com.example.my_stadium.Model.Playarea;
import com.example.my_stadium.Repository.PlayareaRepo;
import com.example.my_stadium.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/playarea")
public class PlayareaController {

    private final PlayareaRepo playareaRepo;

    @Autowired
    public PlayareaController(PlayareaRepo playareaRepo) {
        this.playareaRepo = playareaRepo;
    }

    @GetMapping("/all")
    public List<Playarea> getAllPlayarea(){
        return playareaRepo.findAll();
    }

    @PostMapping("/save")
    public Playarea addPlayarea(@RequestBody Playarea playarea){
        return playareaRepo.save(playarea);
    }

    @GetMapping("Playarea/{id}")
    public ResponseEntity<Playarea> getById(@PathVariable Integer id){
        Playarea playarea = playareaRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Playarea not found with id: " + id));
        return ResponseEntity.ok(playarea);
    }

    @PutMapping("update/{playid}")
    public ResponseEntity<Playarea> updatePlayarea(@RequestBody Playarea playarea, @PathVariable Integer id){
        Playarea existingPlayarea = playareaRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Playarea not found with id: " + id));

        existingPlayarea.setAreaSize(playarea.getAreaSize());
        existingPlayarea.setLocation(playarea.getLocation());

        Playarea updatedPlayarea = playareaRepo.save(existingPlayarea);
        return ResponseEntity.ok(updatedPlayarea);
    }
    @DeleteMapping("/delete{playid}")
    public  ResponseEntity<?>delete(@PathVariable int playid) {
        try {
            playareaRepo.deleteById(playid);
            return new ResponseEntity<>("succesfuly delete", HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
        }
    }
}
