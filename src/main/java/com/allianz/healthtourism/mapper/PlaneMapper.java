package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {FlightMapper.class})
public interface PlaneMapper extends IBaseMapper<PlaneEntity, PlaneDTO, PlaneRequestDTO> {
    @Override
    default PlaneEntity requestDtoToExistEntity(PlaneEntity entity, PlaneRequestDTO requestDTO) {
        entity.setModel(requestDTO.getModel());
        entity.setAirline(requestDTO.getAirline());
        entity.setDepartureCity(requestDTO.getDepartureCity());
        entity.setArrivalCity(requestDTO.getArrivalCity());
        entity.setDepartureTime(requestDTO.getDepartureTime());
        if (requestDTO.getFlight() != null) {
            entity.setFlight(Mappers.getMapper(FlightMapper.class).requestDTOToEntity(requestDTO.getFlight()));
        }
        return entity;
    }
}
