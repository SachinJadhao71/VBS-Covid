package com.example.VBSCovid.Service;

import com.example.VBSCovid.DTO.RequestDTO.DoctorRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.CenterResponseDto;
import com.example.VBSCovid.DTO.ResponseDTO.DoctorResponseDto;
import com.example.VBSCovid.Exception.CenterNotFoundException;
import com.example.VBSCovid.Model.Doctor;
import com.example.VBSCovid.Model.VaccinationCenter;
import com.example.VBSCovid.Repository.DoctorRepository;
import com.example.VBSCovid.Repository.VaccinationCenterRepository;
import com.example.VBSCovid.Transformer.CenterTransformer;
import com.example.VBSCovid.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository centerRepository;
    public DoctorResponseDto add(DoctorRequestDto doctorRequestDto) {

        Optional<VaccinationCenter> optionalCenter = centerRepository.findById(doctorRequestDto.getCenterId());

        if(optionalCenter.isEmpty()){
            throw new CenterNotFoundException("Center Id is Invalid");
        }

        VaccinationCenter center = optionalCenter.get();

        Doctor doctor = DoctorTransformer.DoctorRequestDtoDotcor(doctorRequestDto);
        doctor.setCenter(center);
        List<Doctor> doctors = center.getDoctorList();
        doctors.add(doctor);

        VaccinationCenter savedCenter = centerRepository.save(center);  // this will save both doctor adn vaccination center

        Doctor savedDoctor = savedCenter.getDoctorList().get(doctors.size()-1);

        DoctorResponseDto responseDto = DoctorTransformer.DoctorDtoDotcorResponseDto(savedDoctor);

        responseDto.setCenterDetail(CenterTransformer.CenterToCenterResponseDto(savedCenter));

        return responseDto;

    }
}
