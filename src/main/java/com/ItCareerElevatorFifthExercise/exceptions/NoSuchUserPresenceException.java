package com.ItCareerElevatorFifthExercise.exceptions;

public class NoSuchUserPresenceException extends RuntimeException {

    public NoSuchUserPresenceException(String message) {
        super(message);
    }

    public NoSuchUserPresenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
