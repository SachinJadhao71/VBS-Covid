package com.example.VBSCovid.Transformer;

import com.example.VBSCovid.DTO.RequestDTO.PersonRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.PersonResponseDto;
import com.example.VBSCovid.Model.Person;

public class PersonTransformer {

    public static Person PersonRequestDtoToPerson(PersonRequestDto personRequestDto){
        return Person.builder().
                name(personRequestDto.getName()).
                age(personRequestDto.getAge()).
                gender(personRequestDto.getGender()).
                emailId(personRequestDto.getEmailId()).build();
    }

    public static PersonResponseDto PersonToPerSonResponseDto(Person person){

        return PersonResponseDto.builder()
                .age(person.getAge()).emailId(person.getEmailId()).gender(person.getGender()).name(person.getName())
                .build();
    }
}
