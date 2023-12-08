package ru.cobp.backend.currency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "currencies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Currency {

    @Id
    @Column(name = "num", nullable = false)
    private Long num;

    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @Column(name = "currency", nullable = false, length = 20)
    private String currency;

}
