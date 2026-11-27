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

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    private int calculateFirstDigit(String cpf) { //calcula o valor numérico do primeiro dígito de validação do CPF
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (10 - i);
        }

        int remainder = sum % 11;
        if (remainder < 2) {
            return 0;
        }
        return 11 - remainder;
    }

    private String normalizeCpf(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF cannot be null");
        }
        return cpf.replaceAll("\\D", "");
    }

    private int calculateSecondDigit(String cpf) { //calcula o valor numérico do segundo dígito de validação do CPF
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (11 - i);
        }

        int remainder = sum % 11;
        if (remainder < 2) {
            return 0;
        }
        return 11 - remainder;
    }

    private boolean isValidCpf(String cpf) {
        cpf = normalizeCpf(cpf);
        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        int firstDigit = calculateFirstDigit(cpf);

        if (firstDigit != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        int secondDigit = calculateSecondDigit(cpf);

        if (secondDigit != Character.getNumericValue(cpf.charAt(10))) {
            return false;
        }

        return true;
    }


    @Column(nullable = false, length = 20)
    private String phoneNumber;

    protected User() {
    }

    public User(String name, String cpf, String phoneNumber) {
        setName(name);
        setCpf(cpf);
        setPhoneNumber(phoneNumber);
    }

//Getters And Setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        this.name = name;
    }

    public void setCpf(String cpf) {
        cpf = normalizeCpf(cpf);
        boolean valid = isValidCpf(cpf);
        if (!valid){
            throw new IllegalArgumentException("invalidCPF");
        }
            this.cpf = cpf;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }
}
