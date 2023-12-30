package ru.cobp.backend.model.bank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "banks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Bank {

    @Id
    @Column(name = "bic", length = 9, nullable = false)
    private String bic;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "legal_entity", length = 100, nullable = false, unique = true)
    private String legalEntity;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "logo", length = 250, nullable = false)
    private String logo;

    @Column(name = "url", length = 250, nullable = false)
    private String url;

}
