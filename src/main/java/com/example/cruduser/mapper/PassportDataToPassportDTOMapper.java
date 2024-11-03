package com.example.cruduser.mapper;

import com.example.cruduser.data.PassportData;
import com.example.cruduser.dto.PassportDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PassportDataToPassportDTOMapper implements Function<PassportData, PassportDTO> {
    @Override
    public PassportDTO apply(PassportData passportData){
        return new PassportDTO(
                passportData.getId(),
                passportData.getName(),
                passportData.getSurName(),
                passportData.getDateOfMaking(),
                passportData.getExpirationDate()
        );
    }

}