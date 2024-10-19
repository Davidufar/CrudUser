package com.example.cruduser.dao;

import com.example.cruduser.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

}
