package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.database.repository.HospitalRepository;
import com.allianz.healthtourism.database.repository.ReservationRepository;
import com.allianz.healthtourism.database.specification.DoctorSpecification;
import com.allianz.healthtourism.exceptions.RecordNotFoundException;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.model.requestDTO.doctor.DoctorRequestDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DoctorService extends BaseService<DoctorEntity, DoctorDTO, DoctorRequestDTO, DoctorMapper, DoctorRepository, DoctorSpecification> {
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DoctorSpecification doctorSpecification;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }

    public Boolean addHospitalToDoctor(UUID doctorUuid, UUID hospitalUuid) {
        DoctorEntity doctor = doctorRepository.findByUuid(doctorUuid).orElse(null);
        HospitalEntity hospital = hospitalRepository.findByUuid(hospitalUuid).orElse(null);
        if (doctor == null || hospital == null) {
            throw new RecordNotFoundException();
        }
        doctor.setHospital(hospital);
        doctorRepository.save(doctor);
        return Boolean.TRUE;
    }

    public Boolean addReservationToDoctor(UUID doctorUuid, List<UUID> reservationUuidList) {
        DoctorEntity doctor = doctorRepository.findByUuid(doctorUuid).orElse(null);
        if (doctor == null) {
            throw new RecordNotFoundException();
        }

        if (doctor.getReservationList() == null) {
            doctor.setReservationList(new ArrayList<>());
        }

        for (UUID reservationUuid : reservationUuidList) {
            ReservationEntity reservation = reservationRepository.findByUuid(reservationUuid).orElse(null);
            if (reservation != null) {
                doctor.getReservationList().add(reservation);
            }
        }

        doctorRepository.save(doctor);
        return Boolean.TRUE;

    }
}
