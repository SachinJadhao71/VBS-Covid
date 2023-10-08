package com.example.VBSCovid.Transformer;

import com.example.VBSCovid.DTO.RequestDTO.DoctorRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.DoctorResponseDto;
import com.example.VBSCovid.Model.Doctor;

public class DoctorTransformer {

    public static Doctor DoctorRequestDtoDotcor(DoctorRequestDto doctorRequestDto){

        return Doctor.builder()
                .age(doctorRequestDto.getAge())
                .name(doctorRequestDto.getName())
                .gender(doctorRequestDto.getGender())
                .emailId(doctorRequestDto.getEmailId())
                .build();
    }

    public static DoctorResponseDto DoctorDtoDotcorResponseDto(Doctor doctor){

        return DoctorResponseDto.builder()
                .age(doctor.getAge())
                .name(doctor.getName())
                .gender(doctor.getGender())
                .emailId(doctor.getEmailId())
                .build();
    }
}
