package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.repository.HotelRepository;
import com.allianz.healthtourism.database.specification.HotelSpecification;
import com.allianz.healthtourism.mapper.HotelMapper;
import com.allianz.healthtourism.model.requestDTO.hotel.HotelRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HotelDTO;
import com.allianz.healthtourism.service.HotelService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<
        HotelEntity,
        HotelDTO,
        HotelRequestDTO,
        HotelMapper,
        HotelRepository,
        HotelSpecification,
        HotelService> {

    @Autowired
    HotelService hospitalService;

    @Override
    protected HotelService getService() {
        return hospitalService;
    }

}
