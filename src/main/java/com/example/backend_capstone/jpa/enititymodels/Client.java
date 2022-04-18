package com.example.backend_capstone.jpa.enititymodels;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name="client_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="password2", nullable=false)
    private String password2;

    @Column(name="email", nullable = false)
    private String email;


    @OneToMany(targetEntity = Garden.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="User_Gardens",
            joinColumns = @JoinColumn(name="garden_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<Garden> userGardens;

    public Client(){
        this.userGardens = new ArrayList<>();
    }

    public Client(Long clientId, String firstName, String lastName, String username, String password, String password2, String email, List<Garden> userGardens) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.email = email;
        this.userGardens = userGardens;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Garden> getUserGardens() {
        return userGardens;
    }

    public void setUserGardens(List<Garden> userGardens) {
        this.userGardens = userGardens;
    }
}


