package com.ItCareerElevatorFifthExercise.DTOs.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FetchUserPresenceResponseDTO {

    private String serverInstanceAddress;

    private String sessionId;
}
