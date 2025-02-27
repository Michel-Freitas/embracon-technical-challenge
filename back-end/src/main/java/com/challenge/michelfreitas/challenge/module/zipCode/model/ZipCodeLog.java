package com.challenge.michelfreitas.challenge.module.zipCode.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zipcode_log")
public class ZipCodeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String zipCode;
    private String uf;
    private Date dateTimeConsultation;

    public ZipCodeLog(String zipCode, String uf) {
        this.zipCode = zipCode;
        this.uf = uf;
    }

    @PrePersist
    protected void onCreate() {
        dateTimeConsultation = new Date();
    }
}
