package com.allianz.healthtourism.database.repository;

import com.allianz.healthtourism.database.entity.RoleEntity;
import com.allianz.healthtourism.database.entity.UserEntity;
import com.allianz.healthtourism.utils.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserEntityRepository extends IBaseRepository<UserEntity> {
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT u FROM UserEntity u JOIN FETCH u.roles WHERE u.email = :email")
    UserEntity findUserWithRolesByEmail(@Param("email") String email);
}