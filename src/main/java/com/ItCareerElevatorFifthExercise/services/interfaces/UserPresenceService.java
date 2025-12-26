package com.ItCareerElevatorFifthExercise.services.interfaces;

import com.ItCareerElevatorFifthExercise.DTOs.AddUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.DTOs.RemoveUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.entities.UserPresence;

public interface UserPresenceService {

    void addUserWebSocketConnectionServerInstanceAddress(AddUserPresenceRequestDTO requestDTO);

    void removeUserWebSocketConnectionServerInstanceAddress(RemoveUserPresenceRequestDTO requestDTO);

    UserPresence save(UserPresence userPresence);
}
