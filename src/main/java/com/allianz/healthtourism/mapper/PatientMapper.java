package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.model.requestDTO.patient.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ExaminationMapper.class, ReservationMapper.class})
public interface PatientMapper extends IBaseMapper<PatientEntity, PatientDTO, PatientRequestDTO> {
    @Override
    default PatientEntity requestDtoToExistEntity(PatientEntity entity, PatientRequestDTO requestDTO) {
        entity.setName(requestDTO.getName());
        entity.setSurname(requestDTO.getSurname());
        entity.setBirthDate(requestDTO.getBirthDate());
        entity.setGender(requestDTO.getGender());
        entity.setAddress(requestDTO.getAddress());
        entity.setPhoneNumber(requestDTO.getPhoneNumber());
        entity.setEmail(requestDTO.getEmail());
        return entity;
    }
}
