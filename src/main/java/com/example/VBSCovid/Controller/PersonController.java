package com.example.VBSCovid.Controller;

import com.example.VBSCovid.DTO.RequestDTO.PersonRequestDto;
import com.example.VBSCovid.DTO.ResponseDTO.PersonResponseDto;
import com.example.VBSCovid.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody PersonRequestDto personRequestDto){
        try {
            PersonResponseDto responseDto = personService.addPerson(personRequestDto);
            return new ResponseEntity(responseDto, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get")
    public ResponseEntity getPerson(@RequestParam("id") int id){
        try {
            PersonResponseDto responseDto = personService.getPerson(id);
            return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
