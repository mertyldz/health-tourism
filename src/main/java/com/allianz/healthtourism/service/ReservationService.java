package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.*;
import com.allianz.healthtourism.database.repository.*;
import com.allianz.healthtourism.database.specification.ReservationSpecification;
import com.allianz.healthtourism.exceptions.CapacityException;
import com.allianz.healthtourism.exceptions.OrderException;
import com.allianz.healthtourism.exceptions.PaymentException;
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

    @Override
    public ReservationDTO save(ReservationRequestDTO requestDTO) {
        ReservationEntity reservation = reservationMapper.requestDTOToEntity(requestDTO);
        // This fields will not be taken, they have default values!
        reservation.setPrice(0);
        reservation.setApproved(false);
        reservation.setPaid(false);
        reservationRepository.save(reservation);
        return reservationMapper.entityToDTO(reservation);
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

        if (reservation.getPrice() == null) {
            reservation.setPrice(0);
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

        if (reservation.getDoctor() == null) {
            throw new OrderException("Please choose the doctor first!");
        }

        if (flight.getTakenCapacity().equals(flight.getTotalCapacity())) {
            throw new CapacityException("Flight capacity is full!");
        }

        reservation.setPrice(reservation.getPrice() + flight.getPrice());
        flight.setTakenCapacity(flight.getTakenCapacity() + 1);
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

        if (reservation.getFlight() == null) {
            throw new OrderException("Please choose the flight first!");
        }

        if (hotel.getTakenCapacity().equals(hotel.getTotalCapacity())) {
            throw new CapacityException("Hotel capacity is full!");
        }

        reservation.setPrice(reservation.getPrice() + hotel.getPrice());
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

        if (reservation.getHospital() == null) {
            throw new OrderException("Please choose the hospital first!");
        }

        if (doctor.getTakenCapacity().equals(doctor.getTotalCapacity())) {
            throw new CapacityException("Doctor capacity is full!");
        }

        reservation.setPrice(reservation.getPrice() + doctor.getPrice());
        doctor.setTakenCapacity(doctor.getTakenCapacity() + 1);
        reservation.setDoctor(doctor);
        reservationRepository.save(reservation);
        return Boolean.TRUE;
    }

    public Boolean approveReservation(UUID uuid) {
        ReservationEntity reservation = reservationRepository.findByUuid(uuid).orElse(null);
        if (reservation == null) {
            throw new RecordNotFoundException("Reservation is not found!");
        }

        if (reservation.getFlight() == null || reservation.getHospital() == null || reservation.getDoctor() == null || reservation.getHotel() == null
        ) {
            throw new OrderException("Please make all selections to approve reservation!");
        }

        if (!reservation.getPaid()) {
            throw new PaymentException();
        }

        reservation.setApproved(true);
        reservationRepository.save(reservation);
        return Boolean.TRUE;
    }

    public Boolean makePayment(UUID uuid) {
        ReservationEntity reservation = reservationRepository.findByUuid(uuid).orElse(null);
        if (reservation == null) {
            throw new RecordNotFoundException("Reservation is not found!");
        }

        if (reservation.getFlight() == null || reservation.getHospital() == null || reservation.getDoctor() == null || reservation.getHotel() == null
        ) {
            throw new OrderException("Please make all selections to make payment!");
        }

        reservation.setPaid(true);
        reservationRepository.save(reservation);
        return Boolean.TRUE;
    }

    // Check every reservation that is not approved. If creation date is 10 minutes ahead of current time, delete it.
    @Scheduled(fixedDelay = 4L, timeUnit = TimeUnit.MINUTES)
    public void checkReservations() {
        List<ReservationEntity> reservationList = reservationRepository.findNotApprovedReservations();
        for (ReservationEntity reservation : reservationList) {
            if (!(reservation.getApproved()) && reservation.getCreationDate().plusMinutes(10).isBefore(LocalDateTime.now())) {
                if (reservation.getDoctor() != null) {
                    reservation.getDoctor().setTakenCapacity(reservation.getDoctor().getTakenCapacity() - 1);
                }
                if (reservation.getFlight() != null) {
                    reservation.getFlight().setTakenCapacity(reservation.getFlight().getTakenCapacity() - 1);
                }
                if (reservation.getHotel() != null) {
                    reservation.getHotel().setTakenCapacity(reservation.getHotel().getTakenCapacity() - 1);
                }
                reservationRepository.save(reservation);
                reservationRepository.delete(reservation);
            }
        }
    }
}
