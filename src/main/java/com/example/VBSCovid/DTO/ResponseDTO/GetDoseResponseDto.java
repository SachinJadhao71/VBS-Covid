package com.example.VBSCovid.DTO.ResponseDTO;


import com.example.VBSCovid.Enum.DoseType;
import com.fasterxml.jackson.databind.DatabindException;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetDoseResponseDto {

    String personName;

    DoseType doseType;

    Date vaccinationDate;

}
