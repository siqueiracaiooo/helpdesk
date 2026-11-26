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

        private String normalizeCpf(String cpf){
            if (cpf == null){
                throw new IllegalArgumentException("CPF cannot be null");
            }
            return cpf.replaceAll("\\D", "");
        }

        private int calculateFirstDigit(String cpf){
            int sum = 0;

            for (int i = 0; i<9; i++){
                int digit = Character.getNumericValue(cpf.charAt(i));
                sum += digit * (10 - i);
            }
            int remainder = sum %11;

            if (remainder < 2){
                return 0;
            }
            return 11 - remainder;
        }

         private boolean isValidCpf(String cpf){
            cpf = normalizeCpf(cpf);

            if (cpf.length() != 11) {
                return false;
            }

             return cpf.chars().distinct().count() != 1;
         }


        @Column(nullable = false, unique = true, length = 20)
        private String phoneNumber;

        protected User(){
    }

    public User(String name, String cpf, String phoneNumber) {
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


}