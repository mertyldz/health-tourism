package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
        if (requestDTO.getReservation() != null) {
            entity.setReservation(Mappers.getMapper(ReservationMapper.class).requestDTOToEntity(requestDTO.getReservation()));
        }
        if (requestDTO.getExamination() != null) {
            entity.setExamination(Mappers.getMapper(ExaminationMapper.class).requestDTOToEntity(requestDTO.getExamination()));
        }
        return entity;
    }
}
