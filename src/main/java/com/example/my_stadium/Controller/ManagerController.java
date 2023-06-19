package com.example.my_stadium.Controller;

import com.example.my_stadium.Model.Manager;
import com.example.my_stadium.Repository.ManagerRepo;
import com.example.my_stadium.Services.ManagerServices;
import com.example.my_stadium.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {

    private final ManagerRepo managerRepo;

    @Autowired
    public ManagerController(ManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }

    @GetMapping("/all")
    public List<Manager> getAllManager() {
        return managerRepo.findAll();
    }

    @PostMapping("/save")
    public Manager addManager(@RequestBody Manager manager) {
        return managerRepo.save(manager);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getById(@PathVariable Integer id) {
        Manager manager = managerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Manager not found with id: " + id));
        return ResponseEntity.ok(manager);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<Manager> updateManager(@RequestBody Manager manager, @PathVariable Integer id) {
        Manager existingManager = managerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Manager not found with id: " + id));

        existingManager.setId(manager.getId());
        existingManager.setName(manager.getName());
        existingManager.setEmail(manager.getEmail());
        existingManager.setPhone(manager.getPhone());
        Manager updatedManager = managerRepo.save(existingManager);
        return ResponseEntity.ok(updatedManager);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            managerRepo.deleteById(id);
            return new ResponseEntity<>("succesfuly delete", HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
        }
    }
}