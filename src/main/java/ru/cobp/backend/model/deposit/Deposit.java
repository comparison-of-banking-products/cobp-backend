package ru.cobp.backend.model.deposit;

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
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.currency.Currency;

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
    @JoinColumn(name = "bank_bic", nullable = false)
    private Bank bank;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "product_url", length = 250, nullable = false)
    private String productUrl;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "currency_num", nullable = false)
    private Currency currency;

    @Column(name = "amount_min", nullable = false)
    private Integer amountMin;

    @Column(name = "amount_max", nullable = false)
    private Integer amountMax;

    @Column(name = "term", nullable = false)
    private Integer term;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Column(name = "capitalization", nullable = false)
    private Boolean capitalization;

    @Column(name = "replenishment", nullable = false)
    private Boolean replenishment;

    @Column(name = "partial_withdrawal", nullable = false)
    private Boolean partialWithdrawal;

}
