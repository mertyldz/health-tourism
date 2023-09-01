package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {
    private String name;
    private String city;
    private String phoneNumber;
    private String email;
    private List<ProfessionEnum> professionList;
    private List<DoctorDTO> doctorList;

}
