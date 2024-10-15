package com.example.CrudUser.Controller;

import com.example.CrudUser.Model.Car;
import com.example.CrudUser.Model.User;
import com.example.CrudUser.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/getCarById/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id){
        return carService.getCarById(id);
    }

    @PostMapping("/addCar")
    public ResponseEntity<Car> addCarToUserById(@RequestBody Car car){
        return carService.addCarToUserById(car);
    }

    @PostMapping("/updateCarById/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable long id,@RequestBody Car newCarData ){
        return carService.updateCarById(id,newCarData);
    }
    @DeleteMapping("/deleteCarById/{id}")
    public ResponseEntity<HttpStatus> deleteCarById(@PathVariable long id){
        return carService.deleteCarById(id);
    }
}
