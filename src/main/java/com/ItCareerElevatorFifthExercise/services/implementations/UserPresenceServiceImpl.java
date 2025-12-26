package com.ItCareerElevatorFifthExercise.services.implementations;

import com.ItCareerElevatorFifthExercise.entities.UserPresence;
import com.ItCareerElevatorFifthExercise.repositories.UserPresenceRepository;
import com.ItCareerElevatorFifthExercise.services.interfaces.UserPresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserPresenceServiceImpl implements UserPresenceService {

    private final UserPresenceRepository userPresenceRepository;

    @Override
    public UserPresence save(UserPresence userPresence) {
        log.info("Saving presence for user {}.", userPresence.getUserId());

        return userPresenceRepository.save(userPresence);
    }
}
