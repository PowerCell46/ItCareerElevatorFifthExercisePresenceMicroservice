package com.ItCareerElevatorFifthExercise.services.interfaces;

import com.ItCareerElevatorFifthExercise.DTOs.AddUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.entities.UserPresence;

public interface UserPresenceService {

    void addUserWebSocketConnectionServerInstanceAddress(AddUserPresenceRequestDTO requestDTO);

    UserPresence save(UserPresence userPresence);
}
