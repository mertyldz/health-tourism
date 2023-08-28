package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.model.requestDTO.plane.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaneMapper extends IBaseMapper<PlaneEntity, PlaneDTO, PlaneRequestDTO> {
    @Override
    default PlaneEntity requestDtoToExistEntity(PlaneEntity entity, PlaneRequestDTO requestDTO) {
        entity.setModel(requestDTO.getModel());
        entity.setAirline(requestDTO.getAirline());
        return entity;
    }
}
