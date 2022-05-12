package com.example.demo.AppUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")

public class Users implements UserDetails {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username")
    private String username;


    @Column(name = "email")
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = true;
    private Boolean enabled = true;

    public Users(String name,
                 String username,
                 String email,
                 String password,
                 AppUserRole appUserRole,
                 Boolean locked,
                 Boolean enabled) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority =
            new SimpleGrantedAuthority(appUserRole.name());
    return Collections.singletonList(authority);
}

@Override
public String getPassword() {
    return password;
}

@Override
public String getUsername() {
    return username;
}

@Override
public boolean isAccountNonExpired() {
    return false;
}

@Override
public boolean isAccountNonLocked(){
    return !locked;
}

@Override
public boolean isCredentialsNonExpired(){
    return true;
}

@Override
public boolean isEnabled(){
    return enabled;
}
}