package com.example.VBSCovid.Controller;

import com.example.VBSCovid.DTO.RequestDTO.GetDoseRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.GetDoseResponseDto;
import com.example.VBSCovid.Service.DoseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/get_Dose1")
    public ResponseEntity getDose1(@RequestBody GetDoseRequestDto requestDto){

        try{
            GetDoseResponseDto responseDto = doseService.getDose1(requestDto);
            return new ResponseEntity(responseDto, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/get_Dose2")
    public ResponseEntity getDose2(@RequestBody GetDoseRequestDto requestDto){
        try{
            GetDoseResponseDto responseDto = doseService.getDose2(requestDto);
            return new ResponseEntity(responseDto, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
