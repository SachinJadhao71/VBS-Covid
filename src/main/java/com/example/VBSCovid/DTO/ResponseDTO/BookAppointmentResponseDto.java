package com.example.VBSCovid.DTO.ResponseDTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookAppointmentResponseDto {

    String personName;

    String doctorName;

    Date vaccinationDate;

    CenterResponseDto centerDetail;
}
