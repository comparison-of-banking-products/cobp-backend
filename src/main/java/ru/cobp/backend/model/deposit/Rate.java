package ru.cobp.backend.model.deposit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "deposit_rates")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deposits_id", nullable = false)
    private Deposit deposit;

    @Column(name = "amount_min", nullable = false)
    private Integer amountMin;

    @Column(name = "amount_max", nullable = false)
    private Integer amountMax;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Column(name = "term_min", nullable = false)
    private Integer termMin;

    @Column(name = "term_max", nullable = false)
    private Integer termMax;

}
