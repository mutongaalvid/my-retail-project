package com.example.demo.AppUser;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final static String USER_NOT_FOUND = "user with email  %s not found";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        logger.info("getting user");
        Users user = userRepository.findByUsername(email).orElse(null);

        if(null != user) {
            logger.info("user found ");

            return user;
        }

        logger.info("user not found");
        return null;
//                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
    }

    public Users saveUser(Users users){
        return userRepository.save(users);
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

}
