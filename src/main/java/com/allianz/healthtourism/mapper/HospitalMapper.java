package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HospitalDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, ReservationMapper.class})
public interface HospitalMapper extends IBaseMapper<HospitalEntity, HospitalDTO, HospitalRequestDTO> {
    @Override
    default HospitalEntity requestDtoToExistEntity(HospitalEntity entity, HospitalRequestDTO requestDTO) {
        entity.setName(requestDTO.getName());
        entity.setAddress(requestDTO.getAddress());
        entity.setPhoneNumber(requestDTO.getPhoneNumber());
        entity.setEmail(requestDTO.getEmail());
        entity.setProfessionList(requestDTO.getProfessionList());
        if (requestDTO.getDoctorList() != null) {
            entity.setDoctorList(Mappers.getMapper(DoctorMapper.class).
                    requestDtoListTOEntityList(requestDTO.getDoctorList()));
        }
        if (requestDTO.getReservationList() != null) {
            entity.setReservationList(Mappers.getMapper(ReservationMapper.class).
                    requestDtoListTOEntityList(requestDTO.getReservationList()));
        }
        return entity;
    }
}
