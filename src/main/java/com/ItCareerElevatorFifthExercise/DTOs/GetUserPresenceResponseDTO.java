package com.ItCareerElevatorFifthExercise.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserPresenceResponseDTO {

    private String userEmail;

    private String serverInstanceAddress;

    private String sessionId;
}
