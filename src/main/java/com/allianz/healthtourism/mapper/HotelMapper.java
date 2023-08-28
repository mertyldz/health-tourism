package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.model.requestDTO.hotel.HotelRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HotelDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper extends IBaseMapper<HotelEntity, HotelDTO, HotelRequestDTO> {
    @Override
    default HotelEntity requestDtoToExistEntity(HotelEntity entity, HotelRequestDTO requestDTO) {
        entity.setHotelName(requestDTO.getHotelName());
        entity.setCity(requestDTO.getCity());
        entity.setAddress(requestDTO.getAddress());
        entity.setTakenCapacity(requestDTO.getTakenCapacity());
        entity.setTotalCapacity(requestDTO.getTotalCapacity());

        return entity;
    }
}
