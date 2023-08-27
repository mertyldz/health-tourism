package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.*;
import com.allianz.healthtourism.database.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationTestService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    PlaneRepository planeRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ExaminationRepository examinationRepository;

    @Transactional
    public void addRelationsToReservation() {
        // Add relations to reservation
        addReservationToPatient();
        addDoctorToReservation();
        addHotelToReservation();
        addFlightToReservation();
        addHospitalToReservation();
    }

    @Transactional
    public void addHospitalToReservation() {
        ReservationEntity reservation1 = reservationRepository.findById(1L).orElse(null);
        HospitalEntity hospital = hospitalRepository.findById(1L).orElse(null);
        reservation1.setHospital(hospital);
        reservationRepository.save(reservation1);
    }

    private void addFlightToReservation() {
        ReservationEntity reservation1 = reservationRepository.findById(1L).orElse(null);
        FlightEntity flight = flightRepository.findById(1L).orElse(null);
        reservation1.setFlight(flight);
        reservationRepository.save(reservation1);
    }

    private void addHotelToReservation() {
        ReservationEntity reservation1 = reservationRepository.findById(1L).orElse(null);
        HotelEntity hotel = (hotelRepository.findById(1L).orElse(null));
        reservation1.setHotel(hotel);
        reservationRepository.save(reservation1);
    }

    private void addDoctorToReservation() {
        ReservationEntity reservation1 = reservationRepository.findById(1L).orElse(null);
        DoctorEntity doctor = doctorRepository.findById(1L).orElse(null);
        reservation1.setDoctor(doctor);
        reservationRepository.save(reservation1);
    }

    private void addReservationToPatient() {
        ReservationEntity reservation1 = reservationRepository.findById(1L).orElse(null);
        PatientEntity patient = patientRepository.findById(1L).orElse(null);
        patient.setReservation(reservation1);
        patientRepository.save(patient);
        reservationRepository.save(reservation1);
    }
}
