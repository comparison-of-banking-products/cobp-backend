package ru.cobp.backend.model.currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;

@Entity
@Table(name = "currency_rates")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "actual_date", nullable = false)
    private LocalDateTime actualDate;

    @ManyToOne
    @JoinColumn(name = "base_num", nullable = false)
    private Currency base;

    @ManyToOne
    @JoinColumn(name = "quote_num", nullable = false)
    private Currency quote;

    @Column(name = "actual_rate", nullable = false)
    private Double actualRate;

    @Column(name = "previous_rate", nullable = false)
    private Double previousRate;

    @Column(name = "previous_date", nullable = false)
    private LocalDateTime previousDate;

    @Formula("actual_rate - previous_rate")
    private Double ratesDifference;

}
