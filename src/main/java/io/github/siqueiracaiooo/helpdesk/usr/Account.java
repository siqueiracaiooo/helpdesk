package io.github.siqueiracaiooo.helpdesk.usr;

import jakarta.persistence.*;


public class Account {
    private String passwordHash;

    @Column(nullable = false)
    private boolean active = true;
// a conta pode ser desativada por um ADM, por isso ela já entra como true,
// se a conta for desativada, o sistema mantém a memória, porém a conta ficará inutilizável.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

//Getters And Setters

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        if (accountType == null) {
            throw new IllegalArgumentException("AccountType cannot be null");
        }
        this.accountType = accountType;
    }
}
