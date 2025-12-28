package com.ItCareerElevatorFifthExercise.controllers;

import com.ItCareerElevatorFifthExercise.DTOs.request.AddUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.DTOs.response.CreateUserPresenceResponseDTO;
import com.ItCareerElevatorFifthExercise.DTOs.response.FetchUserPresenceResponseDTO;
import com.ItCareerElevatorFifthExercise.DTOs.request.RemoveUserPresenceRequestDTO;
import com.ItCareerElevatorFifthExercise.services.interfaces.UserPresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{userId}")
    public ResponseEntity<FetchUserPresenceResponseDTO> getUserPresence(@PathVariable String userId) {
        log.info("---> GET request on api/userPresence/{}.", userId);

        var responseDTO = userPresenceService.getUserPresenceAddress(userId);

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<CreateUserPresenceResponseDTO> addUserPresence(@RequestBody AddUserPresenceRequestDTO requestDTO) {
        log.info("---> POST request on api/userPresence for user with id: {}.", requestDTO.getUserId());

        var responseDTO = userPresenceService.addUserWebSocketConnectionServerInstanceAddress(requestDTO);

        return ResponseEntity.created(null).body(responseDTO); // TODO: URL
    }

    @DeleteMapping
    public ResponseEntity<String> removeUserPresence(@RequestBody RemoveUserPresenceRequestDTO requestDTO) {
        log.info("---> DELETE request on api/userPresence for user with id: {}.", requestDTO.getUserId());

        userPresenceService.removeUserWebSocketConnectionServerInstanceAddress(requestDTO);

        return ResponseEntity.ok(
                String.format("Successful removal of userPresence for user with id %s.", requestDTO.getUserId())
        );
    }
}
