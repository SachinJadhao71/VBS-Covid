package com.example.VBSCovid.DTO.ResponseDTO;

import com.example.VBSCovid.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CenterResponseDto {

    String centerName;

    CenterType centerType;

    String address;
}
