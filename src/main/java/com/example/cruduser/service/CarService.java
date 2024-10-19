package com.example.cruduser.service;

import com.example.cruduser.model.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CarService {
    public ResponseEntity<List<Car>> getAllCars();

    public ResponseEntity<Car> getCarById( long id);


    public ResponseEntity<Car> addCarToUserById( Car car);


    public ResponseEntity<Car> updateCarById( long id, Car newCarData );

    public ResponseEntity<HttpStatus> deleteCarById( long id);
}
