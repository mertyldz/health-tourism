package com.allianz.healthtourism;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.model.enums.GenderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
@EnableJpaAuditing
public class HealthTourismApplication implements CommandLineRunner {
    @Autowired
    PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HealthTourismApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Patient
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
