package com.ItCareerElevatorFifthExercise;

import com.ItCareerElevatorFifthExercise.entities.UserPresence;
import com.ItCareerElevatorFifthExercise.services.interfaces.UserPresenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final UserPresenceService userPresenceService;

    @Override
    public void run(String... args) {
        log.info("---> Message from CommandLineRunnerImpl...!");

        userPresenceService.save(new UserPresence("N/A", "12"));
    }
}
