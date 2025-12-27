package com.ItCareerElevatorFifthExercise.repositories;

import com.ItCareerElevatorFifthExercise.entities.UserPresence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPresenceRepository extends MongoRepository<UserPresence, String> {

    Optional<UserPresence> findByUserId(String userId);

    long deleteByUserId(String userId);
}
