package com.example.my_stadium.Controller;

import com.example.my_stadium.Model.Sport;
import com.example.my_stadium.Repository.SportRepo;
import com.example.my_stadium.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sport")
public class SportController {

    private final SportRepo sportRepo;

    @Autowired
    public SportController(SportRepo sportRepo) {
        this.sportRepo = sportRepo;
    }

    @GetMapping("/all")
    public List<Sport> getAllSport() {
        return sportRepo.findAll();
    }

    @PostMapping("/save")
    public Sport addSport(@RequestBody Sport sport) {
        return sportRepo.save(sport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> getById(@PathVariable Integer id) {
        Sport sport = sportRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sport not found with id: " + id));
        return ResponseEntity.ok(sport);
    }

    @PutMapping("/update{sportid}")
    public ResponseEntity<Sport> updateSport(@RequestBody Sport newSport, @PathVariable Integer id) {
        Sport existingSport = sportRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sport not found with id: " + id));

        existingSport.setSportId(newSport.getSportId());
        existingSport.setDate(newSport.getDate());
        existingSport.setType(newSport.getType());

        Sport updatedSport = sportRepo.save(existingSport);
        return ResponseEntity.ok(updatedSport);
    }

    @DeleteMapping("/delete{sportid}")
    public ResponseEntity<?> delete(@PathVariable int sportid) {
        try {
            sportRepo.deleteById(sportid);
            return new ResponseEntity<>("succesfuly delete", HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
        }
    }
}
