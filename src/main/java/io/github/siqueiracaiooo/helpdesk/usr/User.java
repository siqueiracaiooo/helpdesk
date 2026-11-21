package io.github.siqueiracaiooo.helpdesk.usr;
import jakarta.persistence.*;


@Entity
@Table(name = "users")

public class User {

    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String passwordHash;
    @Column(nullable = false)
    private boolean active = true;
    // a conta pode ser desativada por um ADM, por isso ela já entra como true,
    // se a conta for desativada, o sistema mantém a memória, porém a conta ficará inutilizável.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;



    protected User(){

    }

    public User(String name, String email, String passwordHash, AccountType accountType) {
        setName(name);
        setEmail(email);
        setPasswordHash(passwordHash);
        setAccountType(accountType);

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
    public void setAccountType(AccountType accountType){
        if (accountType ==null){
            throw new IllegalArgumentException("AccountType cannot be null");
        }
        this.accountType = accountType;
    }
}