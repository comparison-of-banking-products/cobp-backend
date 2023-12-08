package ru.cobp.backend.currency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "currencies")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Currency {

    @Id
    @Column(name = "num", nullable = false)
    private Integer num;

    @Column(name = "code", length = 3, nullable = false)
    private String code;

    @Column(name = "currency", length = 30, nullable = false)
    private String currency;

}