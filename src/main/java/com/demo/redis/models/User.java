package com.demo.redis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

    private String userId = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
