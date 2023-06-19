package com.example.my_stadium.Repository;

import com.example.my_stadium.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager,Integer> {

}