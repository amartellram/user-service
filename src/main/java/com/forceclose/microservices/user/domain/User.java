package com.forceclose.microservices.user.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class User implements Serializable {
    @Id
    private String id;
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;
}
