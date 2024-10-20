package com.example.cruduser.controller;

import com.example.cruduser.model.Car;
import com.example.cruduser.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {


    @Autowired
    private CarService carService;

    @GetMapping("/getAllCars")
    public ResponseEntity<List<Car>> getAllCars(){
        return carService.getAllCars();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id){
        return carService.getCarById(id);
    }

    @PostMapping("/addCar")
    public ResponseEntity<Car> addCarToUserById(@RequestBody @Valid Car car){
        return carService.addCarToUserById(car);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable long id,@RequestBody @Valid Car newCarData ){
        return carService.updateCarById(id,newCarData);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCarById(@PathVariable long id){
        return carService.deleteCarById(id);
    }
}
