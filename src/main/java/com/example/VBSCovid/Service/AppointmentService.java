package com.example.VBSCovid.Service;

import com.example.VBSCovid.DTO.RequestDTO.BookAppointmentRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.BookAppointmentResponseDto;
import com.example.VBSCovid.Exception.DoctorNotFoundException;
import com.example.VBSCovid.Exception.PersonDoesNotExistException;
import com.example.VBSCovid.Model.Doctor;
import com.example.VBSCovid.Model.Person;
import com.example.VBSCovid.Repository.DoctorRepository;
import com.example.VBSCovid.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public BookAppointmentResponseDto bookAppointment(BookAppointmentRequestDto bookAppointmentRequestDto) {

//        check that person is exists or not

        Person person = personRepository.findByEmailId(bookAppointmentRequestDto.getPersonEmail());

        if(person == null){
            throw new PersonDoesNotExistException("person Not Found");
        }

        Doctor doctor = doctorRepository.findByEmailId(bookAppointmentRequestDto.getDoctorEmail());

        if(doctor == null){
            throw new DoctorNotFoundException("Doctor is not present..");
        }
    }
}
