package io.github.siqueiracaiooo.helpdesk.usr;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class User {
        @Column(nullable = false, length = 120)
        private String name;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false, unique = true, length = 180)
        private String email;


        protected User(){
    }

    public User(String name, String email, String passwordHash, AccountType accountType) {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}