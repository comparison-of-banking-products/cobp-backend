package ru.cobp.backend.deposit.entity;

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
import ru.cobp.backend.banks.entity.Bank;
import ru.cobp.backend.currency.entity.Currency;

@Entity
@Table(name = "deposits")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "banks_bic", nullable = false)
    private Bank bank;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "product_url", length = 250, nullable = false)
    private String productUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "currencies_num", nullable = false)
    private Currency currency;

    @Column(name = "amount_min", nullable = false)
    private Integer amountMin;

    @Column(name = "amountMax", nullable = false)
    private Integer amountMax;

    @Column(name = "rate_min", nullable = false)
    private Double rateMin;

    @Column(name = "rate_max", nullable = false)
    private Double rateMax;

    @Column(name = "term_min", nullable = false)
    private Integer termMin;

    @Column(name = "term_max", nullable = false)
    private Integer termMax;

    @Column(name = "capitalization", nullable = false)
    private Boolean capitalization;

    @Column(name = "interest_payment", nullable = false)
    private Boolean interestPayment;

    @Column(name = "partial_withdrawal", nullable = false)
    private Boolean partialWithdrawal;

    @Column(name = "replenishment", nullable = false)
    private Boolean replenishment;

}
