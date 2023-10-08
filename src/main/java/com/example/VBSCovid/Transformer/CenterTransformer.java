package com.example.VBSCovid.Transformer;

import com.example.VBSCovid.DTO.RequestDTO.CenterRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.CenterResponseDto;
import com.example.VBSCovid.Model.VaccinationCenter;

public class CenterTransformer {



    public static VaccinationCenter CenterRequestDtoToCenter(CenterRequestDto centerRequestDto){

        return VaccinationCenter.builder()
                .centerName(centerRequestDto.getCenterName())
                .centerType(centerRequestDto.getCenterType())
                .address(centerRequestDto.getAddress())
                .build();
    }

    public static CenterResponseDto CenterToCenterResponseDto(VaccinationCenter center){

        return CenterResponseDto.builder()
                .centerName(center.getCenterName())
                .centerType(center.getCenterType())
                .address(center.getAddress())
                .build();
    }
}
