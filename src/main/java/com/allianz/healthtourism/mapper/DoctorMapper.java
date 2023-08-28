package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.model.requestDTO.doctor.DoctorRequestDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper extends IBaseMapper<DoctorEntity, DoctorDTO, DoctorRequestDTO> {

    @Override
    default DoctorEntity requestDtoToExistEntity(DoctorEntity entity, DoctorRequestDTO requestDTO) {
        entity.setName(requestDTO.getName());
        entity.setSurname(requestDTO.getSurname());
        entity.setBirthDate(requestDTO.getBirthDate());
        entity.setGender(requestDTO.getGender());
        entity.setPhoneNumber(requestDTO.getPhoneNumber());
        entity.setEmail(requestDTO.getEmail());
        entity.setProfession(requestDTO.getProfession());
        return entity;
    }

}
