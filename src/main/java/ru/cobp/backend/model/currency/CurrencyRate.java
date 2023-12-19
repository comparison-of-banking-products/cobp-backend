package ru.cobp.backend.model.currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "deposits")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "base_num", nullable = false)
    private Currency base;

    @ManyToOne
    @JoinColumn(name = "quote_num", nullable = false)
    private Currency quote;

    @Column(name = "exchange_rate", nullable = false)
    private Double rate;

}
