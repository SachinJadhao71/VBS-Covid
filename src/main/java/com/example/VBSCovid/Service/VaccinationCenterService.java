package com.example.VBSCovid.Service;

import com.example.VBSCovid.DTO.RequestDTO.CenterRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.CenterResponseDto;
import com.example.VBSCovid.Model.VaccinationCenter;
import com.example.VBSCovid.Repository.VaccinationCenterRepository;
import com.example.VBSCovid.Transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository centerRepository;
    public CenterResponseDto add(CenterRequestDto centerRequestDto) {

        VaccinationCenter center = CenterTransformer.CenterRequestDtoToCenter(centerRequestDto);

        VaccinationCenter savedCenter = centerRepository.save(center);

        CenterResponseDto responseDto = CenterTransformer.CenterToCenterResponseDto(savedCenter);

        return responseDto;
    }
}
