package com.ItCareerElevatorFifthExercise.services.implementations;

import com.ItCareerElevatorFifthExercise.DTOs.AddUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.DTOs.RemoveUserPresenceRequestDTO;
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
    public void addUserWebSocketConnectionServerInstanceAddress(AddUserPresenceRequestDTO requestDTO) {
        UserPresence userPresence = new UserPresence(requestDTO.getUserId(), requestDTO.getServerInstanceAddress());
        save(userPresence);
    }

    @Override
    public void removeUserWebSocketConnectionServerInstanceAddress(RemoveUserPresenceRequestDTO requestDTO) {
        long removedEntries = userPresenceRepository.deleteByUserId(requestDTO.getUserId());

        if (removedEntries == 0) {
            // throw exception and handle it after
            return;
        }

        log.info("Successfully removed userPresence for user with id {}.", requestDTO.getUserId());
    }

    @Override
    public UserPresence save(UserPresence userPresence) {
        log.info("Saving presence for user with id {}.", userPresence.getUserId());

        return userPresenceRepository.save(userPresence);
    }
}
