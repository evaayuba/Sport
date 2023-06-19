package com.example.my_stadium.Repository;

import com.example.my_stadium.Model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepo extends JpaRepository<Sport,Integer> {

}