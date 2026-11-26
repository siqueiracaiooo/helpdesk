package io.github.siqueiracaiooo.helpdesk.usr;

import jakarta.persistence.*;


@Entity
@Table(name="access_profiles")
public class AccessProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false, unique = true, length = 180)
    private String email;

    protected AccessProfile() {
    }

    public AccessProfile(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("setName cannot be null/blank");
        }
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}