package com.example.VBSCovid.DTO.RequestDTO;


import com.example.VBSCovid.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetDoseRequestDto {

    String PersonEmail;

    DoseType doseType;
}
