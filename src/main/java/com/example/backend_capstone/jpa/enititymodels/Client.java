package com.example.backend_capstone.jpa.enititymodels;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Column(name="email", nullable = false)
    private String email;


    @OneToMany(targetEntity = Garden.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="User_Gardens",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="garden_id"))
    private List<Garden> userGardens;

    public Client(){
        this.userGardens = new ArrayList<>();
    }

    public Client(Long clientId, String firstName, String lastName, String username, String password, String email, List<Garden> userGardens) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(username, client.username) && Objects.equals(password, client.password) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, firstName, lastName, username, password, email);
    }
}


