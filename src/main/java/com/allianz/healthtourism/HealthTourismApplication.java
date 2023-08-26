package com.allianz.healthtourism;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.database.repository.HospitalRepository;
import com.allianz.healthtourism.database.repository.PatientRepository;
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
import java.util.UUID;

@SpringBootApplication
@EnableJpaAuditing
public class HealthTourismApplication implements CommandLineRunner {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    public static void main(String[] args) {
        SpringApplication.run(HealthTourismApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//
//        // Create Patient & Add Reservation-Examination
//        PatientEntity patient = new PatientEntity();
//        patient.setName("Mert");
//        patient.setSurname("Yıldız");
//        patient.setAddress("Kağıthane");
//        patient.setEmail("mert@gmail.com");
//        patient.setPhoneNumber("+9053283123");
//        patient.setGender(GenderEnum.MALE);
//        LocalDate date = LocalDate.of(1996, Month.JULY, 29);
//        patient.setBirthDate(date);
//        patientRepository.save(patient);
//
//        // Create Doctor & Add Reservation-Hospital
//        DoctorEntity doctor = new DoctorEntity();
//        doctor.setName("Bora");
//        doctor.setSurname("Sarıoğlu");
//        doctor.setEmail("bora@gmail.com");
//        doctor.setPhoneNumber("+9053283123");
//        doctor.setGender(GenderEnum.MALE);
//        doctor.setBirthDate(LocalDate.of(1996, Month.FEBRUARY, 12));
//        doctor.setProfession(ProfessionEnum.PSYCHIATRY);
//        doctorRepository.save(doctor);
//
//        // Create hospital
//        HospitalEntity hospital = new HospitalEntity();
//        hospital.setName("Liv");
//        hospital.setEmail("info@liv.com");
//        hospital.setAddress("Ulus");
//        hospital.setPhoneNumber("+90123123");
//
//        // Add profession to Hospital
//        List<ProfessionEnum> professionEnumList = new ArrayList<>();
//        professionEnumList.add(ProfessionEnum.PSYCHIATRY);
//        professionEnumList.add(ProfessionEnum.ENT);
//        hospital.setProfessionList(professionEnumList);
//        hospitalRepository.save(hospital);

//        HospitalEntity hospital2 = hospitalRepository.findById(1L).orElse(null);
//        System.out.println(hospital2);
//        DoctorEntity doctor2 = doctorRepository.findById(1L).orElse(null);
//        System.out.println(doctor2);
//        doctor2.setHospital(hospital2);
//        System.out.println("################ Set ############");
//        System.out.println(doctor2);
//        System.out.println(hospital2);
//        // Inserted again?? WHY?
//        doctorRepository.save(doctor2);

        // Create plane
        PlaneEntity plane = new PlaneEntity();
        plane.setAirline("THY");
        plane.setModel("Boeing");
//        plane.setDepartureTime(LocalDateTime.of);


    }
}
