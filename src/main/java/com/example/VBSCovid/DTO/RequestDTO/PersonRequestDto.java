package com.example.VBSCovid.DTO.RequestDTO;

import com.example.VBSCovid.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonRequestDto {

    String name;

    int age;

    String emailId;

    Gender gender;
}