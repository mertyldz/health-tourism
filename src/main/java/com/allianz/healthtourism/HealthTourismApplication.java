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
    @Autowired
    RoleEntityRepository roleEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(HealthTourismApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // This generates roles to register
        generateRoles();

    }

    private void generateRoles() {
        RoleEntity userRole = new RoleEntity();
        userRole.setName("USER");
        userRole.setDescription("Basic patient role");
        roleEntityRepository.save(userRole);

        RoleEntity adminRole = new RoleEntity();
        adminRole.setName("ADMIN");
        adminRole.setDescription("Admin role for management of provided services");
        roleEntityRepository.save(adminRole);

        RoleEntity doctorRole = new RoleEntity();
        doctorRole.setName("DOCTOR");
        doctorRole.setDescription("Doctor role for doctors to do their job");
        roleEntityRepository.save(doctorRole);
    }

}
