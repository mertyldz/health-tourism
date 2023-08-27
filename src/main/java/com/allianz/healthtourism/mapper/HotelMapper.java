package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HotelDTO;
import com.allianz.healthtourism.utils.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ReservationMapper.class})
public interface HotelMapper extends IBaseMapper<HotelEntity, HotelDTO, HotelRequestDTO> {
    @Override
    default HotelEntity requestDtoToExistEntity(HotelEntity entity, HotelRequestDTO requestDTO) {
        entity.setHotelName(requestDTO.getHotelName());
        entity.setCity(requestDTO.getCity());
        entity.setAddress(requestDTO.getAddress());
        entity.setTakenCapacity(requestDTO.getTakenCapacity());
        entity.setTotalCapacity(requestDTO.getTotalCapacity());
        if (requestDTO.getReservationList() != null) {
            entity.setReservationList(Mappers.getMapper(ReservationMapper.class).
                    requestDtoListTOEntityList(requestDTO.getReservationList()));
        }
        return entity;
    }
}
