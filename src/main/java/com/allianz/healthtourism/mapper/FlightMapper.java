package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.model.requestDTO.flight.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.FlightDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper extends IBaseMapper<FlightEntity, FlightDTO, FlightRequestDTO> {

    @Override
    default FlightEntity requestDtoToExistEntity(FlightEntity entity, FlightRequestDTO requestDTO) {
        entity.setFlightNo(requestDTO.getFlightNo());
        entity.setDepartureCity(requestDTO.getDepartureCity());
        entity.setArrivalCity(requestDTO.getArrivalCity());
        entity.setDepartureTime(requestDTO.getDepartureTime());
        return entity;
    }
}
