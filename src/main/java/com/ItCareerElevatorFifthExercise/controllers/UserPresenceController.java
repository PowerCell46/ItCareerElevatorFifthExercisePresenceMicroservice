package com.ItCareerElevatorFifthExercise.controllers;

import com.ItCareerElevatorFifthExercise.DTOs.AddUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.services.interfaces.UserPresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/userPresence")
public class UserPresenceController {

    private final UserPresenceService userPresenceService;

    @PostMapping
    public ResponseEntity<String> handleUserPresence(@RequestBody AddUserPresenceRequestDTO requestDTO) {
        log.info("---> POST request on api/userPresence for user with id: {}.", requestDTO.getUserId());

        userPresenceService.addUserWebSocketConnectionServerInstanceAddress(requestDTO);

        return ResponseEntity.created(null).body("Success");
    }

    //@DeleteMapping -> remove user serverInstance
}
