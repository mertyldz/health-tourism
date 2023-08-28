package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.model.requestDTO.reservation.ReservationRequestDTO;
import com.allianz.healthtourism.model.responseDTO.ReservationDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class,
        HospitalMapper.class, HotelMapper.class, FlightMapper.class})
public interface ReservationMapper extends IBaseMapper<ReservationEntity, ReservationDTO, ReservationRequestDTO> {
    @Override
    default ReservationEntity requestDtoToExistEntity(ReservationEntity entity, ReservationRequestDTO requestDTO) {
        entity.setReservationDate(requestDTO.getReservationDate());
        entity.setTreatmentProfession(requestDTO.getTreatmentProfession());


        if (requestDTO.getDoctor() != null) {
            entity.setDoctor(Mappers.getMapper(DoctorMapper.class).requestDTOToEntity(requestDTO.getDoctor()));
        }

        if (requestDTO.getHospital() != null) {
            entity.setHospital(Mappers.getMapper(HospitalMapper.class).requestDTOToEntity(requestDTO.getHospital()));
        }

        if (requestDTO.getHotel() != null) {
            entity.setHotel(Mappers.getMapper(HotelMapper.class).requestDTOToEntity(requestDTO.getHotel()));
        }

        if (requestDTO.getFlight() != null) {
            entity.setFlight(Mappers.getMapper(FlightMapper.class).requestDTOToEntity(requestDTO.getFlight()));
        }

        return entity;

    }

}

