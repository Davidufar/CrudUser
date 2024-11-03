package com.example.cruduser.mapper;

import com.example.cruduser.data.PassportData;
import com.example.cruduser.model.Passport;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PassportToPassportDataMapper implements Function<Passport, PassportData> {
    @Override
    public PassportData apply(Passport passport){
        return new PassportData(
                passport.getId(),
                passport.getName(),
                passport.getSurName(),
                passport.getDateOfMaking(),
                passport.getExpirationDate(),
                passport.getSerialNumber()
        );
    }

}
