package com.example.VBSCovid.Service;

import com.example.VBSCovid.DTO.RequestDTO.PersonRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.PersonResponseDto;
import com.example.VBSCovid.Exception.PersonDoesNotExistException;
import com.example.VBSCovid.Exception.UnderAgeException;
import com.example.VBSCovid.Model.Person;
import com.example.VBSCovid.Repository.PersonRepository;
import com.example.VBSCovid.Transformer.PersonTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    public PersonResponseDto addPerson(PersonRequestDto personRequestDto) {

        if(personRequestDto.getAge() < 18){
            throw new UnderAgeException("Your are under age, That's why you are not eligible to take vaccine.");
        }
        Person person = PersonTransformer.PersonRequestDtoToPerson(personRequestDto);

        Person savedPerson = personRepository.save(person);

        PersonResponseDto responseDto = PersonTransformer.PersonToPerSonResponseDto(savedPerson);

        return responseDto;
    }

    public PersonResponseDto getPerson(int id) {

        Optional<Person> optionalPerson = personRepository.findById(id);

        if(optionalPerson.isEmpty()){
            throw new PersonDoesNotExistException("person does not exists, Register First !!");
        }

        Person person = optionalPerson.get();

        return PersonTransformer.PersonToPerSonResponseDto(person);
    }
}
