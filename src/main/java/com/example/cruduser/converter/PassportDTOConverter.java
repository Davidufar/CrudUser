package com.example.cruduser.converter;

import com.example.cruduser.model.Passport;
import com.example.cruduser.model.PassportDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PassportDTOConverter implements Function<Passport, PassportDTO> {
    @Override
    public PassportDTO apply(Passport passport){
        return new PassportDTO(
                passport.getId(),
                passport.getName(),
                passport.getSurName(),
                passport.getDateOfMaking(),
                passport.getExpirationDate()
        );
    }

}
