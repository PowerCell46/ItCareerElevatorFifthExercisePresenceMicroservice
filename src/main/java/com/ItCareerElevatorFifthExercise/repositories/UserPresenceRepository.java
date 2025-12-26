package com.ItCareerElevatorFifthExercise.repositories;

import com.ItCareerElevatorFifthExercise.entities.UserPresence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPresenceRepository extends MongoRepository<UserPresence, String> {

    UserPresence findByUserId(String userId);
}
