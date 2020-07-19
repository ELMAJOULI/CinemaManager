package com.elmajouli.moviestore.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private int active;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Role> roles;

    public Users(Users users) {
        this.active = users.getActive();
        this.email = users.getEmail();
        this.roles = users.getRoles();
        this.name = users.getName();
        this.lastName =users.getLastName();
        this.id = users.getId();
        this.password = users.getPassword();
    }
}