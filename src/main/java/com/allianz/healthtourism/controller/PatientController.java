package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.database.specification.PatientSpecification;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.model.requestDTO.patient.PatientAddExaminationRequestDTO;
import com.allianz.healthtourism.model.requestDTO.patient.PatientAddReservationRequestDTO;
import com.allianz.healthtourism.model.requestDTO.patient.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientDTO;
import com.allianz.healthtourism.service.PatientService;
import com.allianz.healthtourism.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<
        PatientEntity,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientRepository,
        PatientSpecification,
        PatientService> {

    @Autowired
    PatientService patientService;

    @Override
    protected PatientService getService() {
        return patientService;
    }

    @PostMapping("add-examination")
    public ResponseEntity<Boolean> addExaminationToPatient(@RequestBody PatientAddExaminationRequestDTO
                                                                   patientAddExaminationRequestDTO) {
        return new ResponseEntity<>(patientService.addPatientToExamination(
                patientAddExaminationRequestDTO.getPatientUuid(),
                patientAddExaminationRequestDTO.getExaminationUuid()),
                HttpStatus.OK);
    }

    @PostMapping("add-reservation")
    public ResponseEntity<Boolean> addReservationToPatient(@RequestBody PatientAddReservationRequestDTO
                                                                   patientAddReservationRequestDTO) {
        return new ResponseEntity<>(patientService.addReservationToPatient(
                patientAddReservationRequestDTO.getPatientUuid(),
                patientAddReservationRequestDTO.getReservationUuid()),
                HttpStatus.OK);
    }

}
