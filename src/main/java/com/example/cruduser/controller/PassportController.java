package com.example.cruduser.controller;

import com.example.cruduser.data.PassportData;
import com.example.cruduser.mapper.PassportDataToPassportDTOMapper;
import com.example.cruduser.model.Passport;
import com.example.cruduser.dto.PassportDTO;
import com.example.cruduser.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {
    @Autowired
    PassportDataToPassportDTOMapper passportDataToPassportDTOMapper = new PassportDataToPassportDTOMapper();

    @Autowired
    private PassportService passportService;

    @GetMapping("/getAllPassports")
    public List<PassportDTO> getAllPassports(){

        List<PassportData> allPassportsData = passportService.getAllPassports();
        List<PassportDTO> passportDTOList = new ArrayList<>();
        for (PassportData passportData : allPassportsData) {
            passportDTOList.add(passportDataToPassportDTOMapper.apply(passportData));
        }
        return passportDTOList;
    }
    @GetMapping("/{id}")
    public PassportDTO getPassportById(@PathVariable long id){

        return passportDataToPassportDTOMapper.apply(passportService.getPassportById(id));
    }

    @PostMapping("/addPassport")
    public ResponseEntity<HttpStatus> addPassport(@RequestBody @Valid Passport passport){return passportService.addPassport(passport);
    }

    @PostMapping("/{id}")
    public ResponseEntity<HttpStatus> updatePassportById(@PathVariable long id,@RequestBody @Valid Passport newPassportData ){return passportService.updatePassportById(id, newPassportData);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePassportById(@PathVariable long id){return passportService.deletePassportById(id);
    }
}
