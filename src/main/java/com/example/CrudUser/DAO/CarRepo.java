package com.example.CrudUser.DAO;

import com.example.CrudUser.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

}
