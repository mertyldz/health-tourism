package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.RoleEntity;
import com.allianz.healthtourism.utils.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends IBaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}
