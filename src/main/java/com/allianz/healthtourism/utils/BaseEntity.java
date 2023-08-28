package com.allianz.healthtourism.utils;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@MappedSuperclass
@Data
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID uuid;

    @CreatedDate
    private LocalDateTime creationDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    // This will be added after security
//    @CreatedBy
//    private String createdBy;


    @PrePersist
    protected void onCreate() {
        setUuid(UUID.randomUUID());

        // This will be added after security
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        String username = "";
//        if (authentication == null || !authentication.isAuthenticated()) {
//            username = "anonymous";
//        } else {
//            username = authentication.getPrincipal().toString();
//        }
//
//        setCreatedBy(username);

    }


}
