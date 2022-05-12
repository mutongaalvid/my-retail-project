package com.example.demo.Registration;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RegistrationRequest {
    private String FirstName;
    private  String LastName;
    private  String Email;
    private  String Password;
}
