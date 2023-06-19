package com.example.my_stadium.Services;

import com.example.my_stadium.Model.Manager;
import com.example.my_stadium.Repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServices {
    @Autowired
    private ManagerRepo managerRepo;

    public List<Manager> getAll() {
        return managerRepo.findAll();
    }

    public Manager getManagerById(int id) {
        return managerRepo.findById(id).orElse(null);
    }

    public void create(Manager manager) {
        managerRepo.save(manager);
    }

    public void updateManager(Integer id, Manager manager) {
        Manager existingManager = managerRepo.findById(id).orElse(null);
        if (existingManager != null) {
            existingManager.setEmail(manager.getEmail());
            managerRepo.save(existingManager);
        }
    }

    public void delete(Integer id) {
        managerRepo.deleteById(id);
    }
}
