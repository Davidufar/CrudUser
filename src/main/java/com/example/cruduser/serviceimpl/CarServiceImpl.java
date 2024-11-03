package com.example.cruduser.serviceimpl;

import com.example.cruduser.dao.CarRepo;
import com.example.cruduser.model.Car;
import com.example.cruduser.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;
    public ResponseEntity<List<Car>> getAllCars(){
        try{
            List<Car> carList = new ArrayList<>();
            carRepo.findAll().forEach(carList::add);


            if(carList.isEmpty()){
                return new ResponseEntity<>(carList, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(carList,HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Car> getCarById( long id){
        Optional<Car> carData = carRepo.findById(id);

        if(carData.isPresent()){
            return new ResponseEntity<>(carData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
@Override
    public ResponseEntity<Car> addCarToUserById( Car car){
        Car carObj = carRepo.save(car);

        return new ResponseEntity<>(carObj,HttpStatus.OK);
    }


    public ResponseEntity<Car> updateCarById( long id, Car newCarData ){
        Optional<Car> oldCarData = carRepo.findById(id);

        if(oldCarData.isPresent()){
            Car updatedCarData = oldCarData.get();
            updatedCarData.setModelName(newCarData.getModelName());
            updatedCarData.setYearOfProduction(newCarData.getYearOfProduction());

            Car carObj = carRepo.save(updatedCarData);
            return new ResponseEntity<>(carObj, HttpStatus.OK );

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> deleteCarById(@PathVariable long id){
        carRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
