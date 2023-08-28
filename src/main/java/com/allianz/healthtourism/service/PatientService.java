package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.ExaminationEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.database.repository.ExaminationRepository;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.database.repository.ReservationRepository;
import com.allianz.healthtourism.database.specification.PatientSpecification;
import com.allianz.healthtourism.exceptions.RecordNotFoundException;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.model.requestDTO.patient.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientService extends BaseService<
        PatientEntity,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientRepository,
        PatientSpecification> {

    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientSpecification patientSpecification;
    @Autowired
    ExaminationRepository examinationRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return patientRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return patientSpecification;
    }

    public Boolean addPatientToExamination(UUID patientUuid, UUID examinationUuid) {
        PatientEntity patient = patientRepository.findByUuid(patientUuid).orElse(null);
        ExaminationEntity examination = examinationRepository.findByUuid(examinationUuid).orElse(null);
        if (examination == null) {
            throw new RecordNotFoundException("Examination not found!");
        }
        if (patient == null) {
            throw new RecordNotFoundException("Patient is not found!");
        }
        patient.setExamination(examination);
        patientRepository.save(patient);
        return Boolean.TRUE;
    }

    public Boolean addReservationToPatient(UUID patientUuid, UUID reservationUuid) {
        PatientEntity patient = patientRepository.findByUuid(patientUuid).orElse(null);
        ReservationEntity reservation = reservationRepository.findByUuid(reservationUuid).orElse(null);
        if (patient == null) {
            throw new RecordNotFoundException("Patient not found!");
        }
        if (reservation == null) {
            throw new RecordNotFoundException("Reservation is not found!");
        }
        patient.setReservation(reservation);
        patientRepository.save(patient);
        return Boolean.TRUE;
    }
}
