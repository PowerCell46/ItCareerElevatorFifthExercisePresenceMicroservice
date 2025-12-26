package com.ItCareerElevatorFifthExercise.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddUserPresenceRequestDTO {

    private String userId;

    private String serverInstanceAddress;
}
