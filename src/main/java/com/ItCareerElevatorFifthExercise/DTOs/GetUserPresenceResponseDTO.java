package com.ItCareerElevatorFifthExercise.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserPresenceResponseDTO {

    private String serverInstanceAddress;

    private String userEmail;
}
