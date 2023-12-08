package ru.cobp.backend.bank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "banks")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bank {

    @Id
    @Column(name = "bic", nullable = false)
    private Long bic;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "legal_entity", nullable = false, length = 100)
    private String legalEntity;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "logotype", nullable = false, length = 254)
    private String logotype;

    @Column(name = "url", nullable = false, length = 100)
    private String url;

}
