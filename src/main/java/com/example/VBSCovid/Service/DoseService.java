package com.example.VBSCovid.Service;

import com.example.VBSCovid.DTO.RequestDTO.GetDoseRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.GetDoseResponseDto;
import com.example.VBSCovid.Exception.Dose1AlreadyTakenException;
import com.example.VBSCovid.Exception.Dose1NotCompletedException;
import com.example.VBSCovid.Exception.Dose2AlreadyTakenException;
import com.example.VBSCovid.Exception.PersonDoesNotExistException;
import com.example.VBSCovid.Model.Certificate;
import com.example.VBSCovid.Model.Dose;
import com.example.VBSCovid.Model.Person;
import com.example.VBSCovid.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    JavaMailSender javaMailSender;
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



//        generating certificate after both doses are completed

        Certificate certificate = new Certificate();
        certificate.setCertificateId(String.valueOf(UUID.randomUUID()));
        certificate.setPersonName(person.getName());
        certificate.setPerson(person);
        certificate.setMessage("Congratulation, Your Both Doses are completed.");

        person.setCertificate(certificate);

        Person savedPerson = personRepository.save(person);

        Dose savedDose = savedPerson.getDosesTaken().get(1);

        GetDoseResponseDto responseDto = new GetDoseResponseDto();
        responseDto.setPersonName(savedPerson.getName());
        responseDto.setDoseType(savedDose.getDoseType());
        responseDto.setVaccinationDate(savedDose.getVaccinationDate());

//        mail sending

        String text = "Hello Mr/Mrs. " +savedPerson.getName() +" \n" +
                "First of all, congratulations on completing both of your vaccines.\n" +
                "We have been able to vaccinate on such a large scale only because of the cooperation of many people like you.\n" +
                "You have been vaccinated so now you have no fear of corona.\n" +
                "Still it is our duty to care and refer those who are not yet vaccinated for. And we hope you will certainly cooperate in this.\n" +
                "\n" +
                "Once again congratulations...!!\n" +
                "\n" +
                "Your complete vaccination details are as follows:-" + "\n" +
                "Dose 1 :- " + savedPerson.getDosesTaken().get(0).getDoseType() + "\n" +
                "Dose 2 :- " + savedPerson.getDosesTaken().get(1).getDoseType() + "\n" ;




        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("VaccinationBooking123@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmailId());
        simpleMailMessage.setSubject("Congrats.. Your Vaccination is Done..!");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);



        return responseDto;
    }
}
