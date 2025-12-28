package com.ItCareerElevatorFifthExercise.controllers;

import com.ItCareerElevatorFifthExercise.DTOs.response.ErrorResponseDTO;
import com.ItCareerElevatorFifthExercise.exceptions.NoSuchUserPresenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoSuchUserPresenceException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserAlreadyExistsException(NoSuchUserPresenceException ex) {
        log.warn("Handling NoSuchUserPresenceException.");

        ErrorResponseDTO error = new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(error);
    }
}
