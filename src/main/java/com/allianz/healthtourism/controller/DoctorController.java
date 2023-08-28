package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.database.specification.DoctorSpecification;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.model.requestDTO.doctor.DoctorAddHospitalRequestDTO;
import com.allianz.healthtourism.model.requestDTO.doctor.DoctorAddReservationRequestDTO;
import com.allianz.healthtourism.model.requestDTO.doctor.DoctorRequestDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorDTO;
import com.allianz.healthtourism.service.DoctorService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification,
        DoctorService> {

    @Autowired
    DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return doctorService;
    }

    @PostMapping("add-hospital")
    public ResponseEntity<Boolean> addHospitalToDoctor(@RequestBody DoctorAddHospitalRequestDTO
                                                               doctorAddHospitalRequestDTO) {
        return new ResponseEntity<>(doctorService.
                addHospitalToDoctor(
                        doctorAddHospitalRequestDTO.getDoctorUuid(), doctorAddHospitalRequestDTO.getHospitalUuid()),
                HttpStatus.OK);

    }

    @PostMapping("add-reservation")
    public ResponseEntity<Boolean> addReservationToDoctor(@RequestBody DoctorAddReservationRequestDTO
                                                                  addReservationRequestDTO) {
        return new ResponseEntity<>(doctorService.addReservationToDoctor(addReservationRequestDTO.getDoctorUuid(),
                addReservationRequestDTO.getReservationUuidList()), HttpStatus.OK);
    }

}
