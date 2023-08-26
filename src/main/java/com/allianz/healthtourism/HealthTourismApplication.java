package com.allianz.healthtourism;

import com.allianz.healthtourism.database.entity.*;
import com.allianz.healthtourism.database.repository.*;
import com.allianz.healthtourism.model.enums.GenderEnum;
import com.allianz.healthtourism.model.enums.ProfessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class HealthTourismApplication implements CommandLineRunner {
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
    ReservationRepository reservationRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ExaminationRepository examinationRepository;

    public static void main(String[] args) {
        SpringApplication.run(HealthTourismApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        generatePatient();
        generateDoctor();
        generateHospital();
        addDoctorToHospital();


//
//        // Create plane
//        PlaneEntity plane = new PlaneEntity();
//        plane.setAirline("THY");
//        plane.setModel("Boeing");
//        plane.setDepartureTime(LocalDateTime.of(2023, Month.JULY, 29,14,15));
//        plane.setDepartureCity("Berlin");
//        plane.setArrivalCity("İstanbul");
//        planeRepository.save(plane);
//
//        // Create Flight
//        FlightEntity flight = new FlightEntity();
//        flight.setFlightNo("AZXC1234");
//        flightRepository.save(flight);
//
//        // Add flight-plane relation
//        PlaneEntity plane1 = planeRepository.findById(1L).orElse(null);
//        FlightEntity flight1 = flightRepository.findById(1L).orElse(null);
//        if (plane1 != null && flight1 != null) {
//            flight1.setPlane(plane1);
//            flightRepository.save(flight1);
//        }
//
//        System.out.println(plane);
//
//        // Create Hotel
//        HotelEntity hotel = new HotelEntity();
//        hotel.setHotelName("Ramada");
//        hotel.setCity("İstanbul");
//        hotel.setAddress("Nişantaşı");
//        hotel.setTotalCapacity(500);
//        hotel.setTakenCapacity(100);
//        hotelRepository.save(hotel);
//
//        // Create reservation
//        ReservationEntity reservation = new ReservationEntity();
//        reservation.setReservationDate(LocalDate.of(2023, Month.APRIL, 25));
//        reservation.setTreatmentProfession(ProfessionEnum.ENDOCRINOLOGY);
//        reservationRepository.save(reservation);
//
//        // Add relations to reservation
//        ReservationEntity reservation1 = reservationRepository.findById(1L).orElse(null);
//        reservation1.setDoctor(doctorRepository.findById(1L).orElse(null));
//        reservation1.setHotel(hotelRepository.findById(1L).orElse(null));
//        reservation1.setFlight(flightRepository.findById(1L).orElse(null));
//        reservation1.setPatient(patientRepository.findById(1L).orElse(null));
//        reservation1.setHospital(hospitalRepository.findById(1L).orElse(null));
//        reservationRepository.save(reservation1);


//        // Create Examination
//        ExaminationEntity examination = new ExaminationEntity();
//        examination.setDiagnosis("Hair loss");
//        examination.setTreatmentPrescription("Hair transplant");
//        examination.setExaminationDate(LocalDate.of(2023, Month.JULY, 20));
    }

    private void addDoctorToHospital() {
        HospitalEntity hospital2 = hospitalRepository.findById(1L).orElse(null);
        System.out.println(hospital2);
        DoctorEntity doctor2 = doctorRepository.findById(1L).orElse(null);
        System.out.println(doctor2);
        doctor2.setHospital(hospital2);
        System.out.println("################ Set ############");
        System.out.println(doctor2);
        System.out.println(hospital2);
        doctorRepository.save(doctor2);
    }

    private void generateHospital() {
        HospitalEntity hospital = new HospitalEntity();
        hospital.setName("Liv");
        hospital.setEmail("info@liv.com");
        hospital.setAddress("Ulus");
        hospital.setPhoneNumber("+90123123");
        // Add profession to Hospital
        List<ProfessionEnum> professionEnumList = new ArrayList<>();
        professionEnumList.add(ProfessionEnum.PSYCHIATRY);
        professionEnumList.add(ProfessionEnum.ENT);
        hospital.setProfessionList(professionEnumList);
        hospitalRepository.save(hospital);
    }

    private void generateDoctor() {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setName("Bora");
        doctor.setSurname("Sarıoğlu");
        doctor.setEmail("bora@gmail.com");
        doctor.setPhoneNumber("+9053283123");
        doctor.setGender(GenderEnum.MALE);
        doctor.setBirthDate(LocalDate.of(1996, Month.FEBRUARY, 12));
        doctor.setProfession(ProfessionEnum.PSYCHIATRY);
        doctorRepository.save(doctor);
    }

    private void generatePatient() {
        PatientEntity patient = new PatientEntity();
        patient.setName("Mert");
        patient.setSurname("Yıldız");
        patient.setAddress("Kağıthane");
        patient.setEmail("mert@gmail.com");
        patient.setPhoneNumber("+9053283123");
        patient.setGender(GenderEnum.MALE);
        LocalDate date = LocalDate.of(1996, Month.JULY, 29);
        patient.setBirthDate(date);
        patientRepository.save(patient);
    }
}
