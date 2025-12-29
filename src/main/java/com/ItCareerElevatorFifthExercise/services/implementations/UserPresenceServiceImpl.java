package com.ItCareerElevatorFifthExercise.services.implementations;

import com.ItCareerElevatorFifthExercise.DTOs.request.AddUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.DTOs.response.CreateUserPresenceResponseDTO;
import com.ItCareerElevatorFifthExercise.DTOs.response.FetchUserPresenceResponseDTO;
import com.ItCareerElevatorFifthExercise.DTOs.request.RemoveUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.entities.UserPresence;
import com.ItCareerElevatorFifthExercise.exceptions.NoSuchUserPresenceException;
import com.ItCareerElevatorFifthExercise.repositories.UserPresenceRepository;
import com.ItCareerElevatorFifthExercise.services.interfaces.UserPresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserPresenceServiceImpl implements UserPresenceService {

    private final UserPresenceRepository userPresenceRepository;

    @Override
    public CreateUserPresenceResponseDTO addUserWebSocketConnectionServerInstanceAddress(AddUserPresenceRequestDTO requestDTO) {
        UserPresence userPresence = new UserPresence(
                requestDTO.getUserId(),
                requestDTO.getServerInstanceAddress(),
                requestDTO.getSessionId()
        );
        userPresence = save(userPresence);

        return new CreateUserPresenceResponseDTO(userPresence.getUserId());
    }

    @Override
    public void removeUserWebSocketConnectionServerInstanceAddress(RemoveUserPresenceRequestDTO requestDTO) {
        long removedEntries = userPresenceRepository.deleteByUserId(requestDTO.getUserId());

        if (removedEntries == 0) {
            throw new NoSuchUserPresenceException(
                    String.format("No userPresence found with userId %s.", requestDTO.getUserId())
            );
        }

        log.info("Successfully removed userPresence for user with id {}.", requestDTO.getUserId());
    }

    @Override
    public FetchUserPresenceResponseDTO getUserPresenceAddress(String userId) {
        Optional<UserPresence> optionalUserPresence = userPresenceRepository.findByUserId(userId);

        return optionalUserPresence
                .map(userPresence -> new FetchUserPresenceResponseDTO(
                        userPresence.getServerInstanceAddress(),
                        userPresence.getSessionId()
                ))
                .orElseGet(() -> new FetchUserPresenceResponseDTO(
                        null,
                        null)
                );
    }

    @Override
    public UserPresence save(UserPresence userPresence) {
        log.info("Saving userPresence for user with id {}.", userPresence.getUserId());

        return userPresenceRepository.save(userPresence);
    }
}
