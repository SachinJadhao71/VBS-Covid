package com.example.VBSCovid.DTO.ResponseDTO;

import com.example.VBSCovid.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonResponseDto {

    String name;

    int age;

    String emailId;

    Gender gender;
}
