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
    private String id;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant lastModifiedAt;

    private String userId;

    private String serverInstanceAddress;

    public UserPresence(String userId, String serverInstanceAddress) {
        this.userId = userId;
        this.serverInstanceAddress = serverInstanceAddress;
    }
}
