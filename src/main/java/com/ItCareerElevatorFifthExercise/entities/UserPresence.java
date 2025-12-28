package com.ItCareerElevatorFifthExercise.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@ToString
@Document(collection = "users_presence")
public class UserPresence {

    @Id
    private String userId;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant lastModifiedAt;

    private String serverInstanceAddress;

    private String sessionId;

    public UserPresence(String userId, String serverInstanceAddress, String sessionId) {
        this.userId = userId;
        this.serverInstanceAddress = serverInstanceAddress;
        this.sessionId = sessionId;
    }
}
