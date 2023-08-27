package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.FlightDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PlaneMapper.class, ReservationMapper.class})
public interface FlightMapper extends IBaseMapper<FlightEntity, FlightDTO, FlightRequestDTO> {
    @Override
    default FlightEntity requestDtoToExistEntity(FlightEntity entity, FlightRequestDTO requestDTO) {
        entity.setFlightNo(requestDTO.getFlightNo());
        if (requestDTO.getPlane() != null) {
            entity.setPlane(Mappers.getMapper(PlaneMapper.class).requestDTOToEntity(requestDTO.getPlane()));
        }
        if (requestDTO.getReservationList() != null) {
            entity.setReservationList(Mappers.getMapper(ReservationMapper.class).
                    requestDtoListTOEntityList(requestDTO.getReservationList()));
        }
        return entity;
    }
}
