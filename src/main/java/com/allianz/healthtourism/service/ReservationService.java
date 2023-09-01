package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.*;
import com.allianz.healthtourism.database.repository.*;
import com.allianz.healthtourism.database.specification.ReservationSpecification;
import com.allianz.healthtourism.exceptions.CapacityException;
import com.allianz.healthtourism.exceptions.RecordNotFoundException;
import com.allianz.healthtourism.mapper.ReservationMapper;
import com.allianz.healthtourism.model.requestDTO.reservation.ReservationRequestDTO;
import com.allianz.healthtourism.model.responseDTO.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationService extends BaseService<
        ReservationEntity,
        ReservationDTO,
        ReservationRequestDTO,
        ReservationMapper,
        ReservationRepository,
        ReservationSpecification> {

    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ReservationSpecification reservationSpecification;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    protected ReservationMapper getMapper() {
        return reservationMapper;
    }

    @Override
    protected ReservationRepository getRepository() {
        return reservationRepository;
    }

    @Override
    protected ReservationSpecification getSpecification() {
        return reservationSpecification;
    }

    public Boolean addHospitalToReservation(UUID reservationUuid, UUID hospitalUuid) {
        ReservationEntity reservation = reservationRepository.findByUuid(reservationUuid).orElse(null);
        HospitalEntity hospital = hospitalRepository.findByUuid(hospitalUuid).orElse(null);
        if (reservation == null) {
            throw new RecordNotFoundException("Reservation is not found!");
        }

        if (hospital == null) {
            throw new RecordNotFoundException("Hospital is not found!");
        }

        reservation.setHospital(hospital);
        reservationRepository.save(reservation);
        return Boolean.TRUE;
    }

    public Boolean addFlightToReservation(UUID reservationUuid, UUID flightUuid) {
        ReservationEntity reservation = reservationRepository.findByUuid(reservationUuid).orElse(null);
        FlightEntity flight = flightRepository.findByUuid(flightUuid).orElse(null);
        if (reservation == null) {
            throw new RecordNotFoundException("Reservation is not found!");
        }

        if (flight == null) {
            throw new RecordNotFoundException("Flight is not found!");
        }
        reservation.setFlight(flight);
        reservationRepository.save(reservation);
        return Boolean.TRUE;
    }

    public Boolean addHotelToReservation(UUID reservationUuid, UUID hotelUuid) {
        ReservationEntity reservation = reservationRepository.findByUuid(reservationUuid).orElse(null);
        HotelEntity hotel = hotelRepository.findByUuid(hotelUuid).orElse(null);
        if (reservation == null) {
            throw new RecordNotFoundException("Reservation is not found!");
        }

        if (hotel == null) {
            throw new RecordNotFoundException("Hotel is not found!");
        }

        if (hotel.getTakenCapacity().equals(hotel.getTotalCapacity())) {
            throw new CapacityException("Hotel capacity is full!");
        }

        hotel.setTakenCapacity(hotel.getTakenCapacity() + 1);
        reservation.setHotel(hotel);
        reservationRepository.save(reservation);
        return Boolean.TRUE;
    }

    public Boolean addDoctorToReservation(UUID reservationUuid, UUID doctorUuid) {
        ReservationEntity reservation = reservationRepository.findByUuid(reservationUuid).orElse(null);
        DoctorEntity doctor = doctorRepository.findByUuid(doctorUuid).orElse(null);
        if (reservation == null) {
            throw new RecordNotFoundException("Reservation is not found!");
        }

        if (doctor == null) {
            throw new RecordNotFoundException("Doctor is not found!");
        }
        reservation.setDoctor(doctor);
        reservationRepository.save(reservation);
        return Boolean.TRUE;
    }

    public Boolean approveReservation(UUID uuid) {
        ReservationEntity reservation = reservationRepository.findByUuid(uuid).orElse(null);
        if (reservation == null) {
            throw new RecordNotFoundException("Reservation is not found!");
        }
        reservation.setApproved(true);
        return Boolean.TRUE;
    }

    @Scheduled(fixedDelay = 5L, timeUnit = TimeUnit.MINUTES)
    public void checkReservations() {
        List<ReservationEntity> reservationList = reservationRepository.findNotApprovedReservations();
        for (ReservationEntity reservation : reservationList) {
            if (!(reservation.getApproved()) && reservation.getCreationDate().plusMinutes(10).isBefore(LocalDateTime.now())) {
                reservationRepository.delete(reservation);
            }
        }
    }
}
