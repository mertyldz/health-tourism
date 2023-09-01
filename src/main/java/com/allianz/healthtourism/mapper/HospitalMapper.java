package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.model.requestDTO.hospital.HospitalRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HospitalDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, ReservationMapper.class})
public interface HospitalMapper extends IBaseMapper<HospitalEntity, HospitalDTO, HospitalRequestDTO> {
    @Override
    default HospitalEntity requestDtoToExistEntity(HospitalEntity entity, HospitalRequestDTO requestDTO) {
        entity.setName(requestDTO.getName());
        entity.setCity(requestDTO.getCity());
        entity.setPhoneNumber(requestDTO.getPhoneNumber());
        entity.setEmail(requestDTO.getEmail());
        entity.setProfessionList(requestDTO.getProfessionList());
        return entity;
    }
}
