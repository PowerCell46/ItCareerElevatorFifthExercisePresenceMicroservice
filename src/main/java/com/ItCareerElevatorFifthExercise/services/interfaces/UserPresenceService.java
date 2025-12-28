package com.ItCareerElevatorFifthExercise.services.interfaces;

import com.ItCareerElevatorFifthExercise.DTOs.request.AddUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.DTOs.response.CreateUserPresenceResponseDTO;
import com.ItCareerElevatorFifthExercise.DTOs.response.FetchUserPresenceResponseDTO;
import com.ItCareerElevatorFifthExercise.DTOs.request.RemoveUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.entities.UserPresence;

public interface UserPresenceService {

    CreateUserPresenceResponseDTO addUserWebSocketConnectionServerInstanceAddress(AddUserPresenceRequestDTO requestDTO);

    void removeUserWebSocketConnectionServerInstanceAddress(RemoveUserPresenceRequestDTO requestDTO);

    FetchUserPresenceResponseDTO getUserPresenceAddress(String userId);

    UserPresence save(UserPresence userPresence);
}
