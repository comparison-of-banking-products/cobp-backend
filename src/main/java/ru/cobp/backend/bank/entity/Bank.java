package ru.cobp.backend.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Integer bic;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "legal_entity", length = 100, nullable = false)
    private String legalEntity;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "logo", length = 100, nullable = false)
    private String logo;

    @Column(name = "url", length = 100, nullable = false)
    private String url;

}
