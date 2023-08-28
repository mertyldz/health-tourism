package com.allianz.healthtourism;

import com.allianz.healthtourism.database.entity.*;
import com.allianz.healthtourism.database.repository.*;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.model.enums.GenderEnum;
import com.allianz.healthtourism.model.enums.ProfessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
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
    @Autowired
    DoctorMapper doctorMapper;

    public static void main(String[] args) {
        SpringApplication.run(HealthTourismApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Data Inserts
//        generatePatient();
//        generateDoctor();
//        generateHospital();
//        addDoctorToHospital();
//        generatePlane();
//        generateFlight();
//        addPlaneToFlight();
//        generateHotel();
//        generateReservation();
//        reservationTestService.addRelationsToReservation();
//        generateExamination();
//        addPatientToExamination();

    }


    private void generateExamination() {
        // Create Examination
        ExaminationEntity examination = new ExaminationEntity();
        examination.setDiagnosis("Hair loss");
        examination.setTreatmentPrescription("Hair transplant");
        examination.setExaminationDate(LocalDateTime.of(2023, Month.JULY, 20, 15, 15));
        examinationRepository.save(examination);
    }

    private void addPatientToExamination() {
        ExaminationEntity examination = examinationRepository.findById(1L).orElse(null);
        PatientEntity patient = patientRepository.findById(1L).orElse(null);
        patient.setExamination(examination);
        patientRepository.save(patient);

    }

    private void generateReservation() {
        // Create reservation
        ReservationEntity reservation = new ReservationEntity();
        reservation.setReservationDate(LocalDateTime.of(2023, Month.APRIL, 25, 14, 15));
        reservation.setTreatmentProfession(ProfessionEnum.ENDOCRINOLOGY);
        reservationRepository.save(reservation);
    }

    private void generateHotel() {
        // Create Hotel
        HotelEntity hotel = new HotelEntity();
        hotel.setHotelName("Ramada");
        hotel.setCity("İstanbul");
        hotel.setAddress("Nişantaşı");
        hotel.setTotalCapacity(500);
        hotel.setTakenCapacity(100);
        hotelRepository.save(hotel);
    }

    private void addPlaneToFlight() {
        // Add flight-plane relation
        PlaneEntity plane1 = planeRepository.findById(1L).orElse(null);
        FlightEntity flight1 = flightRepository.findById(1L).orElse(null);
        if (plane1 != null && flight1 != null) {
            flight1.setPlane(plane1);
            flightRepository.save(flight1);
        }
        System.out.println(plane1);
    }

    private void generateFlight() {
        // Create Flight
        FlightEntity flight = new FlightEntity();
        flight.setFlightNo("AZXC1234");
        flightRepository.save(flight);
    }

    private void generatePlane() {
        // Create plane
        PlaneEntity plane = new PlaneEntity();
        plane.setAirline("THY");
        plane.setModel("Boeing");
        planeRepository.save(plane);
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
        LocalDateTime dateTime = LocalDateTime.of(1996, Month.JULY, 29, 11, 10);
        patient.setBirthDate(dateTime);
        patientRepository.save(patient);
    }
}
