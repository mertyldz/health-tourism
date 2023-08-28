package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.utils.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends IBaseRepository<ReservationEntity> {
    @Query("SELECT r FROM ReservationEntity r WHERE r.approved = FALSE ")
    List<ReservationEntity> findNotApprovedReservations();
}
