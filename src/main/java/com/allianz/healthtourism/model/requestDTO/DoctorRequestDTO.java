package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.model.enums.GenderEnum;
import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DoctorRequestDTO extends BaseRequestDTO {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private GenderEnum gender;
    private String phoneNumber;
    private String email;
    private ProfessionEnum profession;

}
