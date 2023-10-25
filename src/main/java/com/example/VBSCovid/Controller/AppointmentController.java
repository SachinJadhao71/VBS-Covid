package com.example.VBSCovid.Controller;

import com.example.VBSCovid.DTO.RequestDTO.BookAppointmentRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.BookAppointmentResponseDto;
import com.example.VBSCovid.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody BookAppointmentRequestDto bookAppointmentRequestDto){

        BookAppointmentResponseDto responseDto = appointmentService.bookAppointment(bookAppointmentRequestDto);
    }
}
