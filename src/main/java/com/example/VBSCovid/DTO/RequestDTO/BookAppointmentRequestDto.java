package com.example.VBSCovid.DTO.RequestDTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookAppointmentRequestDto {

    String personEmail;

    String doctorEmail;

    int centerId;

}
