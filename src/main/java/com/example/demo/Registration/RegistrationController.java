package com.example.demo.Registration;

import com.example.demo.AppUser.UserService;
import com.example.demo.AppUser.Users;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "api/v1/registration")
@RequiredArgsConstructor
public class RegistrationController {

    //    private RegistrationService registrationService;
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/save")
    public ResponseEntity<Users> saveUser(@RequestBody Users users) {
        return new ResponseEntity<Users>(userService.saveUser(users), HttpStatus.CREATED);
    }

    @GetMapping("/allusers")
    public List<Users> getUsers() {
        return (List<Users>) userService.getAll();
    }
}