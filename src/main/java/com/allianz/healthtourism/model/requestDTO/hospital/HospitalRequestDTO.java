package com.allianz.healthtourism.model.requestDTO.hospital;

import com.allianz.healthtourism.model.enums.ProfessionEnum;
import com.allianz.healthtourism.utils.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalRequestDTO extends BaseRequestDTO {
    private String name;
    private String city;
    private String phoneNumber;
    private String email;
    private List<ProfessionEnum> professionList;

}
