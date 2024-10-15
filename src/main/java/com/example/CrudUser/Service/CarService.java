package com.example.CrudUser.Service;

import com.example.CrudUser.Model.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public interface CarService {
    public ResponseEntity<List<Car>> getAllCars();

    public ResponseEntity<Car> getCarById(@PathVariable long id);


    public ResponseEntity<Car> addCarToUserById(@RequestBody Car car);


    public ResponseEntity<Car> updateCarById(@PathVariable long id,@RequestBody Car newCarData );

    public ResponseEntity<HttpStatus> deleteCarById(@PathVariable long id);
}
