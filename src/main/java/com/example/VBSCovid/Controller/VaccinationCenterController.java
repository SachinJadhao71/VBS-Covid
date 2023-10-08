package com.example.VBSCovid.Controller;

import com.example.VBSCovid.DTO.RequestDTO.CenterRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.CenterResponseDto;
import com.example.VBSCovid.Model.VaccinationCenter;
import com.example.VBSCovid.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService centerService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CenterRequestDto centerRequestDto){
        CenterResponseDto responseDto = centerService.add(centerRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
