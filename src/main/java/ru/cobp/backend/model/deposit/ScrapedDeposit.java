package ru.cobp.backend.model.deposit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.currency.Currency;

@Entity
@Table(name = "scraped_deposits")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ScrapedDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bank_bic")
    private Bank bank;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "product_url", length = 100)
    private String productUrl;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "currency_num")
    private Currency currency;

    @Column(name = "amount_min")
    private Integer amountMin;

    @Column(name = "amount_max")
    private Integer amountMax;

    @Column(name = "term")
    private Integer term;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "capitalization")
    private Boolean capitalization;

    @Column(name = "replenishment")
    private Boolean replenishment;

    @Column(name = "partial_withdrawal")
    private Boolean partialWithdrawal;

}
