package com.example.VBSCovid.Service;

import com.example.VBSCovid.DTO.RequestDTO.GetDoseRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.GetDoseResponseDto;
import com.example.VBSCovid.Exception.Dose1AlreadyTakenException;
import com.example.VBSCovid.Exception.Dose1NotCompletedException;
import com.example.VBSCovid.Exception.Dose2AlreadyTakenException;
import com.example.VBSCovid.Exception.PersonDoesNotExistException;
import com.example.VBSCovid.Model.Dose;
import com.example.VBSCovid.Model.Person;
import com.example.VBSCovid.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    PersonRepository personRepository;
    public GetDoseResponseDto getDose1(GetDoseRequestDto requestDto) {

        Person person = personRepository.findByEmailId(requestDto.getPersonEmail());

        if(person==null){
            throw new PersonDoesNotExistException("Person Not Found");
        }

        if(person.isDose1Taken()){
            throw new Dose1AlreadyTakenException("You have already taken dose 1");
        }

        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(requestDto.getDoseType());
        dose.setPerson(person);

        person.setDose1Taken(true);

        person.getDosesTaken().add(dose);

        Person savedperson = personRepository.save(person);

        Dose savedDose = savedperson.getDosesTaken().get(0);

        GetDoseResponseDto responseDto = new GetDoseResponseDto();
        responseDto.setDoseType(savedDose.getDoseType());
        responseDto.setPersonName(savedperson.getName());
        responseDto.setVaccinationDate(savedDose.getVaccinationDate());


        return responseDto;

    }

    public GetDoseResponseDto getDose2(GetDoseRequestDto requestDto) {

        Person person = personRepository.findByEmailId(requestDto.getPersonEmail());

        if(person==null){
            throw new PersonDoesNotExistException("Person Not Found");
        }

        if(!person.isDose1Taken()){
            throw new Dose1NotCompletedException("Your Dose 1 is not Completed, so first Take Dose1.");
        }

        if(person.isDose2Taken()){
            throw new Dose2AlreadyTakenException("You have already taken dose 2");
        }

        Dose dose  = new Dose();
        dose.setDoseType(requestDto.getDoseType());
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setPerson(person);

        person.setDose2Taken(true);
        person.getDosesTaken().add(dose);

        Person savedPerson = personRepository.save(person);

        Dose savedDose = savedPerson.getDosesTaken().get(1);

        GetDoseResponseDto responseDto = new GetDoseResponseDto();
        responseDto.setPersonName(savedPerson.getName());
        responseDto.setDoseType(savedDose.getDoseType());
        responseDto.setVaccinationDate(savedDose.getVaccinationDate());


        return responseDto;
    }
}
